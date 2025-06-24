public class PerfectAbundantDeficientStrongNumber {
    public static void main(String[] args) {
        int num = 145;
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }
        boolean strong = (sum == num);

        sum = 0;
        for (int i = 1; i <= num / 2; i++) if (num % i == 0) sum += i;
        boolean perfect = sum == num;
        boolean abundant = sum > num;
        boolean deficient = sum < num;

        System.out.println("Strong? " + strong);
        System.out.println("Perfect? " + perfect);
        System.out.println("Abundant? " + abundant);
        System.out.println("Deficient? " + deficient);
    }

    static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }
}
