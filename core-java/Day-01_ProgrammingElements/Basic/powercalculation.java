import java.util.*;
public class powercalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base number: ");
        int base = sc.nextInt();
        System.out.println("Enter the exponent: ");
        int exponent = sc.nextInt();
        double result = Math.pow(base, exponent);
        System.out.println("The result is: " + result);
    }
}
