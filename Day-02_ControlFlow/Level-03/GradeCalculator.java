import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();

        double percentage = (physics + chemistry + maths) / 3.0;
        System.out.println("Average = " + percentage + "%");

        if (percentage >= 90)
            System.out.println("Grade: A+ (Excellent)");
        else if (percentage >= 80)
            System.out.println("Grade: A (Very Good)");
        else if (percentage >= 70)
            System.out.println("Grade: B (Good)");
        else if (percentage >= 60)
            System.out.println("Grade: C (Average)");
        else if (percentage >= 50)
            System.out.println("Grade: D (Pass)");
        else
            System.out.println("Grade: F (Fail)");
    }
}
