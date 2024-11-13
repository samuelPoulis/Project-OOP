package pieces;

import board.Board;
import utils.Position;
import java.util.List;

public abstract class Piece {
    protected String color; // "white" or "black"
    protected Position position;

    public Piece(String color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void move(Position newPosition) {
        position = newPosition;
    }

    // Updated method signature
    public abstract List<Position> possibleMoves(Board board);
}
