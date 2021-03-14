package sk.stu.fiit.controller.sevice;

import sk.stu.fiit.database.Database;
import sk.stu.fiit.model.organisation.Organizacia;

/**
 *
 * @author Martin Melisek
 */
public class Service {

    private Database db;
    private Organizacia loggedIn;

    public Service() {
        this.db = Database.getInstance();
    }

    public boolean pripojOrganizaciu(String adresa) {
        for (Organizacia org : this.db.getOrganizacie()) {
            if (org.getUrlAdresa().equals(adresa)) {
                this.loggedIn = org;
                return true;
            }
        }
        return false;
    }

    public Organizacia getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Organizacia loggedIn) {
        this.loggedIn = loggedIn;
    }

}
