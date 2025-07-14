public class StringConcatPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        System.out.printf("%-15s%-20s%-20s%-20s\n", "Count", "String (ms)", "StringBuilder (ms)", "StringBuffer (ms)");

        for (int n : sizes) {
            long t1 = timeString(n);
            long t2 = timeStringBuilder(n);
            long t3 = timeStringBuffer(n);

            System.out.printf("%-15d%-20s%-20d%-20d\n", n, (t1 > 1_000_000 ? "Too Slow" : t1), t2, t3);
        }
    }

    static long timeString(int n) {
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) s += "a";
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long timeStringBuilder(int n) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long timeStringBuffer(int n) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("a");
        return (System.nanoTime() - start) / 1_000_000;
    }
}
