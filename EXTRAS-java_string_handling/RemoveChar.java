public class RemoveChar {
    public static String removeChar(String str, char ch) {
        return str.replaceAll(String.valueOf(ch), "");
    }
}