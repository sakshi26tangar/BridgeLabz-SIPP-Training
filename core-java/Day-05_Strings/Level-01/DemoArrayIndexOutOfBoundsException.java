import java.util.Scanner;

public class DemoArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"John", "Alice", "Bob"};
        int index = sc.nextInt();

        try {
            System.out.println(names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }
}
