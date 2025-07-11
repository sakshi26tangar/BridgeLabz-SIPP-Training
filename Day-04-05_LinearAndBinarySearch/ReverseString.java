import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Use StringBuilder to reverse the string
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();

        // Output the reversed string
        String reversed = sb.toString();
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}
