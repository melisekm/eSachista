package sk.stu.fiit.model.organisation.platform;

import java.io.Serializable;

/**
 *
 * @author Martin Melisek
 */
public class Balik implements Serializable{

    private int kapacitaPouzivatelov;
    private int maxPocetTurnajov;
    private int maxHracovTurnaja;

    public Balik(int kapacitaPouzivatelov, int maxPocetTurnajov, int MaxPocetPrihlasenych) {
        this.kapacitaPouzivatelov = kapacitaPouzivatelov;
        this.maxPocetTurnajov = maxPocetTurnajov;
        this.maxHracovTurnaja = MaxPocetPrihlasenych;
    }

    @Override
    public String toString() {
        return "Balik\n" + "Kapacita hr��ov: " + kapacitaPouzivatelov + "\nMaximum turnajov: " + maxPocetTurnajov
                + "\nMaximum hr��ov na turnaji: " + maxHracovTurnaja;
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
