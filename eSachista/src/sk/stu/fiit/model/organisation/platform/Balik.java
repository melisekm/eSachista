package sk.stu.fiit.model.organisation.platform;

import java.io.Serializable;
import sk.stu.fiit.database.Database;

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
        StringBuilder sb = new StringBuilder();
        sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("BALÕK")).append("\n");
        sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("KAPACITA HR¡»OV: ")).append(kapacitaPouzivatelov).append("\n");
        sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("MAXIMUM TURNAJOV: ")).append(maxPocetTurnajov).append("\n");
        sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("MAXIMUM HR¡»OV NA TURNAJI: ")).append(maxHracovTurnaja).append("\n");
        return sb.toString();
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
