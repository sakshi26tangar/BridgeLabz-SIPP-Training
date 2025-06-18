import java.util.Scanner;

public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        double[] trig = calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + trig[0]);
        System.out.println("Cosine: " + trig[1]);
        System.out.println("Tangent: " + trig[2]);
    }
}
