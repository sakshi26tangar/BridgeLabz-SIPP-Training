import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] phy = new int[n];
        int[] chem = new int[n];
        int[] math = new int[n];
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Physics, Chemistry, Maths marks for student " + (i + 1) + ": ");
            int p = sc.nextInt(), c = sc.nextInt(), m = sc.nextInt();
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Try again.");
                i--;
                continue;
            }
            phy[i] = p; chem[i] = c; math[i] = m;
            percent[i] = (p + c + m) / 3.0;

            if (percent[i] >= 90) grade[i] = 'A';
            else if (percent[i] >= 80) grade[i] = 'B';
            else if (percent[i] >= 70) grade[i] = 'C';
            else if (percent[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": % = " + percent[i] + ", Grade = " + grade[i]);
        }
    }
}
