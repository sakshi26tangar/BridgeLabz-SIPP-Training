import java.util.Scanner;

public class TrimSpacesUsingCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int start = 0, end = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        String trimmed = "";
        for (int i = start; i <= end; i++) {
            trimmed += text.charAt(i);
        }

        String builtinTrim = text.trim();

        boolean isSame = true;
        if (trimmed.length() != builtinTrim.length()) isSame = false;
        else {
            for (int i = 0; i < trimmed.length(); i++) {
                if (trimmed.charAt(i) != builtinTrim.charAt(i)) {
                    isSame = false;
                    break;
                }
            }
        }

        System.out.println("Trimmed manually: " + trimmed);
        System.out.println("Trimmed using trim(): " + builtinTrim);
        System.out.println("Are both same: " + isSame);
    }
}
