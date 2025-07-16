import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        StringBuffer sb = new StringBuffer();

        System.out.println("Enter " + n + " strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            sb.append(str);
        }

        System.out.println("Concatenated String: " + sb.toString());
    }
}
