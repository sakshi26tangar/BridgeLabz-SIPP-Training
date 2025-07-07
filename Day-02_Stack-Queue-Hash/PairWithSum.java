import java.util.*;

public class PairWithSum {
    public static boolean hasPair(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 3, 2};
        int target = 9;
        System.out.println("Pair exists? " + hasPair(arr, target));
    }
}
