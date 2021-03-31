package sk.stu.fiit.controller;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajTempoHry;
import sk.stu.fiit.service.EntryService;

/**
 * Pomocou <i> Service triedy </i> komunikuje s modelom Vracia data pre view,
 * ktory ich zobrazuje
 *
 * @author Martin Melisek
 */
public abstract class Controller {

    protected EntryService entryService = EntryService.getInstance();

    public void logOut() {
        this.entryService.logOut();
    }
    
    public Pouzivatel getUserLoggedIn() {
        return this.entryService.getUserLoggedIn();
    }

    public ArrayList<Turnaj> getTurnaje() {
        return this.entryService.getOrgLoggedIn().getTurnaje();
    }

    public String getTurnajKapacita(Turnaj t) {
        return String.format("%d/%d", t.getHraci().size(), this.entryService.getOrgLoggedIn().getBalik().getMaxHracovTurnaja());
    }
}
