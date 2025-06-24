public class NumberCheckerPrimeNeonSpyAutoBuzz {
    public static void main(String[] args) {
        int num = 7;
        boolean prime = num > 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { prime = false; break; }
        }
        int sq = num * num;
        int sum = 0, temp = sq;
        while (temp > 0) { sum += temp % 10; temp /= 10; }
        boolean neon = (sum == num);
        temp = num;
        sum = 0;
        int prod = 1;
        while (temp > 0) { int d = temp % 10; sum += d; prod *= d; temp /= 10; }
        boolean spy = (sum == prod);
        String s = String.valueOf(sq);
        boolean auto = s.endsWith(String.valueOf(num));
        boolean buzz = (num % 7 == 0) || (String.valueOf(num).endsWith("7"));
        System.out.println("Prime? " + prime);
        System.out.println("Neon? " + neon);
        System.out.println("Spy? " + spy);
        System.out.println("Automorphic? " + auto);
        System.out.println("Buzz? " + buzz);
    }
}
