package sk.stu.fiit.service;

import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;

/**
 * Služi ako middle man medzi model a controller
 *
 * @author Martin Melisek
 */
public class EntryService extends Service{

    private static EntryService INSTANCE = new EntryService();

    private Organizacia orgLoggedIn;
    private Pouzivatel userLoggedIn;
    private Spravca spravcaTemp;

    private EntryService() {
    }

    public static EntryService getInstance() {
        return INSTANCE;
    }

    /**
     * Pokusi sa zaregistrovat pouzivatela do organizacie
     *
     * @param meno
     * @param login
     * @param password
     * @return true ak sa to podarilo, false ak nie je uz kapacita
     */
    public boolean registerHrac(String meno, String login, char[] password) {
        Hrac h = new Hrac(this.getOrgLoggedIn(), meno, login, password);
        if (this.orgLoggedIn.getPouzivatelia().size() == this.orgLoggedIn.getBalik().getKapacitaPouzivatelov()) {
            return false;
        }
        this.orgLoggedIn.getPouzivatelia().add(h);
        return true;
    }

    public void registerOrg(String nazovOrg, String adresaOrg, int balikId) {
        Balik b = this.db.getBaliky().get(balikId);
        Spravca organizator = new Spravca(this.spravcaTemp);
        Organizacia o = new Organizacia(nazovOrg, adresaOrg, organizator, b);
        organizator.setOrg(o);
        this.db.getOrganizacie().add(o);
    }

    public void registerSpravca(String meno, String login, char[] password) {
        this.spravcaTemp = new Spravca(meno, login, password);
    }

    public boolean isSpravcaCreated() {
        return true ? this.spravcaTemp != null : false;
    }

    public boolean isOrgNameAvailable(String adresaOrg) {
        for (Organizacia org : this.db.getOrganizacie()) {
            if (org.getUrlAdresa().equals(adresaOrg)) {
                return false;
            }
        }
        return true;
    }

    public boolean pripojOrganizaciu(String adresa) {
        for (Organizacia org : this.db.getOrganizacie()) {
            if (org.getUrlAdresa().equals(adresa)) {
                this.orgLoggedIn = org;
                return true;
            }
        }
        return false;
    }

    public void logOut() {
        this.orgLoggedIn = null;
        this.userLoggedIn = null;
        this.spravcaTemp = null;
    }

    /**
     * Z databazy vrati balik na zaklade ID
     */
    public Balik getBalik(int index) {
        return this.db.getBaliky().get(index);
    }

    public Organizacia getOrgLoggedIn() {
        return orgLoggedIn;
    }

    public void setOrgLoggedIn(Organizacia orgLoggedIn) {
        this.orgLoggedIn = orgLoggedIn;
    }

    public Pouzivatel getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(Pouzivatel userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public Spravca getSpravcaTemp() {
        return spravcaTemp;
    }

    public void setSpravcaTemp(Spravca spravcaTemp) {
        this.spravcaTemp = spravcaTemp;
    }

}
