package sk.stu.fiit.model.organisation.platform.turnaj.stages;

import java.io.Serializable;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 * Predstavuje single elimination stage pre turnaj, cize stvrtfinale,
 * semifinale, finale. Ak hrac prehra konci.
 *
 * @author Martin Melisek
 */
public class SingleEliminationStage extends Stage implements Serializable {

    public SingleEliminationStage(Turnaj turnaj, int pocetKol) {
        super(turnaj, pocetKol);
    }
}
