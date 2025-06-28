import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int candidate1 = 0, candidate2 = 0, candidate3 = 0;

        while (true) {
            System.out.print("Enter your age (or enter -1 to stop voting): ");
            int age = sc.nextInt();

            if (age == -1) {
                break;
            }

            if (age >= 18) {
                System.out.print("Vote for your candidate (1, 2, or 3): ");
                int vote = sc.nextInt();

                if (vote == 1) {
                    candidate1++;
                } else if (vote == 2) {
                    candidate2++;
                } else if (vote == 3) {
                    candidate3++;
                } else {
                    System.out.println("Invalid vote! Vote must be 1, 2, or 3.");
                }
            } else {
                System.out.println("Not eligible to vote.");
            }

            System.out.println("------");
        }

        System.out.println("Voting session ended.");
        System.out.println("Results:");
        System.out.println("Candidate 1: " + candidate1 + " votes");
        System.out.println("Candidate 2: " + candidate2 + " votes");
        System.out.println("Candidate 3: " + candidate3 + " votes");

        sc.close();
    }
}
