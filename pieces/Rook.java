package pieces;

import utils.Position;

/**
 * Represents a Rook chess piece.
 */
public class Rook extends Piece {

    /**
     * Constructs a Rook with the specified color and position.
     *
     * @param color    the color of the rook ("white" or "black")
     * @param position the position of the rook on the board
     */
    public Rook(String color, Position position) {
        super(color, position);
    }

    @Override
    public Position[] possibleMoves() {
        // Basic rook movement logic (not fully implemented)
        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wR" : "bR";
    }
}
