package sk.stu.fiit.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajObmedzenia;
import sk.stu.fiit.utils.PlatformConstants;

/**
 *
 * @author Martin Melisek
 */
public class HracController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(HracController.class);

    public HracController() {
    }

    public int prihlasHracaNaTurnaj(Turnaj t) {
        this.loadOrg();
        t = this.reloadTurnaj(t);
        if (t == null) {
            logger.error("Nebolo mozne najst turnaj, na ktory sa chcel hrac prihlasit po nacitani Org zo suboru.");
            return PlatformConstants.INA_CHYBA;
        }

        logger.info("Hrac " + this.getPrihlasenyHrac().getLogin() + " sa prihlasuje na turnaj " + t.getNazov());
        int validaciaKod = this.zvalidujPrihlasenie(t);
        if (validaciaKod != PlatformConstants.TURNAJ_PRIHLASENIE_OK) {
            logger.info("hracovi sa nepodarilo prihlasit " + validaciaKod);
            return validaciaKod;
        }
        logger.info("Prihlasovanie prebehlo uspesne.");
        t.getHraci().add(this.getPrihlasenyHrac());
        this.getPrihlasenyHrac().getTurnaje().add(t);
        this.saveOrg();
        return PlatformConstants.TURNAJ_PRIHLASENIE_OK;
    }

    private int zvalidujPrihlasenie(Turnaj t) {
        boolean isVekMimoRozsah = this.checkVek(t.getObmedzenia().getMaxVek());
        if (isVekMimoRozsah) {
            return PlatformConstants.HRAC_PRILIS_STARY;
        }
        boolean isRatingMimoRozsah = this.checkRating(t.getObmedzenia());
        if (isRatingMimoRozsah) {
            return PlatformConstants.RATING_JE_MIMO_ROZSAH;
        }
        boolean isKapacitaPrekrocena = this.checkKapacita(t);
        if (isKapacitaPrekrocena) {
            return PlatformConstants.KAPACITA_TURNAJA_PREKROCENA;
        }
        return PlatformConstants.TURNAJ_PRIHLASENIE_OK;
    }

    private boolean checkVek(int maxVek) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Bratislava"));
        cal.setTime(this.getPrihlasenyHrac().getDatumNarodenia());
        int vek = this.getPrihlasenyHrac().getVek();
        if (vek > maxVek) {
            logger.info("Hrac narodeny v roku " + cal.get(Calendar.YEAR) + "(" + vek + ") je prilis stary. - Max vek: " + maxVek);
            return true;
        }
        return false;
    }

    private boolean checkRating(TurnajObmedzenia obmedzenie) {
        int hracRating = this.getPrihlasenyHrac().getELO();
        boolean isMinRatingMimoRozsah = obmedzenie.getMinRating() > hracRating;
        boolean isMaxRatingMimoRozsah = obmedzenie.getMaxRating() < hracRating;
        if (Boolean.logicalOr(isMinRatingMimoRozsah, isMaxRatingMimoRozsah)) {
            logger.info("Hracov rating " + hracRating + " je mimo rozsah. Rozsah - " + obmedzenie.getRatingObmedzenie());
            return true;
        }
        return false;
    }

    private boolean checkKapacita(Turnaj t) {
        int maxHracovNaTurnaji = this.getOrgLoggedIn().getBalik().getMaxHracovTurnaja();
        boolean jeKapacitaPrekrocena = t.getHraci().size() == maxHracovNaTurnaji;
        if (jeKapacitaPrekrocena) {
            logger.info("Turnajova kapacita je prekrocena.");
            return true;
        }
        return false;
    }

    private boolean checkCiUzNiecoMa(Turnaj turnajZTabulky) {
        for (Turnaj turnajHraca : this.getPrihlasenyHrac().getTurnaje()) {
            if (!turnajHraca.isFinished()) {
                if (isSameDay(turnajHraca.getDatumKonania(), turnajZTabulky.getDatumKonania())) {
                    logger.info("pri kontrole ci hrac uz ma v den turnaja iny "
                            + "turnaj som zistil ze uz ma t z tabulky=" + turnajZTabulky.getNazov() + " a t hraca=" + turnajHraca.getNazov());
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }

    private boolean checkCiJePrihlaseny(Turnaj t) {
        for (Hrac hrac : t.getHraci()) {
            if (hrac.getLogin().equals(this.getPrihlasenyHrac().getLogin())) {
                logger.info("pri kontrole ci je hrac prihlaseny na turnaj som zistil ze uz je.");
                return true;
            }
        }
        return false;
    }

    /**
     * nezobrazi turnaj prihlasenemu hracovi ak<br>
     * turnaj je dohrany<br>
     * turnaj prebieha<br>
     * hrac uz je prihlaseny na turnaj<br>
     * hrac ma uz naplanovany iny turnaj na den konania turnaju t<br>
     *
     * @param t Turnaj ktory sa nema/ma zobrazit
     * @return true ak sa nema, false ak sa ma
     */
    public boolean nezobrazitTurnaj(Turnaj t) {
        return t.isFinished() || new Date().after(t.getDatumKonania()) || this.checkCiJePrihlaseny(t) || this.checkCiUzNiecoMa(t);
    }

    public String[] getStatistiky(Hrac h) {
        String[] res = new String[4];
        int vyhry, prehry;
        vyhry = prehry = 0;
        for (Zapas zapas : h.getZapasy()) {
            if (zapas.getVyherca() == null) {
                continue;
            }
            if (zapas.getVyherca().getLogin().equals(h.getLogin())) {
                vyhry++;
            } else {
                prehry++;
            }
        }
        res[0] = String.valueOf(h.getZapasy().size());
        res[1] = String.valueOf(vyhry);
        res[2] = String.valueOf(prehry);
        res[3] = String.valueOf(h.getTurnaje().size());
        return res;
    }

}
