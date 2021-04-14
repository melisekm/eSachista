package sk.stu.fiit.controller;

import java.util.Calendar;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        logger.info("Hrac " + this.getPrihlasenyHrac().getLogin() + " sa prihlasuje na turnaj " + t.getNazov());
        int validaciaKod = this.zvalidujPrihlasenie(t);
        if (validaciaKod != PlatformConstants.TURNAJ_PRIHLASENIE_OK) {
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

}
