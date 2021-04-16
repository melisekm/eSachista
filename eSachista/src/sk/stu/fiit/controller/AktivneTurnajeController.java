package sk.stu.fiit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.XMLTurnajReader;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class AktivneTurnajeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeController.class);

    private ArrayList<Zapas> harmonogram;

    public Turnaj isTurnajOn() {
        logger.info("Kontrolujem ci prave teraz bezi nejaky turnaj.");
        Hrac prihlasenyHrac = this.getPrihlasenyHrac();
        for (Turnaj turnaj : prihlasenyHrac.getTurnaje()) {
            if (!turnaj.isFinished() && turnaj.getDatumKonania().before(new Date())) {
                logger.info("nasiel som turnaj.");
                return turnaj;
            }
        }
        logger.info("Nenasiel som ziadny turnaj");
        return null;
    }

    public int getTurnajId(Turnaj prebiehajuciTurnaj) {
        logger.info("Hladam id turnaja s id z databazy");
        int id = 0;
        for (Turnaj turnaj : this.getTurnaje()) {
            if (turnaj == prebiehajuciTurnaj) {
                if (new File("resources/turnaje/" + id + "/harmonogram.xml").exists()) { // TODO STAGE
                    logger.info("podarilo sa mi sparovat turnaj a vraciam id " + id);
                    return id;
                }
            }
            id++;
        }
        logger.info("nenasiel som ziadny turnaj.");
        return -1;
    }

    public void parseTurnaj(int turnajId) {
        logger.info("idem citat zo subora xml pre turnaj s id " + turnajId);
        XMLTurnajReader xmlReader = new XMLTurnajReader("resources/turnaje/" + turnajId + "/harmonogram.xml");
        this.harmonogram = xmlReader.parseTurnaj(this.getTurnaje().get(turnajId));
        logger.info("skoncil som citanie.");
    }

    public Zapas najdiZapasHraca() {
        logger.info("Hladam v harmonograme turnaja zapas pre prihlaseneho hraca");
        if(this.harmonogram == null){
            logger.info("Harmonogram vobec neexistuje.");
            return null;
        }
        for (Zapas zapas : this.harmonogram) {
            boolean jeToHrac1 = zapas.getHrac1().getLogin() == this.getPrihlasenyHrac().getLogin();
            boolean jeToHrac2 = zapas.getHrac2().getLogin() == this.getPrihlasenyHrac().getLogin();
            boolean figurujeHracVzapase = Boolean.logicalOr(jeToHrac1, jeToHrac2);
            if (figurujeHracVzapase) {
                logger.info("Nasiel som prihlaseneho hraca ktory figuruje v zapase");
                return zapas;
            }
        }
        logger.info("nenasiel som ziadneho hraca ktory by bol v nejakom zapase turnaja");
        return null;
    }

    public ArrayList<Zapas> getHarmonogram() {
        return harmonogram;
    }

    public void setHarmonogram(ArrayList<Zapas> harmonogram) {
        this.harmonogram = harmonogram;
    }
}
