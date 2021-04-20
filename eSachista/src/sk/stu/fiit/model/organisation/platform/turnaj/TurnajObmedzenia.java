package sk.stu.fiit.model.organisation.platform.turnaj;

import java.io.Serializable;

/**
 *
 * @author Martin Melisek
 */
public class TurnajObmedzenia implements Serializable{

    private int minRating;
    private int maxRating;
    private int maxVek;

    public TurnajObmedzenia(int minRating, int maxRating, int maxVek) {
        this.minRating = minRating;
        this.maxRating = maxRating;
        this.maxVek = maxVek;
    }
    
    public String getRatingObmedzenie(){
        return String.format("%d - %d", this.minRating, this.maxRating);
    }
    
    public int getMinRating() {
        return minRating;
    }

    public void setMinRating(int minRating) {
        this.minRating = minRating;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
    }

    public int getMaxVek() {
        return maxVek;
    }

    public void setMaxVek(int maxVek) {
        this.maxVek = maxVek;
    }
}
