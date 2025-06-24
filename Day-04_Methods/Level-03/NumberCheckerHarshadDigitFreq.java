public class NumberCheckerHarshadDigitFreq {
    public static void main(String[] args) {
        int num = 21;
        String s = String.valueOf(num);
        int n = s.length();
        int[] digits = new int[n];
        int sumDigits = 0;
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
            sumDigits += digits[i];
        }
        boolean harshad = (num % sumDigits == 0);
        int[][] freq = new int[10][2];
        for (int d = 0; d < 10; d++) freq[d][0] = d;
        for (int d : digits) freq[d][1]++;
        System.out.println("Harshad? " + harshad);
        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0) System.out.println(i + ": " + freq[i][1]);
        }
    }
}
