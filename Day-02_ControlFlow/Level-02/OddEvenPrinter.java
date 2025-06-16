import java.util.Scanner;
public class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Not a natural number.");
            return;
        }
        for (int i = 1; i <= number; i++) {
            System.out.println(i + " is " + (i % 2 == 0 ? "Even" : "Odd"));
        }
    }
}
