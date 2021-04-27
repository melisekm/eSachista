package sk.stu.fiit.view.charts;

import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Kolacovy graf, dataset v podobe linked hashmapy, ktora mapuje label na
 * hodnotu
 *
 * @author Martin Melisek
 */
public class PieChart extends Chart {

    public PieChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        super(dataset, nadpis);
    }

    /**
     * naplni dataset
     *
     * @return kolacovy dataset
     */
    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : this.getRawDataset().entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            dataset.setValue(key, value);
        }
        return dataset;
    }

    /**
     * vytvori graf
     *
     * @param dataset kolacovy dataset
     * @param nadpis nadpis grafu
     * @return graf
     */
    private JFreeChart createChart(PieDataset dataset, String nadpis) {
        JFreeChart chart = org.jfree.chart.ChartFactory.createPieChart(
                nadpis, // nadpis
                dataset, // data
                true, // legenda
                false, // tooltipy
                false // odkazy
        );
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setNoDataMessage("NENASLI SA ZIADNE ZAZNAMY.");
        plot.setSimpleLabels(true);
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0} - {1} ({2})")); // formatovanie legendy //NOI18N
        plot.setLabelGenerator(null); // nezobrazovať labely v grafe

        //farby
        Color farbaPozadia = new Color(214, 217, 223);
        plot.setBackgroundPaint(farbaPozadia);
        plot.setOutlinePaint(null);
        chart.setBackgroundPaint(farbaPozadia);
        chart.getLegend().setBackgroundPaint(farbaPozadia);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    /**
     * vytvori a naplni panel grafu
     *
     * @return Panel grafu
     */
    public JPanel createPiePane() {
        JFreeChart chart = createChart(createDataset(), this.getNadpis());
        return new ChartPanel(chart);
    }
}
