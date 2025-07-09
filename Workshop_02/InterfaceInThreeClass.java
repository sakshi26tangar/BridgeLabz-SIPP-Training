// Interface
interface Vehicle {
    void start();

    // default method
    default void stop() {
        System.out.println("Stopping the vehicle");
    }
}

// Class 1
class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting with a key.");
    }
}

// Class 2
class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting with a kick.");
    }
}

// Class 3
class Truck implements Vehicle {
    public void start() {
        System.out.println("Truck is starting with a button.");
    }
}

public class InterfaceInThreeClass {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle truck = new Truck();

        car.start();
        car.stop();

        bike.start();
        bike.stop();

        truck.start();
        truck.stop();
    }
}
