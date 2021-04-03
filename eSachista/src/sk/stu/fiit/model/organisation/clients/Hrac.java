package sk.stu.fiit.model.organisation.clients;

import java.util.ArrayList;
import java.util.Date;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Hrac extends Pouzivatel {

    private boolean firstLogin = true;
    private int ELO;
    private ArrayList<Turnaj> turnaje;
    private String mesto;
    private String stat;
    private Date datumNarodenia;
    private Pohlavie pohlavie;
    private int vek;

    public Hrac(Organizacia org, String meno, String login, char[] heslo) {
        super(org, meno, login, heslo);
        this.turnaje = new ArrayList<>();
    }

    public void updateDetails(Hrac other) {
        super.updateDetails(other);
        this.mesto = other.mesto;
        this.stat = other.stat;
        this.datumNarodenia = other.datumNarodenia;
        this.pohlavie = other.pohlavie;
    }

    @Override
    public String toString() {
        return meno;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public int getELO() {
        return ELO;
    }

    public void setELO(int ELO) {
        this.ELO = ELO;
    }

    public ArrayList<Turnaj> getTurnaje() {
        return turnaje;
    }

    public void setTurnaje(ArrayList<Turnaj> turnaje) {
        this.turnaje = turnaje;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Date getDatumNarodenia() {
        return datumNarodenia;
    }

    public void setDatumNarodenia(Date datumNarodenia) {
        this.datumNarodenia = datumNarodenia;
    }

    public Pohlavie getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }

}
