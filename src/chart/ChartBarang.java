package chart;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.DefaultCategoryDataset;
public class ChartBarang {
    public static void tampilChart(JPanel panel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        isiDatasetDariDatabase(dataset);
        JFreeChart chart = ChartFactory.createLineChart(
                "Grafik Barang Masuk vs Barang Keluar",
                "Hari",
                "Jumlah",
                dataset
        );
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(new Color(230,230,230));
        plot.setOutlinePaint(null);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        if (getMaxValue(dataset) <= 0) {
            rangeAxis.setRange(0, 10);
        }
        LineAndShapeRenderer renderer =
                (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(34,197,94));
        renderer.setSeriesPaint(1, new Color(239,68,68));
        renderer.setSeriesStroke(0, new BasicStroke(3f));
        renderer.setSeriesStroke(1, new BasicStroke(3f));
        renderer.setDefaultShapesVisible(true);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setOpaque(false);
        chartPanel.setPreferredSize(
                new java.awt.Dimension(485, 269)
        );
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
    private static void isiDatasetDariDatabase(DefaultCategoryDataset dataset) {
        String[] hari = {"Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Min"};
        for (String namaHari : hari) {
            dataset.addValue(0, "Barang Masuk", namaHari);
            dataset.addValue(0, "Barang Keluar", namaHari);
        }
        loadJumlahPerHari(dataset, "barangmasuk", "Barang Masuk");
        loadJumlahPerHari(dataset, "barangkeluar", "Barang Keluar");
    }
    private static double getMaxValue(DefaultCategoryDataset dataset) {
        double max = 0;
        for (int row = 0; row < dataset.getRowCount(); row++) {
            for (int col = 0; col < dataset.getColumnCount(); col++) {
                Number value = dataset.getValue(row, col);
                if (value != null) {
                    max = Math.max(max, value.doubleValue());
                }
            }
        }
        return max;
    }
    private static void loadJumlahPerHari(DefaultCategoryDataset dataset, String tableName, String seriesName) {
        String sql = "SELECT DAYOFWEEK(tanggal) AS hari, COALESCE(SUM(jumlah), 0) AS total "
                + "FROM " + tableName + " "
                + "GROUP BY DAYOFWEEK(tanggal)";
        try (Connection conn = config.koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String namaHari = namaHari(rs.getInt("hari"));
                dataset.setValue(rs.getInt("total"), seriesName, namaHari);
            }
        } catch (Exception e) {
            System.out.println("Gagal memuat data grafik " + seriesName + ": " + e.getMessage());
        }
    }
    private static String namaHari(int dayOfWeek) {
        switch (dayOfWeek) {
            case 2:
                return "Sen";
            case 3:
                return "Sel";
            case 4:
                return "Rab";
            case 5:
                return "Kam";
            case 6:
                return "Jum";
            case 7:
                return "Sab";
            case 1:
            default:
                return "Min";
        }
    }
}
