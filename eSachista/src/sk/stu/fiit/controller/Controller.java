package sk.stu.fiit.controller;

import sk.stu.fiit.controller.sevice.Service;

/**
 * Pomocou <i> *NEJAKEJ TRIEDY* </i>(WIP) komunikuje s modelom Vracia data pre
 * view, ktory ich zobrazuje
 *
 * @author Martin Melisek
 */
public abstract class Controller {

    Service service = Service.getInstance();

}
