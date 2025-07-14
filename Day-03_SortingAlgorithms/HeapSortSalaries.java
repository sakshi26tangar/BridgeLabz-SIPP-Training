import java.util.Scanner;

public class HeapSortSalaries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();
        int[] salaries = new int[n];
        System.out.println("Enter " + n + " salary expectations:");
        for (int i = 0; i < n; i++) salaries[i] = sc.nextInt();

        heapSort(salaries);

        System.out.println("Sorted Salaries:");
        for (int s : salaries) System.out.print(s + " ");
    }

    static void heapSort(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0]; a[0] = a[i]; a[i] = temp;
            heapify(a, i, 0);
        }
    }

    static void heapify(int[] a, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && a[l] > a[largest]) largest = l;
        if (r < n && a[r] > a[largest]) largest = r;
        if (largest != i) {
            int temp = a[i]; a[i] = a[largest]; a[largest] = temp;
            heapify(a, n, largest);
        }
    }
}
