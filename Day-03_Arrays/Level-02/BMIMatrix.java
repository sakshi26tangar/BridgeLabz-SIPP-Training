import java.util.Scanner;

public class BMIMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[][] data = new double[n][3]; // [weight, height, BMI]
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (m) and weight (kg) for person " + (i + 1) + ": ");
            double h = sc.nextDouble(), w = sc.nextDouble();
            while (h <= 0 || w <= 0) {
                System.out.println("Height and weight must be positive. Enter again.");
                h = sc.nextDouble();
                w = sc.nextDouble();
            }
            data[i][0] = w;
            data[i][1] = h;
            data[i][2] = w / (h * h);

            if (data[i][2] < 18.5) status[i] = "Underweight";
            else if (data[i][2] < 24.9) status[i] = "Normal";
            else if (data[i][2] < 29.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ": Height=" + data[i][1] + ", Weight=" + data[i][0] + ", BMI=" + data[i][2] + ", Status=" + status[i]);
        }
    }
}
