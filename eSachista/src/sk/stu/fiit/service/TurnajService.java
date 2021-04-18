package sk.stu.fiit.service;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.XMLTurnajModifier;
import sk.stu.fiit.io.XMLTurnajWriter;
import sk.stu.fiit.model.organisation.clients.Hrac;
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
            default:
                throw new AssertionError();
        }
    }

    private boolean advanceRoundRobin(Turnaj turnaj) {
        logger.info("posuvam roundrobin turnaj do dalsieho kola");
        RoundRobinStage stage = (RoundRobinStage) turnaj.getStage();
        if (stage.getKolo() == stage.getPocetKol()) {
            turnaj.setFinished(true);
            logger.info("Uz bolo odohrane posledne kolo. " + stage.getKolo() + "/" + stage.getPocetKol());
            return false;
        }
        stage.getParovanie().clear();
        int hracIdx = stage.getKolo() % stage.getPocetHracov();
        stage.getParovanie().put(stage.getZoznamHracov().get(hracIdx), 0);
        for (int idx = 1; idx < stage.getPolCas(); idx++) {
            int prvyHrac = (stage.getKolo() + idx) % stage.getPocetHracov();
            int druhyHrac = (stage.getKolo() + stage.getPocetHracov() - idx) % stage.getPocetHracov();
            stage.getParovanie().put(stage.getZoznamHracov().get(prvyHrac), stage.getZoznamHracov().get(druhyHrac));
        }
        logger.info("posunul som roundrobin kolo z " + stage.getKolo() + " na " + String.valueOf((stage.getKolo() + 1)));
        stage.setKolo(stage.getKolo() + 1);
        return true;

    }

    public void modifikujVysledok(Turnaj turnaj, Zapas zapas, int turnajId) {
        turnaj.getStage().getTabulka().get(zapas.getVyherca())[1]++;
        turnaj.getStage().getTabulka().get(zapas.getHrac1())[0]++;
        turnaj.getStage().getTabulka().get(zapas.getHrac2())[0]++;

        zapas.getHrac1().setELO(this.modifikujELO(zapas.getHrac1(), zapas.getHrac2(), zapas.getVyherca()));
        zapas.getHrac2().setELO(this.modifikujELO(zapas.getHrac2(), zapas.getHrac1(), zapas.getVyherca()));

        String dir = "resources/turnaje/" + turnajId;
        logger.info("Upravujem vysledok v harmonograme " + dir);
        String path = dir + "/harmonogram.xml";
        logger.info("cesta " + path);
        int idx = 0;
        for (Hrac hrac : turnaj.getHraci()) {
            if (hrac == zapas.getVyherca()) {
                break;
            }
            idx++;
        }

        XMLTurnajModifier xmlTurnajModifier = new XMLTurnajModifier(path);
        xmlTurnajModifier.modifyXML(String.valueOf(idx));
    }

    /**
     * @see
     * https://github.com/radoneman/elo-rating-multiplayer/blob/master/src/com/elo/EloRating.java
     */
    private int modifikujELO(Hrac hrac1, Hrac hrac2, Hrac vyherca) {
        double actualScore;
        if (hrac1 == vyherca) {
            actualScore = 1.0;
        } else {
            actualScore = 0;
        }

        // calculate expected outcome
        double exponent = (double) (hrac2.getELO() - hrac1.getELO()) / 400;
        double expectedOutcome = (1 / (1 + (Math.pow(10, exponent))));

        // K-factor
        int K = 32;

        // calculate new rating
        int newRating = (int) Math.round(hrac1.getELO() + K * (actualScore - expectedOutcome));

        return newRating;
    }
}
