import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), sum = 0, original = number;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }
        System.out.println(original + (sum == original ? " is an Armstrong number" : " is not an Armstrong number"));
    }
}
