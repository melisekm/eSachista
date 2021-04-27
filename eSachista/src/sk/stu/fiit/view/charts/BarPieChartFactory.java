package sk.stu.fiit.view.charts;

import java.util.LinkedHashMap;
import javax.swing.JPanel;

/**
 * Upraveny factory pattern, ktory vracia grafy na zaklade vstupu
 *
 * @author Martin Melisek
 */
@SuppressWarnings("unchecked")
public class BarPieChartFactory {

    /**
     * vrati panel, naplneny grafom<br>
     * "PIE" - Kolacovy<br>
     * "BAR" - Stlpcovy<br>
     *
     * @param type typ grafu
     * @param nadpis meno grafu
     * @param dataset dataset, ktorym sa graf naplni
     * @return
     */
    public JPanel createChart(String type, String nadpis, LinkedHashMap<String, Double> dataset) {
        switch (type) {
            case "PIE":
                return this.createPieChart(dataset, nadpis);
            case "BAR":
                return this.createBarChart(dataset, nadpis);
            default:
                throw new AssertionError();
        }
    }

    /**
     * vytvori kolacovy graf
     *
     * @param dataset dataset, ktory bude graf obsahovat
     * @param nadpis nadpis grafu
     * @return panel naplneny grafom
     */
    private JPanel createPieChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        PieChart pieChart = new PieChart(dataset, nadpis);
        return pieChart.createPiePane();
    }

    /**
     * vytvori stlpcovy graf
     *
     * @param dataset dataset, ktory bude graf obsahovat
     * @param nadpis nadpis grafu
     * @return panel naplneny grafom
     */
    private JPanel createBarChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        BarChart barChart = new BarChart(dataset, nadpis);
        return barChart.createBarPane();
    }

}
