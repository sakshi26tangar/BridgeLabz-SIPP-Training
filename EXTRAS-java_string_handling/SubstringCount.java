public class SubstringCount {
    public static int countOccurrences(String str, String substr) {
        int count = 0, index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }
        return count;
    }
}