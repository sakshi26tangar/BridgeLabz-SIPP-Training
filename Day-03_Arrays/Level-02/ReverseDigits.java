import java.util.Scanner;

public class ReverseDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int count = (int) Math.log10(num) + 1;
        int[] digits = new int[count];
        int index = 0;

        while (num != 0) {
            digits[index++] = num % 10;
            num /= 10;
        }

        System.out.print("Reversed Number: ");
        for (int i = 0; i < index; i++)
            System.out.print(digits[i]);
    }
}
