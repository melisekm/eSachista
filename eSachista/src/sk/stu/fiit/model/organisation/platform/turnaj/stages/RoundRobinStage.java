package sk.stu.fiit.model.organisation.platform.turnaj.stages;

import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 * Predstavuje triedu pre stage, kde v turnaji hra kazdy s kazdym
 *
 * @author Martin Melisek
 */
public class RoundRobinStage extends Stage {

    /**
     * kolko krat za kolo treba generovat zapasy
     */
    private int polCas;
    private int pocetHracov;

    public RoundRobinStage(Turnaj turnaj, int pocetKol) {
        super(turnaj, pocetKol);
        this.polCas = turnaj.getHraci().size() / 2;
    }

    public int getPolCas() {
        return polCas;
    }

    public void setPolCas(int polCas) {
        this.polCas = polCas;
    }

    public int getPocetHracov() {
        return pocetHracov;
    }

    public void setPocetHracov(int pocetHracov) {
        this.pocetHracov = pocetHracov;
    }

}
