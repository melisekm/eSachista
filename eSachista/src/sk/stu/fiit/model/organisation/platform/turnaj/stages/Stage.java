package sk.stu.fiit.model.organisation.platform.turnaj.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Stage implements Serializable {

    private int kolo;
    private int pocetKol;
    private ArrayList<Integer> zoznamHracov;
    private Turnaj turnaj;
    private LinkedHashMap<Integer, Integer> parovanie;
    private HashMap<Hrac, int[]> tabulka;

    public Stage(Turnaj turnaj, int pocetKol) {
        this.turnaj = turnaj;
        this.kolo = 0;
        this.pocetKol = pocetKol;
        this.zoznamHracov = new ArrayList<>();
        this.parovanie = new LinkedHashMap<>();
        this.tabulka = new HashMap<>();
        for (Hrac hrac : turnaj.getHraci()) {
            this.tabulka.put(hrac, new int[turnaj.getHraci().size()]);
        }

    }

    public ArrayList<Integer> getZoznamHracov() {
        return zoznamHracov;
    }

    public void setZoznamHracov(ArrayList<Integer> zoznamHracov) {
        this.zoznamHracov = zoznamHracov;
    }

    public Turnaj getTurnaj() {
        return turnaj;
    }

    public void setTurnaj(Turnaj turnaj) {
        this.turnaj = turnaj;
    }

    public int getKolo() {
        return kolo;
    }

    public void setKolo(int kolo) {
        this.kolo = kolo;
    }

    public int getPocetKol() {
        return pocetKol;
    }

    public void setPocetKol(int pocetKol) {
        this.pocetKol = pocetKol;
    }

    public LinkedHashMap<Integer, Integer> getParovanie() {
        return parovanie;
    }

    public void setParovanie(LinkedHashMap<Integer, Integer> parovanie) {
        this.parovanie = parovanie;
    }

    public HashMap<Hrac, int[]> getTabulka() {
        return tabulka;
    }

    public void setTabulka(HashMap<Hrac, int[]> tabulka) {
        this.tabulka = tabulka;
    }

}
