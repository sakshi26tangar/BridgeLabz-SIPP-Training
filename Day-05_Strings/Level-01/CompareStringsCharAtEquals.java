import java.util.Scanner;

public class CompareStringsCharAtEquals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        boolean isEqual = true;
        if (str1.length() != str2.length()) {
            isEqual = false;
        } else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    isEqual = false;
                    break;
                }
            }
        }

        System.out.println("Using charAt: " + isEqual);
        System.out.println("Using equals: " + str1.equals(str2));
        System.out.println("Both results same: " + (isEqual == str1.equals(str2)));
    }
}
