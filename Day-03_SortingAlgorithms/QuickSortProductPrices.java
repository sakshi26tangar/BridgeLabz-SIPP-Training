import java.util.Scanner;

public class QuickSortProductPrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter " + n + " product prices:");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Product Prices:");
        for (int p : prices) System.out.print(p + " ");
    }

    static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
            }
        }
        int temp = a[i + 1]; a[i + 1] = a[high]; a[high] = temp;
        return i + 1;
    }
}
