import java.util.Scanner;
public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        System.out.println(num + (sum > num ? " is Abundant" : " is not Abundant"));
    }
}
