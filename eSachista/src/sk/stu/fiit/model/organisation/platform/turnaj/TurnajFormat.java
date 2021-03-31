package sk.stu.fiit.model.organisation.platform.turnaj;

/**
 *
 * @author Martin Melisek
 */
public enum TurnajFormat {
    ROUND_ROBIN {
        @Override
        public String toString() {
            return "Round Robin";
        }
    },
    SWISS {
        @Override
        public String toString() {
            return "SWISS";
        }

    },
    SINGLE_ELIMINATION {
        @Override
        public String toString() {
            return "Single Elimination";
        }
    };

}
