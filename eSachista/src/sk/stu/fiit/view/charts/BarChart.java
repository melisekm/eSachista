package sk.stu.fiit.view.charts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.util.LinkedHashMap;
import org.jfree.chart.ChartFactory;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Stlpcovy graf, dataset v podobe linked hashmapy, ktora mapuje label na
 * hodnotu
 *
 * @author Martin Melisek
 */
public class BarChart extends Chart {

    public BarChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        super(dataset, nadpis);
    }

    /**
     * naplni dataset
     *
     * @return stlpcovy dataset
     */
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : this.getRawDataset().entrySet()) {
            String datum = entry.getKey();
            Double hodnota = entry.getValue();
            dataset.setValue(hodnota, "Poèet hráèov", datum);
        }
        return dataset;
    }

    /**
     * vytvori graf
     *
     * @param dataset stlpcovy dataset
     * @param nadpis nadpis grafu
     * @return graf
     */
    private JFreeChart createChart(CategoryDataset dataset, String nadpis) {
        JFreeChart chart = ChartFactory.createBarChart(
                nadpis,
                "", //NOI18N
                "Poèet hráèov",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setNoDataMessage("NENASLI SA ZIADNE ZAZNAMY.");
        plot.getDomainAxis().setLabelFont(new Font("Segoe UI", Font.PLAIN, 8)); //velkost fontu si to riesi interne
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setTickUnit(new NumberTickUnit(1));

        //farby
        Color farbaPozadia = new Color(240, 243, 247);
        plot.setBackgroundPaint(farbaPozadia);
        plot.setOutlinePaint(null);
        chart.setBackgroundPaint(farbaPozadia);
        final CategoryItemRenderer renderer = new CustomRenderer(
                new Paint[]{new Color(59, 166, 235), new Color(97, 162, 16), new Color(191, 75, 53),
                    new Color(229, 123, 0), new Color(59, 166, 235), new Color(14, 167, 144),}
        );
        plot.setRenderer(renderer);
        ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter()); // vypne gradient
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator()); // zapne tooltip on hoover

        return chart;
    }

    /**
     * vytvori a naplni panel grafu
     *
     * @return Panel grafu
     */
    public JPanel createBarPane() {
        JFreeChart chart = createChart(createDataset(), this.getNadpis());
        return new ChartPanel(chart);
    }

    /**
     * prebrata trieda, ktora nastavuje farby grafu
     * http://www.java2s.com/Code/Java/Chart/JFreeChartBarChartDemo3differentcolorswithinaseries.htm
     */
    class CustomRenderer extends BarRenderer {

        /**
         * The colors.
         */
        private Paint[] colors;

        /**
         * Creates a new renderer.
         *
         * @param colors the colors.
         */
        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }

        /**
         * Returns the paint for an item. Overrides the default behaviour
         * inherited from AbstractSeriesRenderer.
         *
         * @param row the series.
         * @param column the category.
         *
         * @return The item color.
         */
        public Paint getItemPaint(final int row, final int column) {
            return this.colors[column % this.colors.length];
        }
    }

}
