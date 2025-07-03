import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: ₹" + rentalRate + " per day");
    }
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 1000; 
    }

    public String getInsuranceDetails() {
        return "Car Insurance: ₹1000 (flat)";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 300;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: ₹300 (flat)";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; 
    }

    public double calculateInsurance() {
        return 2000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: ₹2000 (flat)";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR123", 1500));
        vehicles.add(new Bike("BIKE456", 500));
        vehicles.add(new Truck("TRUCK789", 3000));

        int rentalDays = 5;

        System.out.println("=== Vehicle Rental Summary ===");

        for (Vehicle v : vehicles) {
            System.out.println("\n-----------------------------");
            v.displayDetails();
            double rentalCost = v.calculateRentalCost(rentalDays);
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + rentalCost);

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Amount: ₹" + ins.calculateInsurance());
            }

            double total = rentalCost + ((Insurable) v).calculateInsurance();
            System.out.println("Total Payable: ₹" + total);
        }
    }
}
