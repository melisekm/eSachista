package sk.stu.fiit.model.organisation.platform.turnaj.stages;

import java.util.HashMap;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class RoundRobinStage extends Stage {

    private int polCas;
    private int pocetHracov;

    private HashMap<Hrac, int[][]> tabulka;

    public RoundRobinStage(Turnaj turnaj) {
        super(turnaj, turnaj.getHraci().size() - 1);
        this.polCas = turnaj.getHraci().size() / 2;
        this.tabulka = new HashMap<>();
        for (Hrac hrac : turnaj.getHraci()) {
            int[][] tab = new int[turnaj.getHraci().size()][2];
            for (int i = 0; i < tab.length; i++) {
                tab[i][0] = tab[i][1] = 0;
            }
            this.tabulka.put(hrac, tab);
        }
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

    public HashMap<Hrac, int[][]> getTabulka() {
        return tabulka;
    }

    public void setTabulka(HashMap<Hrac, int[][]> tabulka) {
        this.tabulka = tabulka;
    }

}
