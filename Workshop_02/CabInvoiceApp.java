import java.util.*;

interface PricingStrategy {
    double minFare();
    double costPerKm();
    double costPerMin();

    default double calculateFare(int km, int minutes) {
        double fare = km * costPerKm() + minutes * costPerMin();
        return Math.max(fare, minFare());
    }
}


final class NormalPricing implements PricingStrategy {
    public double minFare()    { return 5.0; }
    public double costPerKm()  { return 10.0; }
    public double costPerMin() { return 1.0; }
}


final class PremiumPricing implements PricingStrategy {
    public double minFare()    { return 20.0; }
    public double costPerKm()  { return 15.0; }
    public double costPerMin() { return 2.0; }
}

/** A single customer ride. */
final class Ride {
    private final int distanceKm;
    private final int timeMin;
    private final PricingStrategy pricing;

    Ride(int distanceKm, int timeMin, PricingStrategy pricing) {
        this.distanceKm = distanceKm;
        this.timeMin    = timeMin;
        this.pricing    = pricing;
    }

    double fare() {
        return pricing.calculateFare(distanceKm, timeMin);
    }
}


final class RideRepository {
    private final Map<String, List<Ride>> data = new HashMap<>();

    void addRides(String userId, List<Ride> rides) {
        data.put(userId, new ArrayList<>(rides));
    }

    List<Ride> findByUser(String userId) {
        return data.getOrDefault(userId, Collections.emptyList());
    }
}


final class InvoiceService {

    static class Summary {
        final int totalRides;
        final double totalFare;
        final double averageFare;

        Summary(int totalRides, double totalFare) {
            this.totalRides  = totalRides;
            this.totalFare   = totalFare;
            this.averageFare = totalFare / totalRides;
        }
    }

    Summary generate(List<Ride> rides) {
        if (rides.isEmpty()) throw new IllegalArgumentException("No rides found");
        double total = rides.stream().mapToDouble(Ride::fare).sum();
        return new Summary(rides.size(), total);
    }
}


public class CabInvoiceApp {

    private final RideRepository repo = new RideRepository();
    private final InvoiceService  invoicer = new InvoiceService();

    public static void main(String[] args) {
        new CabInvoiceApp().run();
    }

    private void run() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter User ID: ");
            String userId = sc.nextLine().trim();

            System.out.print("Enter number of rides: ");
            int n = Integer.parseInt(sc.nextLine().trim());

            List<Ride> rides = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                System.out.println("--- Ride " + i + " ---");
                System.out.print("Distance (km): ");
                int km = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Time (min): ");
                int min = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Premium ride? (yes/no): ");
                boolean premium = sc.nextLine().trim().equalsIgnoreCase("yes");

                PricingStrategy pricing = premium ? new PremiumPricing() : new NormalPricing();
                rides.add(new Ride(km, min, pricing));
            }

            repo.addRides(userId, rides);
            printInvoice(userId);
        }
    }

    private void printInvoice(String userId) {
        List<Ride> rides = repo.findByUser(userId);
        if (rides.isEmpty()) {
            System.out.println("No rides found for user.");
            return;
        }

        InvoiceService.Summary s = invoicer.generate(rides);

        System.out.println("\n------ Invoice Summary ------");
        System.out.println("Total Rides       : " + s.totalRides);
        System.out.printf ("Total Fare        : %.2f%n", s.totalFare);
        System.out.printf ("Average Fare/Ride : %.2f%n", s.averageFare);
    }
}
