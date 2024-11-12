package pieces;

import utils.Position;

public abstract class Piece {
    protected String color;
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
     * Gets the color of the piece.
     *
     * @return the color ("white" or "black")
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the position of the piece.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Moves the piece to a new position.
     *
     * @param newPosition the new position
     */
    public void move(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Abstract method to get possible moves.
     *
     * @return an array of possible positions
     */
    public abstract Position[] possibleMoves();

    @Override
    public abstract String toString();
}
