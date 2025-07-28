import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers (space-separated):");
        List<Integer> list = new ArrayList<>();
        for (String s : sc.nextLine().split(" ")) {
            list.add(Integer.parseInt(s));
        }

        System.out.print("Enter rotation count: ");
        int k = sc.nextInt();
        int n = list.size();
        k = k % n;

        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));

        System.out.println("Rotated List: " + rotated);
    }
}
