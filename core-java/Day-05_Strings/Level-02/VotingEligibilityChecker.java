import java.util.Scanner;

public class VotingEligibilityChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        System.out.println("Student\tAge\tCan Vote");
        for (int i = 0; i < 10; i++) {
            boolean canVote = ages[i] >= 18;
            if (ages[i] < 0) canVote = false;
            System.out.println((i + 1) + "\t" + ages[i] + "\t" + (canVote ? "Yes" : "No"));
        }
    }
}
