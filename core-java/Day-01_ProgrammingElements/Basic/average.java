import java.util.*;
public class average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int sum = 0;
        sum = (n + m + x);
        sum = sum/3;
        System.out.println("Average is: "+sum);
    }
    
}
