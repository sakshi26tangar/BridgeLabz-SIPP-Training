import java.util.Scanner;

public class CharacterTypeVowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        System.out.println("Char\tType");
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char lower = ch >= 'A' && ch <= 'Z' ? (char)(ch + 32) : ch;

            if (lower >= 'a' && lower <= 'z') {
                if ("aeiou".indexOf(lower) != -1) System.out.println(ch + "\tVowel");
                else System.out.println(ch + "\tConsonant");
            } else {
                System.out.println(ch + "\tNot a Letter");
            }
        }
    }
}
