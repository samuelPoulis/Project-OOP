package pieces;

import utils.Position;

/**
 * Represents a Bishop chess piece.
 */
public class Bishop extends Piece {

    /**
     * Constructs a Bishop with the specified color and position.
     *
     * @param color    the color of the bishop ("white" or "black")
     * @param position the position of the bishop on the board
     */
    public Bishop(String color, Position position) {
        super(color, position);
    }

    @Override
    public Position[] possibleMoves() {
        // Basic bishop movement logic (not fully implemented)
        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wB" : "bB";
    }
}
