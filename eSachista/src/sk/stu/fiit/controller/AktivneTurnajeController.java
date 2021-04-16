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
        Hrac prihlasenyHrac = this.getPrihlasenyHrac();
        for (Turnaj turnaj : prihlasenyHrac.getTurnaje()) {
            if (!turnaj.isFinished() && turnaj.getDatumKonania().before(new Date())) {
                return turnaj;
            }
        }
        return null;
    }

    public int getTurnajId(Turnaj prebiehajuciTurnaj) {
        int id = 0;
        for (Turnaj turnaj : this.getTurnaje()) {
            if (turnaj == prebiehajuciTurnaj) {
                if (new File("resources/turnaje/" + id + "/harmonogram.xml").exists()) { // TODO STAGE
                    return id;
                }
            }
            id++;
        }
        return -1;
    }

    public void parseTurnaj(int turnajId) {
        XMLTurnajReader xmlReader = new XMLTurnajReader("resources/turnaje/" + turnajId + "/harmonogram.xml");
        this.harmonogram = xmlReader.parseTurnaj(this.getHraci(), this.getTurnaje().get(turnajId));
    }

    public Zapas najdiZapasHraca() {
        for (Zapas zapas : this.harmonogram) {
            boolean jeToHrac1 = zapas.getHrac1().getLogin() == this.getPrihlasenyHrac().getLogin();
            boolean jeToHrac2 = zapas.getHrac2().getLogin() == this.getPrihlasenyHrac().getLogin();
            boolean figurujeHracVzapase = Boolean.logicalOr(jeToHrac1, jeToHrac2);
            if (figurujeHracVzapase) {
                return zapas;
            }
        }
        return null;
    }

    public ArrayList<Zapas> getHarmonogram() {
        return harmonogram;
    }

    public void setHarmonogram(ArrayList<Zapas> harmonogram) {
        this.harmonogram = harmonogram;
    }
}
