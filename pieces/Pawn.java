package pieces;

import utils.Position;

/**
 * Represents a Pawn chess piece.
 */
public class Pawn extends Piece {

    /**
     * Constructs a Pawn with the specified color and position.
     *
     * @param color    the color of the pawn ("white" or "black")
     * @param position the position of the pawn on the board
     */
    public Pawn(String color, Position position) {
        super(color, position);
    }

    @Override
    public Position[] possibleMoves() {
        // Basic pawn movement logic (not fully implemented)
        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wp" : "bp";
    }
}
