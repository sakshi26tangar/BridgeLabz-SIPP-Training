import java.util.*;
public class volumeofCyclinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the cylinder: ");
        double r = sc.nextDouble();
        System.out.println("Enter the height of the cylinder: ");
        double h = sc.nextDouble();
        double volume = (22/7)*Math.pow(r,2)*h;
        System.out.println("The volume of the cylinder is: "+volume);
    }
}
