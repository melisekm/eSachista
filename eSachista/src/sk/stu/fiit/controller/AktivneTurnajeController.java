package sk.stu.fiit.controller;

import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.service.TurnajService;

/**
 *
 * @author Martin Melisek
 */
public abstract class AktivneTurnajeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeController.class);
    protected TurnajService turnajService;

    public AktivneTurnajeController() {
        this.turnajService = new TurnajService();

    }

    public Turnaj getZacatyTurnaj(ArrayList<Turnaj> turnaje) {
        logger.info("Kontrolujem ci prave teraz bezi nejaky turnaj.");
        for (Turnaj turnaj : turnaje) {
            if (!turnaj.isFinished() && turnaj.getDatumKonania().before(new Date())) {
                logger.info("nasiel som turnaj.");
                return turnaj;
            }
        }
        logger.info("Nenasiel som ziadny turnaj");
        return null;
    }

}
