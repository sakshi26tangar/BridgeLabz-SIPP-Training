public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        System.out.printf("%-10s%-20s%-20s\n", "N", "Recursive (ms)", "Iterative (ms)");

        for (int n : testValues) {
            long recTime = (n <= 30) ? timeRecursive(n) : -1;
            long itTime = timeIterative(n);

            System.out.printf("%-10d%-20s%-20d\n", n, (recTime == -1 ? "Too Slow" : recTime), itTime);
        }
    }

    static long timeRecursive(int n) {
        long start = System.nanoTime();
        fibonacciRecursive(n);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long timeIterative(int n) {
        long start = System.nanoTime();
        fibonacciIterative(n);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
