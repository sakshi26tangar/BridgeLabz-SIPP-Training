public class PalindromeCheck {
    public static void main(String[] args) {
        String text = "madam";
        boolean isPalindrome = true;
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("Palindrome: " + isPalindrome);
    }
}
