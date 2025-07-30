import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        List<Policy> policies = Arrays.asList(
                new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000),
                new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3000),
                new Policy("P103", "Charlie", LocalDate.now().plusDays(20), "Home", 4500),
                new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000), // Duplicate
                new Policy("P104", "Daisy", LocalDate.now().plusDays(5), "Auto", 2000),
                new Policy("P105", "Evan", LocalDate.now().plusDays(60), "Health", 7000)
        );

        for (Policy p : policies) {
            manager.addPolicy(p);
        }

        manager.printAllPolicies();
        manager.printExpiringSoon();
        manager.printByCoverageType("Auto");
        manager.printDuplicatePolicies(policies);
        manager.comparePerformance(policies);
    }
}
