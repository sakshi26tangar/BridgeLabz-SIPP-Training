import java.util.Arrays;
public class AnagramCheck {
    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";
        if (a.length() != b.length()) {
            System.out.println("Not anagrams");
        } else {
            char[] ac = a.toCharArray();
            char[] bc = b.toCharArray();
            Arrays.sort(ac);
            Arrays.sort(bc);
            System.out.println(Arrays.equals(ac, bc) ? "Anagrams" : "Not anagrams");
        }
    }
}
