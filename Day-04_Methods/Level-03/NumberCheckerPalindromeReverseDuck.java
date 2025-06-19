public class NumberCheckerPalindromeReverseDuck {
    public static void main(String[] args) {
        int num = 121;
        String s = String.valueOf(num);
        int n = s.length();
        int[] digits = new int[n];
        boolean duck = false;
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
            if (digits[i] == 0) duck = true;
        }
        int rev = 0;
        for (int d : digits) rev = rev * 10 + d;
        boolean palindrome = (rev == num);
        System.out.println("Duck? " + duck);
        System.out.println("Palindrome? " + palindrome);
    }
}
