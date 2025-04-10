import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import java.util.Random;

public class RealTimeChart {

    private static final Random random = new Random();

    // Method to create a real-time line chart
    public static LineChart<Number, Number> createBatteryChart() {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Time (s)");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Battery Level (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Battery Level Over Time");

        // Create data series for plotting battery level
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Battery Level");

        lineChart.getData().add(series);

        // Start updating the chart every 2 seconds
        new Thread(() -> {
            int time = 1;
            while (true) {
                try {
                    // Simulate battery level changes
                    int batteryLevel = random.nextInt(101); // Battery level between 0-100

                    // Update chart
                    final int finalTime = time;
                    final int finalBatteryLevel = batteryLevel;
                    Platform.runLater(() -> {
                        series.getData().add(new XYChart.Data<>(finalTime, finalBatteryLevel));
                        if (series.getData().size() > 10) {
                            // Limit the chart to the latest 10 data points
                            series.getData().remove(0);
                        }
                    });

                    time++;
                    Thread.sleep(2000); // Update every 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return lineChart;
    }
}
