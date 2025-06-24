import java.util.Scanner;

public class StudentMarksScorecard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] marks = new int[5][3]; // 5 students, 3 subjects

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                marks[i][j] = 50 + (int)(Math.random() * 51); // 2-digit random marks (50–100)
            }
        }

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t% \tGrade");
        for (int i = 0; i < 5; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            String grade;

            if (percent >= 90) grade = "A+";
            else if (percent >= 80) grade = "A";
            else if (percent >= 70) grade = "B";
            else if (percent >= 60) grade = "C";
            else if (percent >= 50) grade = "D";
            else grade = "F";

            System.out.printf("%d\t%d\t%d\t%d\t%d\t%.2f\t%.2f\t%s\n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], total, avg, percent, grade);
        }
    }
}
