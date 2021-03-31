package sk.stu.fiit.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.exceptions.InvalidDateException;
import sk.stu.fiit.exceptions.MaxPocetTurnajovException;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajObmedzenia;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajTempoHry;

/**
 *
 * @author Martin Melisek
 */
public class TurnajController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(TurnajController.class);

    private Organizacia org;
    private Turnaj novyTurnaj;

    public TurnajController() {
        if (this.entryService != null) {
            this.org = this.entryService.getOrgLoggedIn();
        }
    }
    
    public void vytvorTurnaj(TurnajFormat format, String nazov, String miestoKonania,
            Date datum, int casZaciatkuHrs, int casZaciatkuMin,
            int limitMin, int limitSec, int increment, String popis, int minRating,
            int maxRating, int maxVek) throws MaxPocetTurnajovException, InvalidDateException {
        boolean bolaPrekrocenaKapacita = this.org.getTurnaje().size() >= this.org.getBalik().getMaxPocetTurnajov();
        if (bolaPrekrocenaKapacita) {
            logger.error("Bol presiahnuty maximalny pocet turnajov - " + this.org.getNazov() + " - " + this.org.getTurnaje().size());
            throw new MaxPocetTurnajovException();
        }
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Bratislava"));
        cal.setTime(datum);
        cal.set(Calendar.HOUR_OF_DAY, casZaciatkuHrs);
        cal.set(Calendar.MINUTE, casZaciatkuMin);
        cal.set(Calendar.SECOND, 0);
        
        Date datumKonania = cal.getTime();
        if(new Date().after(datumKonania)){
            logger.info("Spravca zadal zaciatok turnaja v minulosti");
            throw new InvalidDateException();
        }
        TurnajTempoHry tempoHry = new TurnajTempoHry(limitMin, limitSec, increment);
        TurnajObmedzenia obmedzenia = new TurnajObmedzenia(minRating, maxRating, maxVek);
        Turnaj turnaj = new Turnaj(format, nazov, miestoKonania, datumKonania, popis, tempoHry, obmedzenia);
        this.novyTurnaj = turnaj;
    }
    
    public void saveTurnaj(Turnaj novy){
        this.org.getTurnaje().add(novy);
    }
    
    public void upravTurnaj(Turnaj povodny, Turnaj novy){
        this.getTurnaje().set(this.getTurnaje().indexOf(povodny), novy);
    }

    public Turnaj getNovyTurnaj() {
        return novyTurnaj;
    }

    public void setNovyTurnaj(Turnaj novyTurnaj) {
        this.novyTurnaj = novyTurnaj;
    }

}
