package sk.stu.fiit.model.organisation.clients;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Hrac extends Pouzivatel {

    private int ELO;
    private ArrayList<Turnaj> turnaje;
    private String mesto;
    private String stat;
    private Date datumNarodenia;
    private javax.swing.ImageIcon avatar;
    private Date datumRegistracie;
    private String pohlavie;
    
    public Hrac(Organizacia org, String meno, String login, char[] heslo) {
        super(org, meno, login, heslo);
        this.turnaje = new ArrayList<>();
    }

    @Override
    public String toString() {
        return meno;
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

    public ImageIcon getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public Date getDatumRegistracie() {
        return datumRegistracie;
    }

    public void setDatumRegistracie(Date datumRegistracie) {
        this.datumRegistracie = datumRegistracie;
    }

    public String getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(String pohlavie) {
        this.pohlavie = pohlavie;
    }
    
    
    
    

}
