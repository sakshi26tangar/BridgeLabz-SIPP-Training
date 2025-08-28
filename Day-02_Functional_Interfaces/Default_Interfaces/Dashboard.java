package Default_Interfaces;

interface Vehicle {
    void displaySpeed(int speed);

    
    default void displayBattery(int percentage) {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class Car implements Vehicle {
    public void displaySpeed(int speed) {
        System.out.println("Car speed: " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed(int speed) {
        System.out.println("Electric Car speed: " + speed + " km/h");
    }

    public void displayBattery(int percentage) {
        System.out.println("Battery: " + percentage + "%");
    }
}

public class Dashboard {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle tesla = new ElectricCar();

        car.displaySpeed(80);
        car.displayBattery(0); // Uses default

        tesla.displaySpeed(100);
        tesla.displayBattery(85); // Uses overridden
    }
}
