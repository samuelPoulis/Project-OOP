package pieces;

import utils.Position;

public class Queen extends Piece {

    /**
     * Constructs a Queen with the specified color and position.
     *
     * @param color    the color of the queen ("white" or "black")
     * @param position the position of the queen on the board
     */
    public Queen(String color, Position position) {
        super(color, position);
    }

    @Override
    public Position[] possibleMoves() {

        return new Position[0];
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wQ" : "bQ";
    }
}
