package pieces;

import utils.Position;

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

        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wR" : "bR";
    }
}
