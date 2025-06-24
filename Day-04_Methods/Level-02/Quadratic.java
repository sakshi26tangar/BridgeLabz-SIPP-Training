import java.util.*;

public class Quadratic {
    public static void findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Roots: " + r1 + ", " + r2);
        } else if (delta == 0) {
            double r = -b / (2 * a);
            System.out.println("Root: " + r);
        } else {
            System.out.println("No real roots");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        findRoots(a, b, c);
    }
}
