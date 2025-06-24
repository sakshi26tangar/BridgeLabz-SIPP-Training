import java.util.Scanner;

public class SplitTextAndReturnWordLength2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int spaceCount = 0;
        for (int i = 0; ; i++) {
            try {
                if (text.charAt(i) == ' ') spaceCount++;
            } catch (Exception e) {
                break;
            }
        }

        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1;
        int idx = 1;
        for (int i = 0; ; i++) {
            try {
                if (text.charAt(i) == ' ') {
                    spaceIndexes[idx++] = i;
                }
            } catch (Exception e) {
                break;
            }
        }

        spaceIndexes[idx] = text.length();
        String[][] result = new String[spaceCount + 1][2];
        for (int i = 0; i < result.length; i++) {
            String word = "";
            int len = 0;
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
                len++;
            }
            result[i][0] = word;
            result[i][1] = String.valueOf(len);
        }

        System.out.println("Word\tLength");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + Integer.parseInt(result[i][1]));
        }
    }
}
