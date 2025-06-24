public class FactorsSumProductCube {
    public static void main(String[] args) {
        int num = 12;
        int count = 0;
        for (int i = 1; i <= num; i++) if (num % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= num; i++) if (num % i == 0) factors[idx++] = i;
        int sum = 0, prod = 1, cubeProd = 1, max = 0;
        for (int f : factors) {
            sum += f;
            prod *= f;
            cubeProd *= Math.pow(f, 3);
            if (f > max) max = f;
        }
        System.out.println("Factors:");
        for (int f : factors) System.out.print(f + " ");
        System.out.println("\nGreatest: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + prod);
        System.out.println("Cube Product: " + cubeProd);
    }
}
