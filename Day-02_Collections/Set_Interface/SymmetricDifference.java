import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter elements of Set1 (space-separated):");
            Set<Integer> set1 = new HashSet<>();
            for (String s : sc.nextLine().split(" ")) {
                set1.add(Integer.parseInt(s));
            }

            System.out.println("Enter elements of Set2 (space-separated):");
            Set<Integer> set2 = new HashSet<>();
            for (String s : sc.nextLine().split(" ")) {
                set2.add(Integer.parseInt(s));
            }

            Set<Integer> result = new HashSet<>(set1);
            result.addAll(set2);

            Set<Integer> common = new HashSet<>(set1);
            common.retainAll(set2);

            result.removeAll(common);

            System.out.println("Symmetric Difference: " + result);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
