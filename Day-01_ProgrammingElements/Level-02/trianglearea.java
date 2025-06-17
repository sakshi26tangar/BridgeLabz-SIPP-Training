import java.util.*;
public class trianglearea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base of the triangle in cm: ");
        double base = sc.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double height = sc.nextDouble();

        
        double areaInSqCm = 0.5 * base * height;

       
        double areaInSqIn = areaInSqCm / 6.4516;

        // Output the result
        System.out.println("The Area of the triangle in sq in is " + areaInSqIn + " and sq cm is " + areaInSqCm);
    }
}

