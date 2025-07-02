import java.util.Scanner;

class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter device ID: ");
        String id = sc.nextLine();

        System.out.print("Enter device status (On/Off): ");
        String status = sc.nextLine();

        System.out.print("Enter temperature setting: ");
        double temp = sc.nextDouble();

        Thermostat t = new Thermostat(id, status, temp);
        System.out.println("\nThermostat Device Status:");
        t.displayStatus();
    }
}
