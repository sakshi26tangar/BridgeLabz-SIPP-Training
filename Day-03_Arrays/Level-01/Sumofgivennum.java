import java.util.Scanner;

public class Sumofgivennum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[10];  
        double total = 0.0;                 
        int index = 0;                      

        System.out.println("Enter up to 10 positive numbers (enter 0 or negative to stop):");

        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double input = scanner.nextDouble();

            // Stop if 0 or negative
            if (input <= 0) {
                break;
            }

            // Stop if array is full
            if (index == 10) {
                System.out.println("Maximum of 10 numbers reached.");
                break;
            }

            numbers[index] = input;  // Store the value in array
            index++;                 // Move to next index
        }

        // Show all stored numbers and calculate total
        
        for (int i = 0; i < index; i++) {
            
            total += numbers[i];
        }

        System.out.println("\nTotal of all numbers: " + total);

        scanner.close();
    }
}
