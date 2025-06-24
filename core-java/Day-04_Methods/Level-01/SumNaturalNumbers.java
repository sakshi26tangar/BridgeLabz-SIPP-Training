import java.util.Scanner;

public class SumNaturalNumbers {
    public static int sumOfN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int sum = sumOfN(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);
    }
}
