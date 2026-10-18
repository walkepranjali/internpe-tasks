
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int row, col;
        boolean gameWon = false;

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard();

        while (!gameWon && !isBoardFull()) {

            System.out.print("Player " + currentPlayer
                    + ", enter row (1-3) and column (1-3): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter numbers only.");
                scanner.next();
                continue;
            }

            row = scanner.nextInt() - 1;

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter numbers only.");
                scanner.next();
                continue;
            }

            col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {

                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else {
                    // Switch players
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    // Display the game board
    private static void printBoard() {

        System.out.println("\n  1   2   3");

        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);

                if (j < 2) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println(" ---+---+---");
            }
        }

        System.out.println();
    }

    // Check whether a move is valid
    private static boolean isValidMove(int row, int col) {

        return row >= 0 && row < 3
                && col >= 0 && col < 3
                && board[row][col] == ' ';
    }

    // Check rows, columns, and diagonals for a winner
    private static boolean checkWin() {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == currentPlayer
                    && board[i][1] == currentPlayer
                    && board[i][2] == currentPlayer) {
                return true;
            }

            if (board[0][i] == currentPlayer
                    && board[1][i] == currentPlayer
                    && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == currentPlayer
                    && board[1][1] == currentPlayer
                    && board[2][2] == currentPlayer)
                || (board[0][2] == currentPlayer
                    && board[1][1] == currentPlayer
                    && board[2][0] == currentPlayer);
    }

    // Check whether all cells are occupied
    private static boolean isBoardFull() {

        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
