package sk.stu.fiit.model.organisation.clients;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class Hrac extends Pouzivatel {

    private int ELO;
    private ArrayList<Turnaj> turnaje;

    public Hrac(Organizacia org, String meno, String login, char[] heslo) {
        super(org, meno, login, heslo);
        this.turnaje = new ArrayList<>();
    }

    @Override
    public String toString() {
        return meno;
    }
    

    public int getELO() {
        return ELO;
    }

    public void setELO(int ELO) {
        this.ELO = ELO;
    }

    public ArrayList<Turnaj> getTurnaje() {
        return turnaje;
    }

    public void setTurnaje(ArrayList<Turnaj> turnaje) {
        this.turnaje = turnaje;
    }

}
