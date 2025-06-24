import java.util.Scanner;
public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), i = 1;
        if (number <= 0) {
            System.out.println("Enter a positive number.");
            return;
        }
        while (i < number) {
            if (number % i == 0) System.out.print(i + " ");
            i++;
        }
    }
}
