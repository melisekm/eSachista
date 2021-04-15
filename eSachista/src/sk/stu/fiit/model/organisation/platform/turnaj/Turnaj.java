package sk.stu.fiit.model.organisation.platform.turnaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import sk.stu.fiit.model.organisation.clients.Hrac;

/**
 *
 * @author Martin Melisek
 */
public class Turnaj implements Comparable<Turnaj>, Serializable{

    private TurnajFormat format;
    private String nazov;
    private String miestoKonania;
    private Date datumKonania;
    private ArrayList<Hrac> hraci;
    private String popis;
    private TurnajTempoHry tempoHry;
    private TurnajObmedzenia obmedzenia;
    private boolean finished = false; // TODO dopisat do panelov

    @Override
    public int compareTo(Turnaj o) { // na zoradenie podla datumu
        if (this.datumKonania == null || o.getDatumKonania() == null) {
            return 0;
        }
        return this.datumKonania.compareTo(o.getDatumKonania());
    }

    public Turnaj(TurnajFormat format, String nazov, String miestoKonania, Date datumKonania, String popis, TurnajTempoHry tempoHry, TurnajObmedzenia obmedzenia) {
        this.format = format;
        this.nazov = nazov;
        this.miestoKonania = miestoKonania;
        this.datumKonania = datumKonania;
        this.popis = popis;
        this.tempoHry = tempoHry;
        this.obmedzenia = obmedzenia;
        this.hraci = new ArrayList<>();
    }

    public void updateDetails(Turnaj other) {
        this.format = other.format;
        this.nazov = other.nazov;
        this.miestoKonania = other.miestoKonania;
        this.datumKonania = other.datumKonania;
        this.popis = other.popis;
        this.tempoHry = other.tempoHry;
        this.obmedzenia = other.obmedzenia;
    }

    @Override
    public String toString() {
        return nazov + " - " + datumKonania.toString();
    }

    public ArrayList<Hrac> getHraci() {
        return hraci;
    }

    public void setHraci(ArrayList<Hrac> hraci) {
        this.hraci = hraci;
    }

    public TurnajFormat getFormat() {
        return format;
    }

    public void setFormat(TurnajFormat format) {
        this.format = format;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getMiestoKonania() {
        return miestoKonania;
    }

    public void setMiestoKonania(String miestoKonania) {
        this.miestoKonania = miestoKonania;
    }

    public Date getDatumKonania() {
        return datumKonania;
    }

    public void setDatumKonania(Date datumKonania) {
        this.datumKonania = datumKonania;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public TurnajTempoHry getTempoHry() {
        return tempoHry;
    }

    public void setTempoHry(TurnajTempoHry tempoHry) {
        this.tempoHry = tempoHry;
    }

    public TurnajObmedzenia getObmedzenia() {
        return obmedzenia;
    }

    public void setObmedzenia(TurnajObmedzenia obmedzenia) {
        this.obmedzenia = obmedzenia;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

}
