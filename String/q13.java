import java.util.Scanner;

public class Q13_RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[(int)(Math.random() * 3)];
    }

    public static String getWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        if (player.equals("rock") && computer.equals("scissors") ||
            player.equals("scissors") && computer.equals("paper") ||
            player.equals("paper") && computer.equals("rock"))
            return "Player";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds;
        int playerWins = 0, compWins = 0;
        System.out.print("Enter number of games: ");
        rounds = sc.nextInt();

        for (int i = 1; i <= rounds; i++) {
            System.out.print("Round " + i + " - Enter your move (rock/paper/scissors): ");
            String player = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = getWinner(player, comp);
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) compWins++;
            System.out.println("Computer chose: " + comp + " | Winner: " + winner);
        }

        double pWinPct = (playerWins * 100.0) / rounds;
        double cWinPct = (compWins * 100.0) / rounds;

        System.out.printf("\n%-10s %-10s %-15s\n", "Player", "Computer", "Draw");
        System.out.printf("%-10d %-10d %-15d\n", playerWins, compWins, (rounds - playerWins - compWins));
        System.out.printf("Player Win %%: %.2f%% | Computer Win %%: %.2f%%\n", pWinPct, cWinPct);
    }
}
