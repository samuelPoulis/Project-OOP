package game;

import board.Board;
import utils.Position;

import java.util.Scanner;

/**
 * Controls the flow of the chess game.
 */
public class Game {
    private Board board;
    private String currentPlayer; // "white" or "black"

    // Start a new game:
    public void start() {
        board = new Board();
        board.initialize();
        currentPlayer = "white";
        play();
    }

    // Game loop
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.display();
            System.out.println(currentPlayer + "'s turn.");
            System.out.print("Enter your move (e.g., E2 E4): ");
            String input = scanner.nextLine().toUpperCase().trim();

            // Basic input validation
            if (input.matches("^[A-H][1-8]\\s[A-H][1-8]$")) {
                // Parse positions
                Position from = parsePosition(input.substring(0, 2));
                Position to = parsePosition(input.substring(3, 5));

                // Validate positions
                if (!board.isValidPosition(from) || !board.isValidPosition(to)) {
                    System.out.println("Invalid position. Try again.");
                    continue;
                }

                // Get the piece at the source position
                if (board.getPiece(from) == null) {
                    System.out.println("No piece at the source position. Try again.");
                    continue;
                }

                // Check if it is the player's own piece
                if (!board.getPiece(from).getColor().equals(currentPlayer)) {
                    System.out.println("You can only move your own pieces. Try again.");
                    continue;
                }

                // Move piece
                board.movePiece(from, to);

                // Switch player
                currentPlayer = currentPlayer.equals("white") ? "black" : "white";
            } else {
                System.out.println("Invalid move format. Please use the format 'E2 E4'.");
            }
            scanner.close();
        }

    }

    /**
     * Parses a string into a Position object.
     *
     * @param pos the position string (e.g., "E2")
     * @return the Position object
     */
    private Position parsePosition(String pos) {
        int column = pos.charAt(0) - 'A';
        int row = 8 - Character.getNumericValue(pos.charAt(1));
        return new Position(row, column);
    }
}
