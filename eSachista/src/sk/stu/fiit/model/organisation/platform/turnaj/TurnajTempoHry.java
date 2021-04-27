package sk.stu.fiit.model.organisation.platform.turnaj;

import java.io.Serializable;

/**
 * Tempo hry pre turnaj - cas v minutach a sekundach, kolko ma hrac k dispozcii
 * a increment, ktory ziska po kazdom tahu
 *
 * @author Martin Melisek
 */
public class TurnajTempoHry implements Serializable {

    private int limitMins;
    private int limitSec;
    private int increment;

    public TurnajTempoHry(int limitMins, int limitSec, int increment) {
        this.limitMins = limitMins;
        this.limitSec = limitSec;
        this.increment = increment;
    }

    @Override
    public String toString() {
        return String.format("%d min %d sec + %d sec", this.limitMins, this.limitSec, this.increment);

    }

    public int getLimitMins() {
        return limitMins;
    }

    public void setLimitMins(int limitMins) {
        this.limitMins = limitMins;
    }

    public int getLimitSec() {
        return limitSec;
    }

    public void setLimitSec(int limitSec) {
        this.limitSec = limitSec;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }
}
