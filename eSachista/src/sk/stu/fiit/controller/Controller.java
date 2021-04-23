package sk.stu.fiit.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.database.Database;
import sk.stu.fiit.io.IOManager;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.clients.Spravca;
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

    protected IOManager ioManager;

    public Controller() {
        if(this.getOrgLoggedIn() != null){
            this.ioManager = new IOManager(this.getOrgLoggedIn().getNazov());
        }else{
            this.ioManager = new IOManager();
        }
    }

    public void saveOrg() {
        try {
            ioManager.saveOrg(this.getOrgLoggedIn());
        } catch (FileNotFoundException ex) {
            logger.error("Subor kam sa mala org ulozit neexistuje.");
        } catch (IOException ex) {
            logger.error("Nepodarilo sa ulozit org.");
        }
    }

    public void loadOrg() {
        try {
            this.entryService.setOrgLoggedIn(this.ioManager.loadOrg());
            Database.getInstance().getOrganizacie().set(this.getOrgLoggedIn().getId(), this.getOrgLoggedIn());
            if (this.getUserLoggedIn() != null) {
                for (Pouzivatel pouzivatel : this.getPouzivatelia()) {
                    if (pouzivatel.getLogin().equals(this.getUserLoggedIn().getLogin())) {
                        this.entryService.setUserLoggedIn(pouzivatel);
                    }
                }
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            logger.error("Trieda org je nekompatibilny.");
        }
    }

    public void logOut() {
        this.entryService.logOut();
    }

    public ArrayList<Turnaj> getTurnaje() {
        return this.entryService.getOrgLoggedIn().getTurnaje();
    }

    public ArrayList<Pouzivatel> getPouzivatelia() {
        return this.entryService.getOrgLoggedIn().getPouzivatelia();
    }

    public ArrayList<Hrac> getHraci() {
        ArrayList<Hrac> hraci = new ArrayList<>();
        for (Pouzivatel pouzivatel : this.getPouzivatelia()) {
            if (pouzivatel instanceof Hrac) {
                hraci.add((Hrac) pouzivatel);
            }
        }
        return hraci;
    }

    /**
     * Po obnoveni najnovsej verzie org obnovi referenciu
     *
     * @param povodnyTurnaj turnaj ktoreho referencia sa ma obnovit
     * @return referenciu na turanj z najnovsieho suboru ak existuje inak null
     */
    protected Turnaj reloadTurnaj(Turnaj povodnyTurnaj) {
        for (Turnaj turnaj : this.getTurnaje()) {
            if (turnaj.getNazov().equals(povodnyTurnaj.getNazov())) {
                return turnaj;
            }
        }
        return null;
    }

    public String getTurnajKapacita(Turnaj t) {
        return String.format("%d/%d", t.getHraci().size(), this.entryService.getOrgLoggedIn().getBalik().getMaxHracovTurnaja());
    }

    public Pouzivatel getUserLoggedIn() {
        return this.entryService.getUserLoggedIn();
    }

    public Organizacia getOrgLoggedIn() {
        return entryService.getOrgLoggedIn();
    }

    public Hrac getPrihlasenyHrac() {
        return (Hrac) this.entryService.getUserLoggedIn();
    }

    public Spravca getPrihlasenySpravca() {
        return (Spravca) this.entryService.getUserLoggedIn();
    }

}
