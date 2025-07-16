import java.util.Scanner;

public class PerformanceComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of times to concatenate \"hello\": ");
        int iterations = sc.nextInt();

        // Using StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = (endBuffer - startBuffer) / 1_000_000; // in milliseconds

        // Using StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = (endBuilder - startBuilder) / 1_000_000; // in milliseconds

        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ms");
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ms");
    }
}
