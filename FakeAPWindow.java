import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FakeAPWindow extends Application {

    private ComboBox<String> deviceSelector;
    private TextArea verboseLog;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bluetooth Device Simulation");

        // Main Layout
        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new javafx.geometry.Insets(20));

        // Device Selector (for discovery)
        deviceSelector = new ComboBox<>();
        deviceSelector.setPromptText("Detecting Devices...");
        deviceSelector.getStyleClass().add("combo-box");
        mainLayout.getChildren().add(new Label("Select Device:"));
        mainLayout.getChildren().add(deviceSelector);

        // Start Discovery Button
        Button startDiscoveryButton = new Button("Start Device Discovery");
        startDiscoveryButton.getStyleClass().add("button");
        startDiscoveryButton.setOnAction(event -> startDeviceDiscovery());
        mainLayout.getChildren().add(startDiscoveryButton);

        // Real-time Battery Level Chart
        LineChart<Number, Number> batteryChart = RealTimeChart.createBatteryChart();
        mainLayout.getChildren().add(batteryChart);

        // Verbose Log text area
        verboseLog = new TextArea();
        verboseLog.setEditable(false);
        verboseLog.getStyleClass().add("text-area");
        mainLayout.getChildren().add(new Label("Verbose Log:"));
        mainLayout.getChildren().add(verboseLog);

        // Scene and Styling
        Scene scene = new Scene(mainLayout, 600, 600);
        scene.getStylesheets().add(getClass().getResource("macos-style.css").toExternalForm()); // Apply macOS styling
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Start device discovery and update the ComboBox
    private void startDeviceDiscovery() {
        new Thread(() -> {
            DeviceDiscovery.discoverDevices(deviceSelector);
        }).start();
    }
}
