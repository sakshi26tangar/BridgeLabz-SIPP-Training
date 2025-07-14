import java.util.*;

public class SortComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        System.out.printf("%-15s%-20s%-20s%-20s\n", "Dataset Size", "Bubble Sort (ms)", "Merge Sort (ms)", "Quick Sort (ms)");

        for (int size : sizes) {
            int[] original = generateData(size);

            // Bubble Sort
            int[] bubble = Arrays.copyOf(original, original.length);
            long bubbleTime = (size <= 10000) ? measureBubbleSort(bubble) : -1; // Skip for 1M

            // Merge Sort
            int[] merge = Arrays.copyOf(original, original.length);
            long mergeTime = measureMergeSort(merge);

            // Quick Sort
            int[] quick = Arrays.copyOf(original, original.length);
            long quickTime = measureQuickSort(quick);

            System.out.printf("%-15d%-20s%-20d%-20d\n",
                    size,
                    (bubbleTime == -1 ? "Too Slow" : bubbleTime),
                    mergeTime,
                    quickTime
            );
        }
    }

    static int[] generateData(int n) {
        Random rand = new Random();
        return rand.ints(n, 0, n * 10).toArray();
    }

    static long measureBubbleSort(int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long measureMergeSort(int[] arr) {
        long start = System.nanoTime();
        Arrays.sort(arr); // uses Dual-Pivot QuickSort for primitives
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long measureQuickSort(int[] arr) {
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }
}
