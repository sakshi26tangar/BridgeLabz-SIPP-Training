import java.util.Scanner;

public class DemoNumberFormatException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numText = sc.next();

        try {
            int num = Integer.parseInt(numText);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }
}
