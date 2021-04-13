package sk.stu.fiit.view.charts;

import java.util.LinkedHashMap;
import javax.swing.JPanel;

/**
 *
 * @author Martin Melisek
 */
@SuppressWarnings("unchecked")
public class BarPieChartFactory {

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

    private JPanel createPieChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        PieChart pieChart = new PieChart(dataset, nadpis);
        return pieChart.createPiePane();
    }

    private JPanel createBarChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        BarChart barChart = new BarChart(dataset, nadpis);
        return barChart.createBarPane();
    }

}
