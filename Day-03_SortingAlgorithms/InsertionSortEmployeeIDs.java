import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Input
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] empIDs = new int[n];
        System.out.println("Enter " + n + " employee IDs:");
        for (int i = 0; i < n; i++) {
            empIDs[i] = sc.nextInt();
        }

        // 2. Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = empIDs[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }

            empIDs[j + 1] = key; // insert key at correct position
        }

        // 3. Output
        System.out.println("\nSorted Employee IDs (ascending):");
        for (int id : empIDs) {
            System.out.print(id + " ");
        }
    }
}
