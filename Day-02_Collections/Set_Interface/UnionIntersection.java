import java.util.*;

public class UnionIntersection {
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

            Set<Integer> union = new HashSet<>(set1);
            union.addAll(set2);

            Set<Integer> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);

            System.out.println("Union: " + union);
            System.out.println("Intersection: " + intersection);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
