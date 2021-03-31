package sk.stu.fiit.model.organisation;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Organizacia {

    private String nazov;
    private String urlAdresa;

    private Balik balik;
    private Spravca organizator;
    private ArrayList<Spravca> spravcovia;
    private ArrayList<Pouzivatel> pouzivatelia;
    private ArrayList<Turnaj> turnaje;

    public Organizacia(String nazov, String adresa, Spravca organizator, Balik balik) {
        this.nazov = nazov;
        this.urlAdresa = adresa;
        this.balik = balik;
        this.organizator = organizator;
        this.spravcovia = new ArrayList<>();
        this.spravcovia.add(organizator);
        this.pouzivatelia = new ArrayList<>();
        this.pouzivatelia.add(organizator);
        this.turnaje = new ArrayList<>();
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getUrlAdresa() {
        return urlAdresa;
    }

    public void setUrlAdresa(String urlAdresa) {
        this.urlAdresa = urlAdresa;
    }

    public Spravca getOrganizator() {
        return organizator;
    }

    public void setOrganizator(Spravca organizator) {
        this.organizator = organizator;
    }

    public ArrayList<Spravca> getSpravcovia() {
        return spravcovia;
    }

    public void setSpravcovia(ArrayList<Spravca> spravcovia) {
        this.spravcovia = spravcovia;
    }

    public ArrayList<Pouzivatel> getPouzivatelia() {
        return pouzivatelia;
    }

    public void setPouzivatelia(ArrayList<Pouzivatel> pouzivatelia) {
        this.pouzivatelia = pouzivatelia;
    }

    public Balik getBalik() {
        return balik;
    }

    public void setBalik(Balik balik) {
        this.balik = balik;
    }

    public ArrayList<Turnaj> getTurnaje() {
        return turnaje;
    }

    public void setTurnaje(ArrayList<Turnaj> turnaje) {
        this.turnaje = turnaje;
    }

}
