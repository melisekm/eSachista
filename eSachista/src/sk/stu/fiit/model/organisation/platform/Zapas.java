package sk.stu.fiit.model.organisation.platform;

import java.io.Serializable;
import java.util.Date;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Zapas implements Serializable {

    private Turnaj turnaj;
    private Hrac hrac1;
    private Hrac hrac2;
    private Date casZaciatku;
    private Hrac vyherca;

    public Zapas(Turnaj turnaj, Hrac hrac1, Hrac hrac2, Date casZaciatku) {
        this.turnaj = turnaj;
        this.hrac1 = hrac1;
        this.hrac2 = hrac2;
        this.casZaciatku = casZaciatku;
    }

    public Turnaj getTurnaj() {
        return turnaj;
    }

    public void setTurnaj(Turnaj turnaj) {
        this.turnaj = turnaj;
    }

    public Hrac getHrac1() {
        return hrac1;
    }

    public void setHrac1(Hrac hrac1) {
        this.hrac1 = hrac1;
    }

    public Hrac getHrac2() {
        return hrac2;
    }

    public void setHrac2(Hrac hrac2) {
        this.hrac2 = hrac2;
    }

    public Date getCasZaciatku() {
        return casZaciatku;
    }

    public void setCasZaciatku(Date casZaciatku) {
        this.casZaciatku = casZaciatku;
    }

    public Hrac getVyherca() {
        return vyherca;
    }

    public void setVyherca(Hrac vyherca) {
        this.vyherca = vyherca;
    }
    

}
