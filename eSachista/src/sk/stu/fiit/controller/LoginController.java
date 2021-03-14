package sk.stu.fiit.controller;

import java.util.ArrayList;
import sk.stu.fiit.controller.sevice.Service;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.utils.Constants;
import sk.stu.fiit.validator.EntryValidator;
import sk.stu.fiit.view.LoginFrame;

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
            return Constants.LOGGED_IN_SPRAVCA;
        } else if (loggedIn instanceof Hrac) {
            return Constants.LOGGED_IN_HRAC;
        }
        return Constants.LOGGED_IN_NOBODY;
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

    public boolean registerPlayer(String meno, String login, char[] password) {
        ArrayList<Pouzivatel> userDb = this.service.getOrgLoggedIn().getPouzivatelia();
        boolean status = this.validator.checkUsernameRegistration(userDb, login);
        this.service.registerUser(meno, login, this.validator.securePassword().stringToHash(password));
        return status;
    }

}
