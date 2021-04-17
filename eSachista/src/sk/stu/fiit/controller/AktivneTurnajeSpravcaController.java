package sk.stu.fiit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.io.XMLTurnajModifier;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class AktivneTurnajeSpravcaController extends AktivneTurnajeController {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeSpravcaController.class);
    private Turnaj prebiehajuciTurnaj;

    private int pocetZadanychVysledkov;
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

    public void zadajVysledok(Zapas zapas, boolean hrac1Vysledok) {
        zapas.setVyherca(hrac1Vysledok ? zapas.getHrac1() : zapas.getHrac2());
        this.turnajService.modifikujVysledok(this.prebiehajuciTurnaj, zapas, this.turnajId);
        this.saveOrg();
    }

    public Turnaj getPrebiehajuciTurnaj() {
        return prebiehajuciTurnaj;
    }

    public void setPrebiehajuciTurnaj(Turnaj prebiehajuciTurnaj) {
        this.prebiehajuciTurnaj = prebiehajuciTurnaj;
    }

    public int getPocetZadanychVysledkov() {
        return pocetZadanychVysledkov;
    }

    public void setPocetZadanychVysledkov(int pocetZadanychVysledkov) {
        this.pocetZadanychVysledkov = pocetZadanychVysledkov;
    }

    public int getTurnajId() {
        return turnajId;
    }

    public void setTurnajId(int turnajId) {
        this.turnajId = turnajId;
    }

}