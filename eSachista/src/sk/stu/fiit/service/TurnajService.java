package sk.stu.fiit.service;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.XMLTurnajWriter;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.RoundRobinStage;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.Stage;

/**
 *
 * @author Martin Melisek
 */
public class TurnajService extends Service {

    private static final Logger logger = LoggerFactory.getLogger(TurnajService.class);

    public boolean advanceTurnaj(Turnaj turnaj) {
        logger.info("Advancujem turnaj dalej");
        if (turnaj.getStage() == null) {
            logger.info("turnaj este nema vygenerovanu stage.");
            turnaj.setStage(this.vygenerujStage(turnaj));
        }
        logger.info("turnaj ma stage.");
        switch (turnaj.getFormat()) {
            case ROUND_ROBIN:
                return advanceRoundRobin(turnaj);
            default:
                throw new AssertionError();
        }

    }

    public void vygenerujHarmonogram(Turnaj t, int turnajId) {
        String dir = "resources/turnaje/" + turnajId;
        logger.info("Zacinam generovat harmonogram " + dir);
        new File(dir).mkdirs();
        String path = dir + "/harmonogram.xml";
        logger.info("cesta " + path);
        XMLTurnajWriter xmlTurnajWriter = new XMLTurnajWriter(path, turnajId);
        xmlTurnajWriter.writeTurnaj(t);
    }

    private Stage vygenerujStage(Turnaj t) {
        logger.info("generujem stage pre turnaj " + t.getNazov());
        switch (t.getFormat()) {
            case ROUND_ROBIN:
                logger.info("jedna sa o RoundRobin Turnaj");
                RoundRobinStage roundRobinStage = new RoundRobinStage(t);
                for (int hracId = 0; hracId < t.getHraci().size(); hracId++) {
                    roundRobinStage.getZoznamHracov().add(hracId);
                }
                if (t.getHraci().size() % 2 != 0) {
                    roundRobinStage.getZoznamHracov().add(-1);
                }
                roundRobinStage.getZoznamHracov().remove(0);
                roundRobinStage.setPocetHracov(roundRobinStage.getZoznamHracov().size());
                return roundRobinStage;
//                case SINGLE_ELIMINATION: TODO
//                    t.setStage(new RoundRobinStage());
//                    break;
//                case SWISS:
//                    t.setStage(new RoundRobinStage());
//                    break;
            default:
                throw new AssertionError();
        }
    }

    private boolean advanceRoundRobin(Turnaj turnaj) {
        logger.info("posuvam roundrobin turnaj do dalsieho kola");
        RoundRobinStage stage = (RoundRobinStage) turnaj.getStage();
        if (stage.getKolo() == stage.getPocetKol()) {
            logger.info("Uz bolo odohrane posledne kolo. " + stage.getKolo() + "/" + stage.getPocetKol());
            return false;
        }
        int hracIdx = stage.getKolo() % stage.getPocetHracov();
        stage.getZapasy().put(stage.getZoznamHracov().get(hracIdx), 0);
        for (int idx = 0; idx < stage.getPolCas(); idx++) {
            int prvyHrac = (stage.getKolo() + idx) % stage.getPocetHracov();
            int druhyHrac = (stage.getKolo() + stage.getPocetHracov() - idx) % stage.getPocetHracov();
            stage.getZapasy().put(prvyHrac, druhyHrac);
        }
        logger.info("posunul som roundrobin kolo z " + stage.getKolo() + " na " + String.valueOf((stage.getKolo() + 1)));
        stage.setKolo(stage.getKolo() + 1);
        return true;

    }
}
