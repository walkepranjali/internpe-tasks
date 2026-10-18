
import java.util.Scanner;

public class Connect4Game {

    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = ' ';

    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';

    private final char[][] board = new char[ROWS][COLS];

    // Initialize the board
    public Connect4Game() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = EMPTY;
            }
        }
    }

    // Display the board
    public void printBoard() {
        System.out.println();

        for (int r = 0; r < ROWS; r++) {
            System.out.print("| ");

            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + " | ");
            }

            System.out.println();
        }

        System.out.println("-----------------------------");
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println();
    }

    // Drop a disc into the selected column
    public boolean dropDisc(int col, char player) {
        if (col < 0 || col >= COLS || board[0][col] != EMPTY) {
            return false;
        }

        for (int r = ROWS - 1; r >= 0; r--) {
            if (board[r][col] == EMPTY) {
                board[r][col] = player;
                return true;
            }
        }

        return false;
    }

    // Check for four connected discs
    public boolean checkWin(char player) {

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                // Horizontal
                if (c + 3 < COLS
                        && board[r][c] == player
                        && board[r][c + 1] == player
                        && board[r][c + 2] == player
                        && board[r][c + 3] == player) {
                    return true;
                }

                // Vertical
                if (r + 3 < ROWS
                        && board[r][c] == player
                        && board[r + 1][c] == player
                        && board[r + 2][c] == player
                        && board[r + 3][c] == player) {
                    return true;
                }

                // Diagonal: top-left to bottom-right
                if (r + 3 < ROWS && c + 3 < COLS
                        && board[r][c] == player
                        && board[r + 1][c + 1] == player
                        && board[r + 2][c + 2] == player
                        && board[r + 3][c + 3] == player) {
                    return true;
                }

                // Diagonal: bottom-left to top-right
                if (r - 3 >= 0 && c + 3 < COLS
                        && board[r][c] == player
                        && board[r - 1][c + 1] == player
                        && board[r - 2][c + 2] == player
                        && board[r - 3][c + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    // Check whether the board is full
    public boolean isFull() {
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == EMPTY) {
                return false;
            }
        }

        return true;
    }

    // Main game loop
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connect4Game game = new Connect4Game();

        char currentPlayer = PLAYER1;

        System.out.println("================================");
        System.out.println("     WELCOME TO CONNECT 4");
        System.out.println("================================");
        System.out.println("Player X and Player O take turns.");
        System.out.println("Connect four discs to win!");

        while (true) {

            game.printBoard();

            System.out.print("Player " + currentPlayer
                    + ", choose a column (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number from 1 to 7.");
                scanner.next();
                continue;
            }

            int column = scanner.nextInt() - 1;

            if (game.dropDisc(column, currentPlayer)) {

                if (game.checkWin(currentPlayer)) {
                    game.printBoard();
                    System.out.println("Congratulations! Player "
                            + currentPlayer + " wins!");
                    break;
                }

                if (game.isFull()) {
                    game.printBoard();
                    System.out.println("It's a tie!");
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER1)
                        ? PLAYER2 : PLAYER1;

            } else {
                System.out.println(
                        "Invalid move! Choose a column between 1 and 7 "
                        + "that is not full."
                );
            }
        }

        scanner.close();
    }
}
