package sk.stu.fiit.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.IOManager;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.service.EntryService;

/**
 * Pomocou <i> Service triedy </i> komunikuje s modelom vracia data pre view,
 * ktory ich zobrazuje
 *
 * @author Martin Melisek
 */
public abstract class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    protected EntryService entryService = EntryService.getInstance();

    private IOManager ioManager;

    public Controller() {
        this.ioManager = new IOManager();
    }

    public void saveTurnaje() {
        try {
            ioManager.saveTurnaje(this.entryService.getOrgLoggedIn().getTurnaje());
        } catch (FileNotFoundException ex) {
            logger.error("Subor kam sa mali turnaje ulozit neexistuje.");
        } catch (IOException ex) {
            logger.error("Nepodarilo sa ulozit zoznam turnajov.");
        }
    }

    public void loadTurnaje() {
        try {
            this.entryService.getOrgLoggedIn().setTurnaje(this.ioManager.loadTurnaje());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            logger.error("Trieda turnajov je nekompatibilny.");
        }
    }

    public void logOut() {
        this.entryService.logOut();
    }

    protected Pouzivatel getUserLoggedIn() {
        return this.entryService.getUserLoggedIn();
    }

    protected Organizacia getOrgLoggedIn() {
        return entryService.getOrgLoggedIn();
    }

    public ArrayList<Turnaj> getTurnaje() {
        return this.entryService.getOrgLoggedIn().getTurnaje();
    }

    public String getTurnajKapacita(Turnaj t) {
        return String.format("%d/%d", t.getHraci().size(), this.entryService.getOrgLoggedIn().getBalik().getMaxHracovTurnaja());
    }
}
