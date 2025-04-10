import org.freedesktop.tinyb.*;

import java.util.List;

public class DeviceDiscovery {

    public static void discoverDevices(ComboBox<String> deviceComboBox) {
        try {
            // Initialize TinyB BluetoothManager
            BluetoothManager manager = BluetoothManager.getBluetoothManager();
            manager.startDiscovery();

            // Wait for devices to be discovered
            List<BluetoothDevice> devices = manager.getDevices();

            // Populate ComboBox with discovered devices
            for (BluetoothDevice device : devices) {
                String deviceName = device.getName();
                if (deviceName != null && !deviceName.isEmpty()) {
                    deviceComboBox.getItems().add(deviceName);
                }
            }

            // Stop discovery after 10 seconds
            Thread.sleep(10000);
            manager.stopDiscovery();

        } catch (DBusException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
