package sk.stu.fiit.model.organisation.platform.turnaj;

import java.io.Serializable;

/**
 * Format aky moze turnaj nadobudat, kazdy proti kazdemu alebo single elimination bracket
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
