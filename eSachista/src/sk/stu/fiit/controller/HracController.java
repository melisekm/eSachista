package sk.stu.fiit.controller;

import sk.stu.fiit.model.organisation.clients.Hrac;

/**
 *
 * @author Martin Melisek
 */
public class HracController extends Controller {

    private Hrac prihlasenyHrac;

    public HracController() {
        this.prihlasenyHrac = (Hrac) this.getUserLoggedIn();

    }

    public Hrac getPrihlasenyHrac() {
        return prihlasenyHrac;
    }

    public void setPrihlasenyHrac(Hrac prihlasenyHrac) {
        this.prihlasenyHrac = prihlasenyHrac;
    }

}
