package sk.stu.fiit.controller;

import sk.stu.fiit.controller.service.EntryService;

/**
 * Pomocou <i> Service triedy </i> komunikuje s modelom Vracia data pre
 * view, ktory ich zobrazuje
 *
 * @author Martin Melisek
 */
public abstract class Controller {

    protected EntryService entryService = EntryService.getInstance();

    public void logOut(){
        this.entryService.logOut();
    }
}
