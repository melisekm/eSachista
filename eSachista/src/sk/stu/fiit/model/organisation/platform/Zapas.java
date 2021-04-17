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
    private FarbaFiguriek hrac1Figurky;
    private FarbaFiguriek hrac2Figurky;

    public Zapas() {
    }

    @Override
    public String toString() {
        return "Zapas{" + "turnaj=" + turnaj + ", hrac1=" + hrac1 + ", hrac2=" + hrac2 + ", casZaciatku=" + casZaciatku + ", vyherca=" + vyherca + ", hrac1Figurky=" + hrac1Figurky + ", hrac2Figurky=" + hrac2Figurky + '}';
    }

    public Zapas(Turnaj turnaj, Hrac hrac1, Hrac hrac2, Date casZaciatku, FarbaFiguriek hrac1Figurky, FarbaFiguriek hrac2Figurky) {
        this.turnaj = turnaj;
        this.hrac1 = hrac1;
        this.hrac2 = hrac2;
        this.casZaciatku = casZaciatku;
        this.hrac1Figurky = hrac1Figurky;
        this.hrac2Figurky = hrac2Figurky;
    }

    public Zapas(Turnaj turnaj, Hrac hrac1, Hrac hrac2, Date casZaciatku, FarbaFiguriek hrac1Figurky, FarbaFiguriek hrac2Figurky, Hrac vyherca) {
        this.turnaj = turnaj;
        this.hrac1 = hrac1;
        this.hrac2 = hrac2;
        this.casZaciatku = casZaciatku;
        this.hrac1Figurky = hrac1Figurky;
        this.hrac2Figurky = hrac2Figurky;
        this.vyherca = vyherca;
    }

    public FarbaFiguriek getHrac1Figurky() {
        return hrac1Figurky;
    }

    public void setHrac1Figurky(FarbaFiguriek hrac1Figurky) {
        this.hrac1Figurky = hrac1Figurky;
    }

    public FarbaFiguriek getHrac2Figurky() {
        return hrac2Figurky;
    }

    public void setHrac2Figurky(FarbaFiguriek hrac2Figurky) {
        this.hrac2Figurky = hrac2Figurky;
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
