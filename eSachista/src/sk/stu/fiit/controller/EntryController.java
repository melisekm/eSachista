package sk.stu.fiit.controller;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;
import sk.stu.fiit.utils.EntryConstants;
import sk.stu.fiit.validator.EntryUserValidator;

/**
 * @see Controller
 * @author Martin Melisek
 */
public class EntryController extends Controller {

    private final EntryUserValidator validator;

    public EntryController() {
        this.validator = new EntryUserValidator();
    }

    public int getPripojenyPouzivatel() {
        Pouzivatel loggedIn = this.getUserLoggedIn();
        if (loggedIn instanceof Spravca) {
            return EntryConstants.LOGGED_IN_SPRAVCA;
        } else if (loggedIn instanceof Hrac) {
            return EntryConstants.LOGGED_IN_HRAC;
        }
        return EntryConstants.LOGGED_IN_NOBODY;
    }

    public boolean pripojitHraca(String login, char[] password) {
        ArrayList<Pouzivatel> userDb = this.getPouzivatelia();
        Pouzivatel userLoggedIn = this.validator.checkUserLogin(userDb, login, password);
        if (userLoggedIn == null) {
            return false;
        }
        this.entryService.setUserLoggedIn(userLoggedIn);
        return true;
    }

    public int registerOrg(String nazovOrg, String adresaOrg, int balikId) {
        if (!this.entryService.isSpravcaCreated()) {
            return EntryConstants.SPRAVCA_NEBOL_VYTVORENY;
        }
        if (!this.entryService.isOrgNameAvailable(adresaOrg)) {
            return EntryConstants.MENO_UZ_EXISTUJE;
        }
        this.entryService.registerOrg(nazovOrg, adresaOrg, balikId);
        return EntryConstants.REGISTRACIA_OK;
    }

    public int registerPouzivatel(String meno, String login, char[] password, int typRegistracie) {
        this.loadOrg();
        char[] securedPassword = this.validator.securePassword().stringToHash(password);
        if (typRegistracie == EntryConstants.REGISTRUJ_SPRAVCU) {
            this.entryService.registerSpravca(meno, login, securedPassword);
        } else {
            ArrayList<Pouzivatel> userDb = this.getPouzivatelia();
            boolean usernameTaken = this.validator.checkUsernameAvailability(userDb, login);
            if (!usernameTaken) {
                return EntryConstants.MENO_UZ_EXISTUJE;
            }
            boolean kapacita = this.entryService.registerHrac(meno, login, securedPassword);
            if (!kapacita) {
                return EntryConstants.KAPACITA_PREKROCENA;
            }
        }
        this.saveOrg();
        return EntryConstants.REGISTRACIA_OK;
    }

    public String getDetailyRegistracieOrg(String nazovOrg, String adresaOrg, int balikId) {
        Spravca spravcaOrg = this.entryService.getSpravcaTemp();
        StringBuilder sb = new StringBuilder();

        if (spravcaOrg != null) {
            sb.append(spravcaOrg.toString());
            if (spravcaOrg.getEmail() != null) {
                sb.append("E-mail: ").append(spravcaOrg.getEmail()).append("\n");
            }
        } else {
            sb.append("Vyplnte Údaje o správcovi\n");
        }
        if (!nazovOrg.isBlank() && !adresaOrg.isBlank()) {
            sb.append("\nOrganizácia\n");
            sb.append("Názov: ").append(nazovOrg).append("\n");
            sb.append("Adresa: ").append(adresaOrg).append("\n\n");
        } else {
            sb.append("\nVyplnte všetky udaje o organizácií­.\n");
        }

        Balik vybratyBalik = this.getBalik(balikId);
        sb.append(vybratyBalik.toString());
        return sb.toString();
    }

    public Balik getBalik(int index) {
        return this.entryService.getBalik(index);
    }

    public void clearSpravca() {
        this.entryService.setSpravcaTemp(null);
    }

    public boolean pripojitOrganizaciu(String adresa) {
        return this.entryService.pripojOrganizaciu(adresa);
    }

    public String getOrgName() {
        return this.entryService.getOrgLoggedIn().getNazov();
    }
}
