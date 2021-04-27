package sk.stu.fiit.service;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.IOManager;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
import sk.stu.fiit.model.organisation.platform.Balik;

/**
 * Sluzi ako middle man medzi model a controller, obsahuje prihlasenu org a
 * pouzivatela
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
     * @param meno meno hraca
     * @param login prihlasovacie meno hraca
     * @param password zahashovane heslo
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

    /**
     * zaregistruje organizaciu do databazy
     *
     * @param nazovOrg nazov organizacie
     * @param adresaOrg domenove meno organizacie
     * @param balikId id balika, ktory spravca vybral
     * @param email email spravcu
     */
    public void registerOrg(String nazovOrg, String adresaOrg, int balikId, String email) {
        logger.info("registrujem organizaciu");
        Balik b = this.getDb().getBaliky().get(balikId);
        Spravca organizator = new Spravca(this.spravcaTemp, email);
        Organizacia o = new Organizacia(nazovOrg, adresaOrg, organizator, b);
        organizator.setOrg(o);
        this.getDb().getOrganizacie().add(o);
        new File("resources\\" + o.getNazov()).mkdirs();
        try {
            new IOManager(o.getNazov()).saveOrg(o);
        } catch (IOException ex) {
            logger.error("Chyba pri vytvarani novej org.");
        }
    }

    /**
     * vytvori docasneho spravca pri registracii org.
     *
     * @param meno meno spravcu
     * @param login prihlasovacie meno spravcu
     * @param password zahashovane heslo spravcu
     */
    public void registerSpravca(String meno, String login, char[] password) {
        logger.info("vytvaram TMP spravcu");
        this.spravcaTemp = new Spravca(meno, login, password);
    }

    public boolean isSpravcaCreated() {
        logger.info("kontrolujem ci je TMP spravca vytvoreny");
        return true ? this.spravcaTemp != null : false;
    }

    /**
     * skontroluje ci je domenove meno organizacie k dispozcii
     *
     * @param adresaOrg domenove meno organizacie
     * @return true ak je, false inak
     */
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

    /**
     * pokusi sa pripojit organizaciu do aplikacie
     *
     * @param adresa domenova adresa aplikacie
     * @return true ak sa to podarilo, false ak tato org v aplikacii neexistuje
     */
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

    /**
     * odhlasi hraca/spravcu
     */
    public void logOut() {
        logger.info("odhlasujem pouzivatela");
        this.orgLoggedIn = null;
        this.userLoggedIn = null;
        this.spravcaTemp = null;
    }

    /**
     * z databazy vrati id balika
     *
     * @param index id balika
     * @return balik z databazy
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
