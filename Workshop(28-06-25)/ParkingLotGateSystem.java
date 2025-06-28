import java.util.Scanner;

public class ParkingLotGateSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = 5; // total parking slots
        int occupied = 0;

        while (true) {
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Quit System");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (occupied < capacity) {
                        occupied++;
                        System.out.println("Vehicle Parked. Slots Left: " + (capacity - occupied));
                    } else {
                        System.out.println("Parking Lot Full!");
                    }
                    break;

                case 2:
                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Vehicle Exited. Slots Available: " + (capacity - occupied));
                    } else {
                        System.out.println("No vehicles to exit.");
                    }
                    break;

                case 3:
                    System.out.println("Occupied Slots: " + occupied + " / " + capacity);
                    break;

                case 4:
                    System.out.println("Exiting Parking System. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }

            if (occupied == capacity) {
                System.out.println("Note: Parking is currently FULL.");
            }
        }
    }
}
