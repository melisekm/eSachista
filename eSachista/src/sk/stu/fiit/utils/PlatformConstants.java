package sk.stu.fiit.utils;

/**
 * Konstanty, ktore sa pouivaju pri nastaveni prvotneho ELO, a prihlaseni do
 * turnajov
 *
 * @author Martin Melisek
 */
public class PlatformConstants {

    public static final int ZACIATOCNIK_ELO = 800;
    public static final int STREDNE_POKROCILY_ELO = 1500;
    public static final int POKROCILY_ELO = 2000;

    public static final int TURNAJ_PRIHLASENIE_OK = 0;
    public static final int HRAC_PRILIS_STARY = 1;
    public static final int RATING_JE_MIMO_ROZSAH = 2;
    public static final int KAPACITA_TURNAJA_PREKROCENA = 3;
    public static final int INA_CHYBA = 255;

    private PlatformConstants() {
    }
}
