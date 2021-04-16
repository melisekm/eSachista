package sk.stu.fiit.model.organisation.platform.turnaj.stages;

import java.io.Serializable;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Stage implements Serializable {

    private Turnaj turnaj;

    public Stage(Turnaj turnaj) {
        this.turnaj = turnaj;
    }

    public Turnaj getTurnaj() {
        return turnaj;
    }

    public void setTurnaj(Turnaj turnaj) {
        this.turnaj = turnaj;
    }

}
