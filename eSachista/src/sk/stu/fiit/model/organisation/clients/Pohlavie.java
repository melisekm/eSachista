package sk.stu.fiit.model.organisation.clients;

import java.io.Serializable;

/**
 *
 * @author Martin Melisek
 */
public enum Pohlavie implements Serializable{
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
