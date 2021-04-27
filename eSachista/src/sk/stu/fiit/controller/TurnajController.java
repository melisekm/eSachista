package sk.stu.fiit.controller;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.exceptions.InvalidDateException;
import sk.stu.fiit.exceptions.MaxPocetTurnajovException;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajObmedzenia;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajTempoHry;

/**
 * Controller pre vytvaranie a editovanie turnajov
 * @author Martin Melisek
 */
public class TurnajController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(TurnajController.class);
    /**
     * docasne prave vytvarany turnaj
     */
    private Turnaj novyTurnaj;

    public TurnajController() {
        super();
    }
    /**
     * vytvori turnaj na zaklade parametrov
     * @see sk.stu.fiit.model.organisation.platform.turnaj.Turnaj
     */
    public void vytvorTurnaj(TurnajFormat format, String nazov, String miestoKonania,
            Date datum, int casZaciatkuHrs, int casZaciatkuMin,
            int limitMin, int limitSec, int increment, String popis, int minRating,
            int maxRating, int maxVek) throws MaxPocetTurnajovException, InvalidDateException {
        logger.info("Vytvaram turnaj");
        boolean bolaPrekrocenaKapacita = this.getOrgLoggedIn().getTurnaje().size() >= this.getOrgLoggedIn().getBalik().getMaxPocetTurnajov();
        if (bolaPrekrocenaKapacita) {
            logger.error("Bol presiahnuty maximalny pocet turnajov - " + this.getOrgLoggedIn().getNazov() + " - " + this.getOrgLoggedIn().getTurnaje().size());
            throw new MaxPocetTurnajovException();
        }
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Bratislava"));
        cal.setTime(datum);
        cal.set(Calendar.HOUR_OF_DAY, casZaciatkuHrs);
        cal.set(Calendar.MINUTE, casZaciatkuMin);
        cal.set(Calendar.SECOND, 0);

        Date datumKonania = cal.getTime();
        if (new Date().after(datumKonania)) {
            logger.info("Spravca zadal zaciatok turnaja v minulosti");
            throw new InvalidDateException();
        }
        TurnajTempoHry tempoHry = new TurnajTempoHry(limitMin, limitSec, increment);
        TurnajObmedzenia obmedzenia = new TurnajObmedzenia(minRating, maxRating, maxVek);
        Turnaj turnaj = new Turnaj(format, nazov, miestoKonania, datumKonania, popis, tempoHry, obmedzenia);
        this.novyTurnaj = turnaj;
    }
    /**
     * ulozi turnaj do databazy a sortne ich poradie na zaklade datumu.
     * @param novy novovytvoreny turnaj
     */
    public void saveTurnaj(Turnaj novy) {
        this.getOrgLoggedIn().getTurnaje().add(novy);
        Collections.sort(this.getOrgLoggedIn().getTurnaje());
        logger.info("ukladam a sortujem turnaje");
    }
    /**
     * edituje turnaj 
     * @param povodny turnaj ktory sa ma zeditovat
     * @param novy udaje noveho
     */
    public void upravTurnaj(Turnaj povodny, Turnaj novy) {
        povodny.updateDetails(novy);
        Collections.sort(this.getOrgLoggedIn().getTurnaje());
        logger.info("ukladam a sortujem turnaje");

    }

    public Turnaj getNovyTurnaj() {
        return novyTurnaj;
    }

    public void setNovyTurnaj(Turnaj novyTurnaj) {
        this.novyTurnaj = novyTurnaj;
    }

}
