import java.util.Scanner;

public class ToCharArrayCompareCustom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        char[] arr1 = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr1[i] = text.charAt(i);
        }

        char[] arr2 = text.toCharArray();

        boolean isSame = true;
        if (arr1.length != arr2.length) isSame = false;
        else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    isSame = false;
                    break;
                }
            }
        }

        System.out.println("Arrays are same: " + isSame);
    }
}
