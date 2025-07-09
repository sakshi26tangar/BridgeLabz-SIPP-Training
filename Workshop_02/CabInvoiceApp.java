import java.util.*;

public class CabInvoiceGenerator {
    static final double MIN_FARE = 5.0;
    static final double COST_PER_KM = 10.0;
    static final double COST_PER_MIN = 1.0;

    // Ride structure using simple array
    static class Ride {
        int distance, time;
        Ride(int d, int t) {
            distance = d;
            time = t;
        }
    }

    // Map to store user rides
    static Map<String, List<Ride>> userRides = new HashMap<>();

    // Fare calculation
    static double calculateFare(int distance, int time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(fare, MIN_FARE);
    }

    // Generate invoice
    static void generateInvoice(String userId) {
        List<Ride> rides = userRides.getOrDefault(userId, new ArrayList<>());
        double totalFare = 0;
        for (Ride ride : rides)
            totalFare += calculateFare(ride.distance, ride.time);

        int totalRides = rides.size();
        double avgFare = totalRides > 0 ? totalFare / totalRides : 0;

        System.out.println("------ Invoice Summary ------");
        System.out.println("Total Rides       : " + totalRides);
        System.out.println("Total Fare        : " + totalFare);
        System.out.println("Average Fare/Ride : " + avgFare);
    }

    //main code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter number of rides: ");
        int n = sc.nextInt();

        List<Ride> rides = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter distance and time for ride " + (i + 1) + ":");
            int d = sc.nextInt(), t = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter ride type (normal/premium): ");
            sc.nextLine(); // read and ignore (not used)
            rides.add(new Ride(d, t));
        }

        userRides.put(userId, rides);
        generateInvoice(userId);
    }
}
