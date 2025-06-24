import java.util.Scanner;

public class SubstringCompareCharAtSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String sub1 = "";
        for (int i = start; i < end; i++) {
            sub1 += text.charAt(i);
        }

        String sub2 = text.substring(start, end);

        boolean isSame = true;
        if (sub1.length() != sub2.length()) isSame = false;
        else {
            for (int i = 0; i < sub1.length(); i++) {
                if (sub1.charAt(i) != sub2.charAt(i)) {
                    isSame = false;
                    break;
                }
            }
        }

        System.out.println("Substring using charAt: " + sub1);
        System.out.println("Substring using substring(): " + sub2);
        System.out.println("Both substrings are same: " + isSame);
    }
}
