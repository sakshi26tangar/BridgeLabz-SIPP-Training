import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers (space-separated):");
        List<Integer> list = new ArrayList<>();
        for (String s : sc.nextLine().split(" ")) {
            list.add(Integer.parseInt(s));
        }

        Set<Integer> seen = new LinkedHashSet<>(list);
        List<Integer> result = new ArrayList<>(seen);

        System.out.println("List without duplicates: " + result);
    }
}
