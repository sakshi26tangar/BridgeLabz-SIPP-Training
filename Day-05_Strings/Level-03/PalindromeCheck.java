import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        boolean logic1 = true;
        for (int i = 0, j = text.length() - 1; i < j; i++, j--) {
            if (text.charAt(i) != text.charAt(j)) {
                logic1 = false;
                break;
            }
        }

        boolean logic2 = isPalindromeRecursive(text, 0, text.length() - 1);

        boolean logic3 = true;
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }
        if (!text.equals(reverse)) logic3 = false;

        System.out.println("Logic 1: " + (logic1 ? "Palindrome" : "Not"));
        System.out.println("Logic 2: " + (logic2 ? "Palindrome" : "Not"));
        System.out.println("Logic 3: " + (logic3 ? "Palindrome" : "Not"));
    }

    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}
