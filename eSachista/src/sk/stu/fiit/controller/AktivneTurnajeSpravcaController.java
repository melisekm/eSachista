package sk.stu.fiit.controller;

import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class AktivneTurnajeSpravcaController extends AktivneTurnajeController {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeSpravcaController.class);
    private Turnaj prebiehajuciTurnaj;
    
    
    public Turnaj getNadchadzajuciTurnaj() {
        logger.info("Hladam turnaj.");
        for (Turnaj turnaj : this.getTurnaje()) {
            if (!turnaj.isFinished()) {
                logger.info("nasiel som turnaj.");
                return turnaj;
            }
        }
        logger.info("Nenasiel som ziadny turnaj");
        return null;
    }

    public boolean vygenerujHarmonogram(Turnaj t) {
        logger.info("Zacinam generovat turnaj");
        int idx = 0;
        for (Turnaj turnaj : this.getTurnaje()) {
            if (turnaj.getNazov().equals(t.getNazov())) {
                break;
            }
            idx++;
        }
        logger.info("id turnaja je id=" + idx);
        boolean jeTurnajSkonceny = this.turnajService.advanceTurnaj(t) == false;
        if (jeTurnajSkonceny) {
            t.setFinished(true);
            logger.info("negenerujem nic lebo turnaj uz bol skoneceny");
            return false;
        }
        logger.info("generujem harmonogram.");
        this.turnajService.vygenerujHarmonogram(t, idx);
        return true;
    }

    public void aktualizujTurnajUdaje() {
        // TODO
    }

    public Turnaj getPrebiehajuciTurnaj() {
        return prebiehajuciTurnaj;
    }

    public void setPrebiehajuciTurnaj(Turnaj prebiehajuciTurnaj) {
        this.prebiehajuciTurnaj = prebiehajuciTurnaj;
    }

}
