import java.util.Scanner;

public class MergeSortBookPrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter " + n + " book prices:");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        mergeSort(prices, 0, n - 1);

        System.out.println("Sorted Book Prices:");
        for (int p : prices) System.out.print(p + " ");
    }

    static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static void merge(int[] a, int l, int m, int r) {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        for (int i = 0; i < left.length; i++) left[i] = a[l + i];
        for (int i = 0; i < right.length; i++) right[i] = a[m + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            a[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];

        while (i < left.length) a[k++] = left[i++];
        while (j < right.length) a[k++] = right[j++];
    }
}
