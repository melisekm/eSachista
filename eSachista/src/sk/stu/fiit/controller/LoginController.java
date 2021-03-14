package sk.stu.fiit.controller;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.utils.LoginConstants;
import sk.stu.fiit.validator.EntryValidator;

/**
 * @see Controller
 * @author Martin Melisek
 */
public class LoginController extends Controller{

    private EntryValidator validator;

    public LoginController() {
        this.validator = new EntryValidator();
    }

    public boolean pripojitOrganizaciu(String adresa) {
        return this.service.pripojOrganizaciu(adresa);
    }

    public String getOrgName() {
        return this.service.getOrgLoggedIn().getNazov();
    }

    public int getUserLoggedIn() {
        Pouzivatel loggedIn = this.service.getUserLoggedIn();
        if (loggedIn instanceof Spravca) {
            return LoginConstants.LOGGED_IN_SPRAVCA;
        } else if (loggedIn instanceof Hrac) {
            return LoginConstants.LOGGED_IN_HRAC;
        }
        return LoginConstants.LOGGED_IN_NOBODY;
    }

    public boolean pripojitHraca(String login, char[] password) {
        ArrayList<Pouzivatel> userDb = this.service.getOrgLoggedIn().getPouzivatelia();
        Pouzivatel userLoggedIn = this.validator.checkUserLogin(userDb, login, password);
        if (userLoggedIn == null) {
            return false;
        }
        this.service.setUserLoggedIn(userLoggedIn);
        return true;
    }

    public int registerPlayer(String meno, String login, char[] password) {
        ArrayList<Pouzivatel> userDb = this.service.getOrgLoggedIn().getPouzivatelia();
        boolean usernameTaken = this.validator.checkUsernameRegistration(userDb, login);
        if(!usernameTaken){
            return LoginConstants.MENO_UZ_EXISTUJE;
        }
        boolean kapacita = this.service.registerUser(meno, login, this.validator.securePassword().stringToHash(password));
        if(!kapacita){
            return LoginConstants.KAPACITA_PREKROCENA;
        }
        return LoginConstants.REGISTRACIA_OK;
    }

}
