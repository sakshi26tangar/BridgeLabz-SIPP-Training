public class CharFrequencyNestedLoop {
    public static void main(String[] args) {
        String text = "programming";
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (chars[i] != ' ' && chars[i] != '0') {
                System.out.println(chars[i] + " - " + freq[i]);
            }
        }
    }
}
