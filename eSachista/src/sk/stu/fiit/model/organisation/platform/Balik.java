package sk.stu.fiit.model.organisation.platform;

import java.io.Serializable;

/**
 *
 * @author Martin Melisek
 */
public class Balik implements Serializable {

    private String nazov;
    private int kapacitaPouzivatelov;
    private int maxPocetTurnajov;
    private int maxHracovTurnaja;

    public Balik(String nazov, int kapacitaPouzivatelov, int maxPocetTurnajov, int maxPocetPrihlasenych) {
        this.kapacitaPouzivatelov = kapacitaPouzivatelov;
        this.maxPocetTurnajov = maxPocetTurnajov;
        this.maxHracovTurnaja = maxPocetPrihlasenych;
        this.nazov = nazov;
    }

    @Override
    public String toString() {
        return "Balik\n" + "Kapacita hr·Ëov: " + kapacitaPouzivatelov + "\nMaximum turnajov: " + maxPocetTurnajov
                + "\nMaximum hr·Ëov na turnaji: " + maxHracovTurnaja;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getKapacitaPouzivatelov() {
        return kapacitaPouzivatelov;
    }

    public void setKapacitaPouzivatelov(int kapacitaPouzivatelov) {
        this.kapacitaPouzivatelov = kapacitaPouzivatelov;
    }

    public int getMaxPocetTurnajov() {
        return maxPocetTurnajov;
    }

    public void setMaxPocetTurnajov(int maxPocetTurnajov) {
        this.maxPocetTurnajov = maxPocetTurnajov;
    }

    public int getMaxHracovTurnaja() {
        return maxHracovTurnaja;
    }

    public void setMaxHracovTurnaja(int maxHracovTurnaja) {
        this.maxHracovTurnaja = maxHracovTurnaja;
    }

}
