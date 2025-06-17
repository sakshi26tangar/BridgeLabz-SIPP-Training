import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] heights = new double[11]; 
        double sum = 0.0;                 

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        double mean = sum / heights.length;

        
        System.out.println("\nThe mean height of the football team is: " + mean + " cm");

        scanner.close();
    }
}
   

