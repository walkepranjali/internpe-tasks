
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = { "Rock", "Paper", "Scissors" };
        boolean playAgain = true;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (playAgain) {
            System.out.print("Enter your choice (Rock, Paper, Scissors): ");
            String playerChoice = scanner.nextLine().trim();

            if (!playerChoice.equalsIgnoreCase("Rock") &&
                    !playerChoice.equalsIgnoreCase("Paper") &&
                    !playerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];
            System.out.println("Computer chose: " + computerChoice);

            if (playerChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                    (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                    (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
