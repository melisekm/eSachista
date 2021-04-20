package sk.stu.fiit.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;
import sk.stu.fiit.model.organisation.platform.turnaj.TurnajFormat;

/**
 *
 * @author Martin Melisek
 */
public class AktivneTurnajeSpravcaController extends AktivneTurnajeController {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeSpravcaController.class);
    private Turnaj prebiehajuciTurnaj;

    private int turnajId;

    public Turnaj getNadchadzajuciTurnaj() {
        logger.info("Hladam turnaj.");
        for (Turnaj turnaj : this.getTurnaje()) {
            if (!turnaj.isFinished()) {
                logger.info("nasiel som turnaj.");
                return turnaj;
            }
        }
        logger.info("Nenasiel som ziadny turnaj");
        return null;
    }

    public boolean vygenerujHarmonogram() {
        logger.info("Zacinam generovat turnaj");
        int idx = 0;
        for (Turnaj turnaj : this.getTurnaje()) {
            if (turnaj.getNazov().equals(this.prebiehajuciTurnaj.getNazov())) {
                break;
            }
            idx++;
        }
        this.turnajId = idx;
        logger.info("id turnaja je id=" + idx);
        boolean jeTurnajSkonceny = this.turnajService.advanceTurnaj(this.prebiehajuciTurnaj) == false;
        if (jeTurnajSkonceny) {
            logger.info("negenerujem nic lebo turnaj uz bol skoneceny");
            this.saveOrg();
            return false;
        }
        logger.info("generujem harmonogram.");
        this.turnajService.vygenerujHarmonogram(this.prebiehajuciTurnaj, idx);
        return true;
    }

    public void aktualizujTurnajUdaje() {
        // TODO ani neviem co som sem chcel dat
    }

    public void zadajVysledok(Zapas zapas, Hrac vyherca) {
        zapas.setVyherca(vyherca);
        this.turnajService.modifikujVysledok(this.prebiehajuciTurnaj, zapas, this.turnajId);
        this.saveOrg();
    }

    public Turnaj getPrebiehajuciTurnaj() {
        return prebiehajuciTurnaj;
    }

    public void setPrebiehajuciTurnaj(Turnaj prebiehajuciTurnaj) {
        this.prebiehajuciTurnaj = prebiehajuciTurnaj;
    }

    public int getTurnajId() {
        return turnajId;
    }

    public void setTurnajId(int turnajId) {
        this.turnajId = turnajId;
    }

    public boolean skontrolujZadanePocetVysledkov() {
        if (this.prebiehajuciTurnaj.getStage() == null) {
            return true; // ak neexistuje stage tak este nic nebolo vygenerovane.
        }
        for (Map.Entry<Zapas, Integer> entry : this.prebiehajuciTurnaj.getZapasy().entrySet()) {
            Zapas zapas = entry.getKey();
            Integer kolo = entry.getValue();
            if (kolo == this.prebiehajuciTurnaj.getStage().getKolo() - 1) {
                if (zapas.getVyherca() == null) { // hladame zapasy len tohto kola
                    return true;
                }
            }
        }
        return false;
    }
}
