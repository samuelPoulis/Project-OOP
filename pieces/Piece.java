package pieces;

import utils.Position;

/**
 * Abstract class representing a chess piece.
 */
public abstract class Piece {
    protected String color; // "white" or "black"
    protected Position position;

    /**
     * Constructs a Piece with the specified color and position.
     *
     * @param color    the color of the piece ("white" or "black")
     * @param position the position of the piece on the board
     */
    public Piece(String color, Position position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Calculates possible moves for the piece.
     *
     * @return an array of possible positions
     */
    public abstract Position[] possibleMoves();

    /**
     * Moves the piece to a new position.
     *
     * @param newPosition the new position to move to
     */
    public void move(Position newPosition) {
        this.position = newPosition;
    }

    // Getters

    public String getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    /**
     * Returns the string representation of the piece.
     *
     * @return a two-character string representing the piece
     */
    public abstract String toString();
}
