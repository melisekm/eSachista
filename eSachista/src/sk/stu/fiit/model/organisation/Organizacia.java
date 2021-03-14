package sk.stu.fiit.model.organisation;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;

/**
 *
 * @author Martin Melisek
 */
public class Organizacia {

    private String nazov;
    private String urlAdresa;

    private Spravca organizator;
    private ArrayList<Spravca> spravcovia;
    private ArrayList<Pouzivatel> pouzivatelia;

    public Organizacia(String nazov, String adresa, Spravca organizator) {
        this.nazov = nazov;
        this.urlAdresa = adresa;
        this.organizator = organizator;
        this.spravcovia = new ArrayList<>();
        this.spravcovia.add(organizator);
        this.pouzivatelia = new ArrayList<>();
        this.pouzivatelia.add(organizator);
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
    
    

}
