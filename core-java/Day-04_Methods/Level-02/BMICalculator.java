import java.util.*;

public class BMICalculator {
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        return weight / (heightM * heightM);
    }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            double weight = sc.nextDouble();
            double height = sc.nextDouble();
            double bmi = calculateBMI(weight, height);
            data[i][0] = weight;
            data[i][1] = height;
            data[i][2] = bmi;
            status[i] = getStatus(bmi);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Weight: " + data[i][0] + ", Height: " + data[i][1] + ", BMI: " + data[i][2] + ", Status: " + status[i]);
        }
    }
}

