import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors"};
        int playerWins = 0, compWins = 0;

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        System.out.println("Game\tPlayer\tComputer\tResult");
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String player = sc.next().toLowerCase();
            String computer = options[(int)(Math.random() * 3)];
            String result;

            if (player.equals(computer)) result = "Draw";
            else if ((player.equals("rock") && computer.equals("scissors")) ||
                    (player.equals("paper") && computer.equals("rock")) ||
                    (player.equals("scissors") && computer.equals("paper"))) {
                result = "Player Wins";
                playerWins++;
            } else {
                result = "Computer Wins";
                compWins++;
            }

            System.out.println(i + "\t" + player + "\t" + computer + "\t\t" + result);
        }

        System.out.println("\nTotal Games: " + n);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + compWins);

        double playerPct = (playerWins * 100.0) / n;
        double compPct = (compWins * 100.0) / n;

        System.out.printf("Player Win %%: %.2f%%\n", playerPct);
        System.out.printf("Computer Win %%: %.2f%%\n", compPct);
    }
}
