package sk.stu.fiit.view.charts;

import java.util.LinkedHashMap;

/**
 *
 * @author Martin Melisek
 */
public abstract class Chart {

    private LinkedHashMap<String, Double> rawDataset;
    private String nadpis;

    public Chart(LinkedHashMap<String, Double> dataset, String nadpis) {
        this.rawDataset = dataset;
        this.nadpis = nadpis;
    }

    public LinkedHashMap<String, Double> getRawDataset() {
        return rawDataset;
    }

    public void setRawDataset(LinkedHashMap<String, Double> rawDataset) {
        this.rawDataset = rawDataset;
    }

    public String getNadpis() {
        return nadpis;
    }

    public void setNadpis(String nadpis) {
        this.nadpis = nadpis;
    }

}
