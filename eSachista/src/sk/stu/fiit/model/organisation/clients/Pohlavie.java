package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public enum Pohlavie {
    MUZ {
        @Override
        public String toString() {
            return "Muž";
        }
    },
    ZENA {
        @Override
        public String toString() {
            return "Žena";
        }
    },
    INE {
        @Override
        public String toString() {
            return "Iné";
        }

    }
}
