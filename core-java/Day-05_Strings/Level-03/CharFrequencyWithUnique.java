import java.util.Scanner;

public class CharFrequencyWithUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] unique = new char[text.length()];
        int idx = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[idx++] = ch;
            }
        }

        System.out.println("Character\tFrequency");
        for (int i = 0; i < idx; i++) {
            System.out.println(unique[i] + "\t\t" + freq[unique[i]]);
        }
    }
}
