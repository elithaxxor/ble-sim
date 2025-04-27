### **Purpose of the Repository**
The repository, as suggested by its contents and code structure, focuses on simulating Bluetooth Low Energy (BLE) functionalities. It provides implementations for simulating BLE devices, including advertising, pairing, and updating characteristics such as battery levels and heart rates. The repository also includes a GUI application for visualizing BLE operations and real-time data updates.

### **Features and Technologies**
The repository leverages Java to build a BLE simulation framework. Key features include:
1. **Bluetooth Simulation**: Methods for advertising BLE devices, pairing, and simulating device attributes like battery level and heart rate.
2. **Graphical User Interface (GUI)**: Built using JavaFX, the GUI enables users to interact with the BLE simulations, select devices, and view real-time charts, such as battery level trends.
3. **Real-Time Data Visualization**: A line chart dynamically updates real-time data, ensuring an interactive simulation experience.
4. **Device Discovery**: It uses the TinyB library for managing Bluetooth operations, such as discovering and listing nearby BLE devices.

### **Deeper Dive into the Repository**

#### **Overview of the Repository**
This repository, `elithaxxor/ble-sim`, appears to focus on simulating Bluetooth Low Energy (BLE) functionalities. It is implemented entirely in Java, utilizing libraries such as TinyB for Bluetooth operations and JavaFX for graphical user interfaces. The repository enables users to simulate BLE device behavior, such as advertising, pairing, and updating characteristics like battery levels and heart rates.

#### **Key Features and Functionalities**
1. **Bluetooth Device Simulation**:
   - The repository includes a `BluetoothSimulation` class that simulates BLE operations:
     - **Advertising**: Simulates a BLE device broadcasting its presence with a given SSID and service UUID.
     - **Pairing**: Provides a method to simulate pairing with a BLE device using its MAC address.
     - **Device Characteristics**: Simulates updates to BLE characteristics such as battery level and heart rate, with realistic random values.

2. **Real-Time Data Visualization**:
   - The repository features a `RealTimeChart` class that provides dynamic charts for visualizing simulated device data:
     - A line chart displays the battery level over time.
     - Updates are made every two seconds, with a rolling window of the latest 10 data points.

3. **Device Discovery**:
   - The `DeviceDiscovery` class utilizes the TinyB library to scan for nearby BLE devices and populate a device list.
   - It manages discovery sessions, fetching device names and stopping the discovery after a defined duration.

4. **Graphical User Interface**:
   - A GUI is implemented in the `FakeAPWindow` and `BluetoothMain` classes using JavaFX:
     - Users can interact with simulated devices, initiate discovery, and view logs and charts.
     - The GUI includes components like a device selector, real-time battery level chart, and verbose logs for BLE operations.
     - Custom styling (e.g., macOS aesthetics) is applied to enhance the user experience.

#### **Technologies and Libraries**
- **Programming Language**: Java (100%)
- **Libraries and Frameworks**:
  - **TinyB**: For BLE management, including device discovery and characteristic updates.
  - **JavaFX**: For building the interactive GUI, including charts and controls.
  - **DBus**: Used for system-level Bluetooth interactions via TinyB.

#### **Potential Usage**
This repository is a valuable resource for developers and researchers working with BLE technology. It can be used to:
- Simulate BLE scenarios for testing and prototyping.
- Educate on BLE concepts and operations.
- Develop proof-of-concept applications without requiring actual BLE hardware.
