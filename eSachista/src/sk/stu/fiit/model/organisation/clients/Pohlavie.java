package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public enum Pohlavie {
    MUZ {
        @Override
        public String toString() {
            return "Mu�";
        }
    },
    ZENA {
        @Override
        public String toString() {
            return "�ena";
        }
    },
    INE {
        @Override
        public String toString() {
            return "In�";
        }

    }
}
