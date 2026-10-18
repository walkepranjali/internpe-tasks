import java.util.Random;
import java.util.Scanner;

public class Guess_a_number_game {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;

        int targetNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between "
                + min + " and " + max + ".");
        System.out.println("Can you guess what it is?");

        while (!hasGuessedCorrectly) {

            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            int playerGuess = scanner.nextInt();

            if (playerGuess < min || playerGuess > max) {
                System.out.println("Please enter a number between "
                        + min + " and " + max + ".");
                continue;
            }

            attempts++;

            if (playerGuess < targetNumber) {
                System.out.println("Too low! Try again.");

            } else if (playerGuess > targetNumber) {
                System.out.println("Too high! Try again.");

            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed "
                        + "the number in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}