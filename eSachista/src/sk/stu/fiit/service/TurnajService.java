package sk.stu.fiit.service;

import java.util.LinkedHashMap;
import sk.stu.fiit.io.XMLTurnajWriter;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.RoundRobinStage;
import sk.stu.fiit.model.organisation.platform.turnaj.stages.Stage;

/**
 *
 * @author Martin Melisek
 */
public class TurnajService extends Service {

    public boolean advanceTurnaj(Turnaj turnaj) {
        if (turnaj.getStage() == null) {
            turnaj.setStage(this.vygenerujStage(turnaj));
        }
        switch (turnaj.getFormat()) {
            case ROUND_ROBIN:
                return advanceRoundRobin(turnaj);
            default:
                throw new AssertionError();
        }

    }

    public void vygenerujHarmonogram(Turnaj t, int turnajId) {
        XMLTurnajWriter xmlTurnajWriter = new XMLTurnajWriter("resources/turnaje/" + turnajId + "/harmonogram.xml", turnajId);
        
    }

    private Stage vygenerujStage(Turnaj t) {
        switch (t.getFormat()) {
            case ROUND_ROBIN:
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
        RoundRobinStage stage = (RoundRobinStage) turnaj.getStage();
        if (stage.getKolo() == stage.getPocetKol() - 1) {
            return false;
        }
        int hracIdx = stage.getKolo() % stage.getPocetHracov();
        stage.getZapasy().put(stage.getZoznamHracov().get(hracIdx), 0);
        for (int idx = 0; idx < stage.getPolCas(); idx++) {
            int prvyHrac = (stage.getKolo() + idx) % stage.getPocetHracov();
            int druhyHrac = (stage.getKolo() + stage.getPocetHracov() - idx) % stage.getPocetHracov();
            stage.getZapasy().put(prvyHrac, druhyHrac);
        }
        return true;

    }
}
