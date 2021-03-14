package sk.stu.fiit.controller;

import sk.stu.fiit.controller.sevice.EntryService;

/**
 * Pomocou <i> Service triedy </i> komunikuje s modelom Vracia data pre
 * view, ktory ich zobrazuje
 *
 * @author Martin Melisek
 */
public abstract class Controller {

    EntryService entryService = EntryService.getInstance();

}
