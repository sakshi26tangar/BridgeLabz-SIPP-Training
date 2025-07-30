import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter integers for the Set (space-separated):");
            Set<Integer> set = new HashSet<>();
            for (String s : sc.nextLine().split(" ")) {
                set.add(Integer.parseInt(s));
            }

            List<Integer> sortedList = new ArrayList<>(set);
            Collections.sort(sortedList);

            System.out.println("Sorted List: " + sortedList);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
