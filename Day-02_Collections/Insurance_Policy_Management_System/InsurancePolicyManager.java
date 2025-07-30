import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    public void printAllPolicies() {
        System.out.println("All Policies:");
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }

    public void printExpiringSoon() {
        System.out.println("\nExpiring in next 30 days:");
        LocalDate today = LocalDate.now();
        for (Policy p : treeSet) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(today.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    public void printByCoverageType(String type) {
        System.out.println("\nPolicies with coverage type: " + type);
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void printDuplicatePolicies(List<Policy> policies) {
        System.out.println("\nDuplicate Policies:");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy p : policies) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        for (Policy p : policies) {
            if (duplicates.contains(p.getPolicyNumber())) {
                System.out.println(p);
            }
        }
    }

    public void comparePerformance(List<Policy> policyList) {
        System.out.println("\nPerformance Comparison:");

        compareSetPerformance(new HashSet<>(), "HashSet", policyList);
        compareSetPerformance(new LinkedHashSet<>(), "LinkedHashSet", policyList);
        compareSetPerformance(new TreeSet<>(), "TreeSet", policyList);
    }

    private void compareSetPerformance(Set<Policy> set, String setName, List<Policy> policies) {
        long start = System.nanoTime();
        for (Policy p : policies) {
            set.add(p);
        }
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (Policy p : policies) {
            set.contains(p);
        }
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (Policy p : policies) {
            set.remove(p);
        }
        long removeTime = System.nanoTime() - start;

        System.out.println(setName + " → Add: " + addTime + " ns, Search: " + searchTime + " ns, Remove: " + removeTime + " ns");
    }
}
