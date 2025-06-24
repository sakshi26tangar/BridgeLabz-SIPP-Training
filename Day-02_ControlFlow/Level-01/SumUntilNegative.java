import java.util.Scanner;
public class SumUntilNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while(true) {
            double num = sc.nextDouble();
            if(num <= 0) break;
            total += num;
        }
        System.out.println("Total = " + total);
    }
}
