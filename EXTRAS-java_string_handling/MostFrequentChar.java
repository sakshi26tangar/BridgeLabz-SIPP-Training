public class MostFrequentChar {
    public static char mostFrequentChar(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray())
            freq[c]++;
        int max = 0;
        char result = ' ';
        for (char c : str.toCharArray()) {
            if (freq[c] > max) {
                max = freq[c];
                result = c;
            }
        }
        return result;
    }
}