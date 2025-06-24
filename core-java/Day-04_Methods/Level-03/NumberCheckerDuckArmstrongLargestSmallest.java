public class NumberCheckerDuckArmstrongLargestSmallest {
    public static void main(String[] args) {
        int num = 153;
        String s = String.valueOf(num);
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';
        boolean duck = false;
        for (int d : digits) if (d == 0) { duck = true; break; }
        int armSum = 0;
        for (int d : digits) armSum += Math.pow(d, n);
        boolean armstrong = (armSum == num);
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d > max1) { max2 = max1; max1 = d; }
            else if (d > max2) max2 = d;
            if (d < min1) { min2 = min1; min1 = d; }
            else if (d < min2) min2 = d;
        }
        System.out.println("Duck number? " + duck);
        System.out.println("Armstrong? " + armstrong);
        System.out.println("Largest: " + max1 + ", 2nd Largest: " + max2);
        System.out.println("Smallest: " + min1 + ", 2nd Smallest: " + min2);
    }
}
