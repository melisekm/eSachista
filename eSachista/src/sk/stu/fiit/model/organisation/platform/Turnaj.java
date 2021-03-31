package sk.stu.fiit.model.organisation.platform;

import java.util.ArrayList;
import java.util.Date;
import sk.stu.fiit.model.organisation.clients.Hrac;

/**
 *
 * @author Martin Melisek
 */
public class Turnaj {

    private TurnajFormat format;
    private String nazov;
    private String miestoKonania;
    private Date datumKonania;
    private int limitMins;
    private int limitSec;
    private int increment;
    private ArrayList<Hrac> hraci;

    public Turnaj(TurnajFormat format, String nazov, String miestoKonania, Date datumKonania, int limitHrs, int limitSec, int increment) {
        this.format = format;
        this.nazov = nazov;
        this.miestoKonania = miestoKonania;
        this.datumKonania = datumKonania;
        this.limitMins = limitHrs;
        this.limitSec = limitSec;
        this.increment = increment;
        this.hraci = new ArrayList<>();
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

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
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

    public int getLimitMins() {
        return limitMins;
    }

    public void setLimitMins(int limitMins) {
        this.limitMins = limitMins;
    }

    public int getLimitSec() {
        return limitSec;
    }

    public void setLimitSec(int limitSec) {
        this.limitSec = limitSec;
    }

}
