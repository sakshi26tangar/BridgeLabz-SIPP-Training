import java.util.Scanner;

// Superclass
class Vehicle {
    String model;
    int maxSpeed;

    void inputVehicleDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Model: ");
        model = sc.nextLine();
        System.out.print("Enter Max Speed (km/h): ");
        maxSpeed = sc.nextInt();
    }

    void displayVehicle() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// ElectricVehicle subclass
class ElectricVehicle extends Vehicle {
    void charge() {
        System.out.println("Electric Vehicle is charging...");
    }
}

// PetrolVehicle subclass implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    public void refuel() {
        System.out.println("Petrol Vehicle is being refueled...");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle();
        ev.inputVehicleDetails();
        ev.displayVehicle();
        ev.charge();

        System.out.println();

        PetrolVehicle pv = new PetrolVehicle();
        pv.inputVehicleDetails();
        pv.displayVehicle();
        pv.refuel();
    }
}
