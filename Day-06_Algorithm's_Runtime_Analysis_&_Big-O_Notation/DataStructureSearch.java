import java.util.*;

public class DataStructureSearch {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        int target = -1;

        System.out.printf("%-15s%-20s%-20s%-20s\n", "Dataset Size", "Array (ms)", "HashSet (ms)", "TreeSet (ms)");

        for (int size : sizes) {
            int[] arr = generateData(size);
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int val : arr) {
                hashSet.add(val);
                treeSet.add(val);
            }

            long arrayTime = timeArraySearch(arr, target);
            long hashTime = timeHashSetSearch(hashSet, target);
            long treeTime = timeTreeSetSearch(treeSet, target);

            System.out.printf("%-15d%-20d%-20d%-20d\n", size, arrayTime, hashTime, treeTime);
        }
    }

    static int[] generateData(int size) {
        Random rand = new Random();
        return rand.ints(size, 0, size * 10).toArray();
    }

    static long timeArraySearch(int[] arr, int target) {
        long start = System.nanoTime();
        for (int num : arr) {
            if (num == target) break;
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long timeHashSetSearch(HashSet<Integer> set, int target) {
        long start = System.nanoTime();
        set.contains(target);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long timeTreeSetSearch(TreeSet<Integer> set, int target) {
        long start = System.nanoTime();
        set.contains(target);
        return (System.nanoTime() - start) / 1_000_000;
    }
}
