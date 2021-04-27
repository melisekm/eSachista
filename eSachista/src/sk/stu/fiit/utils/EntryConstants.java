package sk.stu.fiit.utils;

/**
 * Konstanty, ktore sa pouzivaju pri registracii a prihlaseni do platofrmy
 *
 * @author Martin Melisek
 */
public class EntryConstants {

    public static final int LOGGED_IN_NOBODY = 0;
    public static final int LOGGED_IN_SPRAVCA = 1;
    public static final int LOGGED_IN_HRAC = 2;

    public static final int KAPACITA_PREKROCENA = 0;
    public static final int MENO_UZ_EXISTUJE = 1;
    public static final int REGISTRACIA_OK = 2;
    public static final int SPRAVCA_NEBOL_VYTVORENY = 3;
    public static final int INVALID_EMAIL = 4;

    public static final int REGISTRUJ_SPRAVCU = 0;
    public static final int REGISTRUJ_HRACA = 1;

    public static final int FORM_ERROR = 255;

    private EntryConstants() {
    }
}
