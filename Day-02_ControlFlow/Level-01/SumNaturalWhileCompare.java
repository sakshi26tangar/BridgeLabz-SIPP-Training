import java.util.Scanner;
public class SumNaturalWhileCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int sum = 0, i = 1;
        while(i <= n) {
            sum += i;
            i++;
        }
        int formulaSum = n * (n + 1) / 2;
        System.out.println("Sum using loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Are both equal? " + (sum == formulaSum));
    }
}
