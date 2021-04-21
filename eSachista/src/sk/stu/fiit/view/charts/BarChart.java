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
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import sk.stu.fiit.database.Database;

/**
 *
 * @author Martin Melisek
 */
public class BarChart extends Chart {

    public BarChart(LinkedHashMap<String, Double> dataset, String nadpis) {
        super(dataset, nadpis);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : this.getRawDataset().entrySet()) {
            String datum = entry.getKey();
            Double hodnota = entry.getValue();
            dataset.setValue(hodnota, "LEFT TEXT", datum);
        }
        return dataset;
    }

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
        //plot.setNoDataMessage(java.util.ResourceBundle.getBundle(Database.getInstance().getBundle()).getString("NENASLI SA ZIADNE ZAZNAMY."));
        plot.getDomainAxis().setLabelFont(new Font("Dialog", Font.PLAIN, 8)); //NOI18N

        //farby
        Color farbaPozadia = new Color(214, 217, 223);
        plot.setBackgroundPaint(farbaPozadia);
        plot.setOutlinePaint(null);
        chart.setBackgroundPaint(farbaPozadia);
        final CategoryItemRenderer renderer = new CustomRenderer(
                new Paint[]{new Color(215, 0, 0), Color.blue, Color.green,
                    Color.yellow, Color.orange, Color.cyan,
                    Color.magenta, Color.blue}
        );
        plot.setRenderer(renderer);
        ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter()); // vypne gradient
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator()); // zapne tooltip on hoover

        return chart;
    }

    public JPanel createBarPane() {
        JFreeChart chart = createChart(createDataset(), this.getNadpis());
        return new ChartPanel(chart);
    }

    /**
     * @see
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
