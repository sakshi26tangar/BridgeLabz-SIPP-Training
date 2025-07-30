import java.util.*;

public class SetEquality {
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

            boolean isEqual = set1.equals(set2);
            System.out.println("Are the sets equal? " + isEqual);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
