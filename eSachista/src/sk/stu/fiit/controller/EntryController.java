package sk.stu.fiit.controller;

import java.util.ArrayList;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.io.IOManager;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;
import sk.stu.fiit.utils.EntryConstants;
import sk.stu.fiit.validator.EntryUserValidator;

/**
 * Controller pre EntryFrame, validuje, registruje a pripraja hraca
 *
 * @see Controller
 * @author Martin Melisek
 */
public class EntryController extends Controller {

    private final EntryUserValidator validator;

    public EntryController() {
        this.validator = new EntryUserValidator();
    }

    /**
     * vrati typ pouzivatela
     *
     * @see sk.stu.fiit.utils.EntryConstants
     * @return konstanta z EntryConstants, pre spravcu, hraca a chybu.
     */
    public int getPripojenyPouzivatel() {
        Pouzivatel loggedIn = this.getUserLoggedIn();
        if (loggedIn instanceof Spravca) {
            return EntryConstants.LOGGED_IN_SPRAVCA;
        } else if (loggedIn instanceof Hrac) {
            return EntryConstants.LOGGED_IN_HRAC;
        }
        return EntryConstants.LOGGED_IN_NOBODY;
    }

    /**
     * pripoji hraca do aplikacie
     *
     * @param login prihlasovacie meno
     * @param password nezahashovane heslo
     * @return true ak sa podarilo, false inak
     */
    public boolean pripojitHraca(String login, char[] password) {
        ArrayList<Pouzivatel> userDb = this.getPouzivatelia();
        Pouzivatel userLoggedIn = this.validator.checkUserLogin(userDb, login, password);
        if (userLoggedIn == null) {
            return false;
        }
        this.entryService.setUserLoggedIn(userLoggedIn);
        return true;
    }

    /**
     * zaregistruje organizaciu
     *
     * @param nazovOrg nazov organizacie
     * @param adresaOrg domenova adresa organizacie
     * @param balikId id balika, ktore si vybral spravca
     * @param email email spravcu
     * @see sk.stu.fiit.utils.EntryConstants
     * @return konstanta z EntryConstants, ktora hovori bud o chybe, alebo o tom
     * ze registracia prebehla uspesne
     */
    public int registerOrg(String nazovOrg, String adresaOrg, int balikId, String email) {
        if (!this.validator.validateEmail(email)) {
            return EntryConstants.INVALID_EMAIL;
        }
        if (!this.entryService.isSpravcaCreated()) {
            return EntryConstants.SPRAVCA_NEBOL_VYTVORENY;
        }
        if (!this.entryService.isOrgNameAvailable(adresaOrg)) {
            return EntryConstants.MENO_UZ_EXISTUJE;
        }
        this.entryService.registerOrg(nazovOrg, adresaOrg, balikId, email);
        return EntryConstants.REGISTRACIA_OK;
    }

    /**
     * do oragnizacie zaregistruje hraca
     * @param meno menohraca
     * @param login prihlasovacie meno hraca
     * @param password nezahashovany passwod
     * @param typRegistracie ci sa registruje spravca alebo hrac, pochadza z entryConstants
     * @see sk.stu.fiit.utils.EntryConstants
     * @return stav z EntryConstants o chybe, alebo o tom, ze sa registracia podarila
     */
    public int registerPouzivatel(String meno, String login, char[] password, int typRegistracie) {
        if (typRegistracie == EntryConstants.REGISTRUJ_HRACA) {
            this.ioManager = new IOManager(this.getOrgLoggedIn().getNazov());
            this.loadOrg();
        }
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
        if (typRegistracie == EntryConstants.REGISTRUJ_HRACA) {
            this.saveOrg();
        }
        return EntryConstants.REGISTRACIA_OK;
    }

    /**
     * vrati formatovane detaily pre view o registracie organizacie
     * @param nazovOrg nazov, ktora org sa registruje
     * @param adresaOrg domena organizacie
     * @param balikId balik, ktory si zvolil spravca
     * @return formatovany vystup oddeleny novymi riadkami
     */
    public String getDetailyRegistracieOrg(String nazovOrg, String adresaOrg, int balikId) {
        Spravca spravcaOrg = this.entryService.getSpravcaTemp();
        StringBuilder sb = new StringBuilder();

        if (spravcaOrg != null) {
            sb.append(spravcaOrg.toString());
            if (spravcaOrg.getEmail() != null) {
                sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("E-MAIL: ")).append(spravcaOrg.getEmail()).append("\n");
            }
        } else {
            sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("VYPLÒTE ÚDAJE O SPRÁVCOVI.")).append("\n");
        }
        if (!nazovOrg.isBlank() && !adresaOrg.isBlank()) {
            sb.append("\n").append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("ORGANIZÁCIA")).append("\n");
            sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("NÁZOV: ")).append(nazovOrg).append("\n");
            sb.append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("ADRESA: ")).append(adresaOrg).append("\n\n");
        } else {
            sb.append("\n").append(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("VYPLÒTE VŠETKY ÚDAJE O ORGANIZÁCII.")).append("\n");
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
