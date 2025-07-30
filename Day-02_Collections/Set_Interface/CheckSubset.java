import java.util.*;

public class CheckSubset {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter elements of Subset (space-separated):");
            Set<Integer> subset = new HashSet<>();
            for (String s : sc.nextLine().split(" ")) {
                subset.add(Integer.parseInt(s));
            }

            System.out.println("Enter elements of Superset (space-separated):");
            Set<Integer> superset = new HashSet<>();
            for (String s : sc.nextLine().split(" ")) {
                superset.add(Integer.parseInt(s));
            }

            boolean isSubset = superset.containsAll(subset);
            System.out.println("Is Subset? " + isSubset);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
