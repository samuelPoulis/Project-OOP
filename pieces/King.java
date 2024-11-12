package pieces;

import utils.Position;

public class King extends Piece {

    /**
     * Constructs a King with the specified color and position.
     *
     * @param color    the color of the king ("white" or "black")
     * @param position the position of the king on the board
     */
    public King(String color, Position position) {
        super(color, position);
    }

    @Override
    public Position[] possibleMoves() {

        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wK" : "bK";
    }
}
