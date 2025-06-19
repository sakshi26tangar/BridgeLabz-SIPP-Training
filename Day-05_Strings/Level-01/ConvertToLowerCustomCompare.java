import java.util.Scanner;

public class ConvertToLowerCustomCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String lower1 = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lower1 += (char)(ch + 32);
            } else {
                lower1 += ch;
            }
        }

        String lower2 = text.toLowerCase();

        boolean isSame = true;
        for (int i = 0; i < lower1.length(); i++) {
            if (lower1.charAt(i) != lower2.charAt(i)) {
                isSame = false;
                break;
            }
        }

        System.out.println("Both lowercase versions are same: " + isSame);
    }
}
