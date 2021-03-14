package sk.stu.fiit.controller.sevice;

import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;

/**
 *
 * @author Martin Melisek
 */
public class Service {

    private static Service INSTANCE = new Service();

    private Database db;
    private Organizacia orgLoggedIn;
    private Pouzivatel userLoggedIn;

    private Service() {
        this.db = Database.getInstance();
    }

    public static Service getInstance() {
        return INSTANCE;
    }

    public void registerUser(String meno, String login, char[] password) {
        Hrac h = new Hrac(meno, login, password);
        this.orgLoggedIn.getPouzivatelia().add(h);
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

}
