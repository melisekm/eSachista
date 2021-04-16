package sk.stu.fiit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class EntryService extends Service {

    private static final Logger logger = LoggerFactory.getLogger(EntryService.class);

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
        logger.info("Registrujem noveho hraca");
        Hrac h = new Hrac(this.getOrgLoggedIn(), meno, login, password);
        if (this.orgLoggedIn.getPouzivatelia().size() >= this.orgLoggedIn.getBalik().getKapacitaPouzivatelov()) {
            logger.info("Registracia sa nepodarila");
            return false;
        }
        this.orgLoggedIn.getPouzivatelia().add(h);
        logger.info("Registracia sa podarila");
        return true;
    }

    public void registerOrg(String nazovOrg, String adresaOrg, int balikId) {
        logger.info("registrujem organizaciu");
        Balik b = this.getDb().getBaliky().get(balikId);
        Spravca organizator = new Spravca(this.spravcaTemp);
        Organizacia o = new Organizacia(nazovOrg, adresaOrg, organizator, b);
        organizator.setOrg(o);
        this.getDb().getOrganizacie().add(o);
    }

    public void registerSpravca(String meno, String login, char[] password) {
        logger.info("vytvaram TMP spravcu");
        this.spravcaTemp = new Spravca(meno, login, password);
    }

    public boolean isSpravcaCreated() {
        logger.info("kontrolujem ci je TMP spravca vytvoreny");
        return true ? this.spravcaTemp != null : false;
    }

    public boolean isOrgNameAvailable(String adresaOrg) {
        logger.info("Kontrolujem ci je meno org dostupne.");
        for (Organizacia org : this.getDb().getOrganizacie()) {
            if (org.getUrlAdresa().equals(adresaOrg)) {
                logger.info("Meno org nie je dostupne.");
                return false;
            }
        }
        logger.info("Meno org je dostupne");
        return true;
    }

    public boolean pripojOrganizaciu(String adresa) {
        logger.info("pripajam pouzivatela z org na adrese " + adresa);
        for (Organizacia org : this.getDb().getOrganizacie()) {
            if (org.getUrlAdresa().equals(adresa)) {
                this.orgLoggedIn = org;
                logger.info("Prihlasenie sa podarilo");
                return true;
            }
        }
        logger.info("prihlasenie sa nepodarilo");
        return false;
    }

    public void logOut() {
        logger.info("odhlasujem pouzivatela");
        this.orgLoggedIn = null;
        this.userLoggedIn = null;
        this.spravcaTemp = null;
    }

    /**
     * Z databazy vrati balik na zaklade ID
     */
    public Balik getBalik(int index) {
        return this.getDb().getBaliky().get(index);
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
