import java.util.*;

class Ride {
    double distance;
    int time;
    String type; // "normal" or "premium"

    Ride(double distance, int time, String type) {
        this.distance = distance;
        this.time = time;
        this.type = type.toLowerCase();
    }
}

class InvoiceSummary {
    int totalRides;
    double totalFare;
    double averageFare;

    InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / totalRides;
    }

    void printSummary() {
        System.out.println("\n----- Invoice Summary -----");
        System.out.println("Total Rides: " + totalRides);
        System.out.println("Total Fare: " + totalFare);
        System.out.printf("Average Fare: %.2f\n", averageFare);
    }
}

class CabInvoiceGenerator {
    HashMap<String, ArrayList<Ride>> userRides = new HashMap<>();

    void addRides(String userId, Ride[] rides) {
        userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    double calculateFare(Ride ride) {
        double costPerKm = ride.type.equals("premium") ? 15 : 10;
        int costPerMin = ride.type.equals("premium") ? 2 : 1;
        double minFare = ride.type.equals("premium") ? 20 : 5;

        double fare = ride.distance * costPerKm + ride.time * costPerMin;
        return Math.max(fare, minFare);
    }

    InvoiceSummary getInvoice(String userId) {
        ArrayList<Ride> rides = userRides.get(userId);
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }
}

public class CabInvoiceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CabInvoiceGenerator generator = new CabInvoiceGenerator();

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter number of rides: ");
        int n = sc.nextInt();

        Ride[] rides = new Ride[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Ride " + (i + 1));
            System.out.print("Distance (in km): ");
            double distance = sc.nextDouble();

            System.out.print("Time (in minutes): ");
            int time = sc.nextInt();

            sc.nextLine(); // clear buffer
            System.out.print("Type (normal/premium): ");
            String type = sc.nextLine();

            rides[i] = new Ride(distance, time, type);
        }

        generator.addRides(userId, rides);

        InvoiceSummary summary = generator.getInvoice(userId);
        summary.printSummary();

        sc.close();
    }
}
