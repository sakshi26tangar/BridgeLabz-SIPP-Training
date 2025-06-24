import java.util.Scanner;

public class SplitTextWithoutSplitCompare {
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
        String[] manualWords = new String[spaceCount + 1];
        for (int i = 0; i < manualWords.length; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            manualWords[i] = word;
        }

        String[] splitWords = text.split(" ");
        boolean isSame = true;
        if (manualWords.length != splitWords.length) isSame = false;
        else {
            for (int i = 0; i < manualWords.length; i++) {
                if (!manualWords[i].equals(splitWords[i])) {
                    isSame = false;
                    break;
                }
            }
        }

        System.out.println("Manual and split() results same: " + isSame);
    }
}
