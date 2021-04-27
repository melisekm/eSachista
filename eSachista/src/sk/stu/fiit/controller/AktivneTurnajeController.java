package sk.stu.fiit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.service.TurnajService;

/**
 * Abstraktny controller aktivnych turnajov pre hraca a spravcu.
 * @author Martin Melisek
 */
public abstract class AktivneTurnajeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeController.class);
    /**
     * sluzba, ktora generuje a advancuje turnaj, spolocna pre hraca aj spravcu
     */
    protected TurnajService turnajService;

    public AktivneTurnajeController() {
        this.turnajService = new TurnajService();
    }


}
