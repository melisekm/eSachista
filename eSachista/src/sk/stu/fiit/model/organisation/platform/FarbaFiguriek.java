package sk.stu.fiit.model.organisation.platform;

import java.io.Serializable;

/**
 * Farba figuriek pri hrani zapasov pre hracov
 * @author Martin Melisek
 */
public enum FarbaFiguriek implements Serializable {
    BIELA {
        @Override
        public String toString() {
            return "Biela";
        }
    },
    CIERNA {
        @Override
        public String toString() {
            return "Èierna";
        }
    }
}
