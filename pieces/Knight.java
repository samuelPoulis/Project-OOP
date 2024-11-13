package pieces;

import board.Board;
import utils.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Knight chess piece.
 */
public class Knight extends Piece {

    public Knight(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getColumn();

        int[][] moveOffsets = {
                { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 },
                { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 }
        };

        for (int[] offset : moveOffsets) {
            int r = row + offset[0];
            int c = col + offset[1];
            Position pos = new Position(r, c);
            if (board.isValidPosition(pos)) {
                Piece piece = board.getPiece(pos);
                if (piece == null || !piece.getColor().equals(color)) {
                    moves.add(pos); // Empty or can capture
                }
            }
        }

        return moves;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wN" : "bN";
    }
}
