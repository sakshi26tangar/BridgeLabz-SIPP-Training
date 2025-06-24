import java.util.Scanner;

public class ConvertToUpperCustomCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String upper1 = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                upper1 += (char)(ch - 32);
            } else {
                upper1 += ch;
            }
        }

        String upper2 = text.toUpperCase();

        boolean isSame = true;
        for (int i = 0; i < upper1.length(); i++) {
            if (upper1.charAt(i) != upper2.charAt(i)) {
                isSame = false;
                break;
            }
        }

        System.out.println("Both uppercase versions are same: " + isSame);
    }
}
