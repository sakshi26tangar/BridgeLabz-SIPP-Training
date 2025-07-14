import java.util.Scanner;

public class CountingSortStudentAges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter " + n + " student ages (10 to 18):");
        for (int i = 0; i < n; i++) ages[i] = sc.nextInt();

        int[] count = new int[9]; // for ages 10 to 18
        for (int age : ages) count[age - 10]++;

        System.out.println("Sorted Ages:");
        for (int i = 0; i < 9; i++) {
            while (count[i]-- > 0) System.out.print((i + 10) + " ");
        }
    }
}
