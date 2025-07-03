import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID     : " + vehicleId);
        System.out.println("Driver Name    : " + driverName);
        System.out.println("Rate per Km    : ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String location) {
        this.currentLocation = location;
    }
}

class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    public String getCurrentLocation() {
        return getCurrentLocation();
    }

    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return getCurrentLocation();
    }

    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public String getCurrentLocation() {
        return getCurrentLocation();
    }

    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();

        rides.add(new Car("CAR001", "Anil", 15.0, "MG Road"));
        rides.add(new Bike("BIKE002", "Sunil", 8.0, "Sector 21"));
        rides.add(new Auto("AUTO003", "Mukesh", 10.0, "Station"));

        double distance = 10;

        System.out.println("=== Ride Fare Details ===");

        for (Vehicle v : rides) {
            System.out.println("\n-------------------------");
            v.getVehicleDetails();
            System.out.println("Distance         : " + distance + " km");
            System.out.println("Fare             : ₹" + v.calculateFare(distance));
        }
    }
}
