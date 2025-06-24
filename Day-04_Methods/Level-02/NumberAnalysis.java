import java.util.*;

public class NumberAnalysis {
    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a < b) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            if (!isPositive(arr[i])) System.out.println("Negative");
            else {
                System.out.println("Positive");
                System.out.println(isEven(arr[i]) ? "Even" : "Odd");
            }
        }
        int result = compare(arr[0], arr[4]);
        if (result == 0) System.out.println("Equal");
        else if (result > 0) System.out.println("First Greater");
        else System.out.println("Last Greater");
    }
}

