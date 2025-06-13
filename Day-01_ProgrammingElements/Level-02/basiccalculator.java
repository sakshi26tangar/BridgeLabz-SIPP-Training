import java.util.*;

public class basiccalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();
        float addition = num1 + num2;
        float subtraction = num1 - num2;
        float multiplication = num1 * num2;
        float division = num1 / num2;

         System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " 
            + num1 + " and " + num2 + " is " 
            + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
    }
}
