import java.util.Scanner;

public class BubbleSortMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Input
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter " + n + " marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        // 2. Bubble Sort
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (marks[i] > marks[i + 1]) {
                    // swap marks[i] and marks[i+1]
                    int temp = marks[i];
                    marks[i] = marks[i + 1];
                    marks[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);   // repeat until no swaps in a full pass

        // 3. Output
        System.out.println("\nSorted marks (ascending):");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}