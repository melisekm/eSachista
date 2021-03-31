package sk.stu.fiit.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public void saveTurnaj(TurnajFormat format, String nazov, String miestoKonania,
            Date datum, int casZaciatkuHrs, int casZaciatkuMin,
            int limitMin, int limitSec, int increment, String popis, int minRating,
            int maxRating, int maxVek) throws MaxPocetTurnajovException {
        boolean bolaPrekrocenaKapacita = this.org.getTurnaje().size() >= this.org.getBalik().getMaxPocetTurnajov();
        if (bolaPrekrocenaKapacita) {
            logger.error("Bol presiahnuty maximalny pocet turnajov - " + this.org.getNazov() + " - " + this.org.getTurnaje().size());
            throw new MaxPocetTurnajovException();
        }
        long casKonania = casZaciatkuHrs * 3600 + casZaciatkuMin * 60;
        Date datumKonania = Date.from(datum.toInstant().plusSeconds(casKonania));
        TurnajTempoHry tempoHry = new TurnajTempoHry(limitMin, limitSec, increment);
        TurnajObmedzenia obmedzenia = new TurnajObmedzenia(minRating, maxRating, maxVek);
        Turnaj turnaj = new Turnaj(format, nazov, miestoKonania, datumKonania, popis, tempoHry, obmedzenia);
        this.novyTurnaj = turnaj;
        this.org.getTurnaje().add(novyTurnaj);
    }

    public Turnaj getNovyTurnaj() {
        return novyTurnaj;
    }

    public void setNovyTurnaj(Turnaj novyTurnaj) {
        this.novyTurnaj = novyTurnaj;
    }

}