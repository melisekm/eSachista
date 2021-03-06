package sk.stu.fiit.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 * Controller, ktory komunikuje so sluzbou a modelom, zapisuje a modifikuje XML
 * na zaklade generovaneho rozpisu a zadavnia vysledkov
 *
 * @author Martin Melisek
 */
public class AktivneTurnajeSpravcaController extends AktivneTurnajeController {

    private static final Logger logger = LoggerFactory.getLogger(AktivneTurnajeSpravcaController.class);
    private Turnaj prebiehajuciTurnaj;

    private int turnajId;

    /**
     * zo zoznamu vsetkych turnajov, pre spravcu vrati turnaj ktory bude
     * najblizsie
     *
     * @return turnaj ktory bude najblizsie, null inak
     */
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

    /**
     * v prave prebiehajucom turnaji vygeneruje harmonogram a posunie ho dalej
     *
     * @return true ak je to mozne, false ak je turnaj skonceny
     */
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
        this.turnajService.vygenerujHarmonogram(this.getOrgLoggedIn(), this.prebiehajuciTurnaj, idx);
        return true;
    }

    /**
     * zapisuje k zapasus vysledok
     *
     * @param zapas ku ktoremu treba zapisat vysledok
     * @param vyherca Hrac, ktory zvitazil
     */
    public void zadajVysledok(Zapas zapas, Hrac vyherca) {
        zapas.setVyherca(vyherca);
        this.turnajService.modifikujVysledok(this.getOrgLoggedIn(), this.prebiehajuciTurnaj, zapas, this.turnajId);
        this.saveOrg();
    }

    /**
     * skontroluje ci boli vsetky vysledky v prave prebiehajucom turnaji a kole
     * zapisane
     *
     * @return true ak neboli, false ak boli
     */
    public boolean skontrolujZadanePocetVysledkov() {
        if (this.prebiehajuciTurnaj.getStage() == null) {
            return true; // ak neexistuje stage tak este nic nebolo vygenerovane.
        }
        for (Map.Entry<Zapas, Integer> entry : this.prebiehajuciTurnaj.getZapasy().entrySet()) {
            Zapas zapas = entry.getKey();
            Integer kolo = entry.getValue();
            if (kolo == this.prebiehajuciTurnaj.getStage().getKolo() - 1) {
                if (zapas.getHrac1() == null && zapas.getHrac2() == null) {
                    continue;
                }
                if (zapas.getVyherca() == null) { // hladame zapasy len tohto kola
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * ak turnaj skoncil vrati formatovany zoznam vyhercov(hracov ktory maju
     * najviac bodov, aj viac ako 1)
     *
     * @return formatovany string Hrac - {pocet} bodov
     */
    public String vyhodnotTurnaj() {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (Map.Entry<Hrac, int[]> entry : this.prebiehajuciTurnaj.getStage().getTabulka().entrySet()) {
            Hrac hrac = entry.getKey();
            int[] vysledky = entry.getValue();
            if (vysledky[1] > max) {
                sb.setLength(0);
                max = vysledky[1];
            }
            if (vysledky[1] == max) {
                sb.append(hrac.getMeno()).append(" - ").append(vysledky[1]).append(this.formatBody(vysledky[1]));
            }
        }
        return sb.toString();
    }

    private String formatBody(int body) {
        if (body == 0 && body > 4) {
            return " bodov\n";
        }
        if (body == 1) {
            return " bod\n";
        }
        return " body\n";
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
}
