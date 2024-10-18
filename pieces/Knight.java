package pieces;

import utils.Position;

/**
 * Represents a Knight chess piece.
 */
public class Knight extends Piece {

    /**
     * Constructs a Knight with the specified color and position.
     *
     * @param color    the color of the knight ("white" or "black")
     * @param position the position of the knight on the board
     */
    public Knight(String color, Position position) {
        super(color, position);
    }

    @Override
    public Position[] possibleMoves() {
        // Basic knight movement logic (not fully implemented)
        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wN" : "bN";
    }
}
