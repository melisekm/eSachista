package sk.stu.fiit.model.organisation.platform.turnaj.stages;

import java.io.Serializable;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class SingleEliminationStage extends Stage implements Serializable{

    public SingleEliminationStage(Turnaj turnaj, int pocetKol) {
        super(turnaj, pocetKol);
    }
}
