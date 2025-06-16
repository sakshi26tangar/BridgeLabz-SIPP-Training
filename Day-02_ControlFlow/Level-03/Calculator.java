import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        String op = sc.next();

        switch (op) {
            case "+" -> System.out.println("Result: " + (a + b));
            case "-" -> System.out.println("Result: " + (a - b));
            case "*" -> System.out.println("Result: " + (a * b));
            case "/" -> {
                if (b == 0)
                    System.out.println("Division by zero error");
                else
                    System.out.println("Result: " + (a / b));
            }
            default -> System.out.println("Invalid operator");
        }
    }
}
