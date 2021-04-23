package sk.stu.fiit.model.organisation.platform.turnaj;

import java.io.Serializable;

/**
 *
 * @author Martin Melisek
 */
public enum TurnajFormat implements Serializable {
    ROUND_ROBIN {
        @Override
        public String toString() {
            return "Round Robin";
        }
    },
    SINGLE_ELIMINATION {
        @Override
        public String toString() {
            return "Single Elimination";
        }
    };

}
