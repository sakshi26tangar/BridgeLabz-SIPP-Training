import java.util.Scanner;
public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("Is the number " + number + " divisible by 5? " + (number % 5 == 0));
    }
}
