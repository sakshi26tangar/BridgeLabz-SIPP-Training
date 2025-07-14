import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; 
        int target = -1; 

        System.out.printf("%-15s%-20s%-20s\n", "Dataset Size", "Linear Search (ms)", "Binary Search (ms)");
        for (int size : sizes) {
            int[] dataset = generateData(size);
            int[] sortedDataset = Arrays.copyOf(dataset, dataset.length);
            Arrays.sort(sortedDataset); 

            long linearTime = timeLinearSearch(dataset, target);
            long binaryTime = timeBinarySearch(sortedDataset, target);

            System.out.printf("%-15d%-20d%-20d\n", size, linearTime, binaryTime);
        }
    }

    
    public static int[] generateData(int size) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 10);
        }
        return data;
    }

    
    public static long timeLinearSearch(int[] data, int target) {
        long start = System.nanoTime();
        for (int num : data) {
            if (num == target) break;
        }
        return (System.nanoTime() - start) / 1_000_000; // ms
    }

   
    public static long timeBinarySearch(int[] data, int target) {
        long start = System.nanoTime();
        Arrays.binarySearch(data, target);
        return (System.nanoTime() - start) / 1_000_000; // ms
    }
}
