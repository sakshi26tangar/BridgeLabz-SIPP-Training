import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to remove duplicates: ");
        String input = sc.nextLine();

        String result = removeDuplicates(input);
        System.out.println("Without duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            boolean isDuplicate = false;

            // Check if the character already exists in StringBuilder
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == current) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                sb.append(current);
            }
        }

        return sb.toString();
    }
}
