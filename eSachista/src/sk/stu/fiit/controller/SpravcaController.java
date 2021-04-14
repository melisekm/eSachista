package sk.stu.fiit.controller;

import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.clients.Spravca;

/**
 *
 * @author Martin Melisek
 */
public class SpravcaController extends Controller {

    private Spravca prihlasenySpravca;
    private Organizacia organizacia;

    public SpravcaController() {
        this.organizacia = this.getOrgLoggedIn();
        this.prihlasenySpravca = (Spravca) this.getUserLoggedIn();
    }

    public Spravca getPrihlasenySpravca() {
        return prihlasenySpravca;
    }

    public void setPrihlasenySpravca(Spravca prihlasenySpravca) {
        this.prihlasenySpravca = prihlasenySpravca;
    }

    public Organizacia getOrganizacia() {
        return organizacia;
    }

    public void setOrganizacia(Organizacia organizacia) {
        this.organizacia = organizacia;
    }

}
