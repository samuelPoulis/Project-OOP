package pieces;

import board.Board;
import utils.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a King chess piece.
 */
public class King extends Piece {

    public King(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getColumn();

        int[] rowOffsets = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colOffsets = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < rowOffsets.length; i++) {
            int r = row + rowOffsets[i];
            int c = col + colOffsets[i];
            Position pos = new Position(r, c);
            if (board.isValidPosition(pos)) {
                Piece piece = board.getPiece(pos);
                if (piece == null || !piece.getColor().equals(color)) {
                    moves.add(pos); // Empty or can capture
                }
            }
        }

        // Note: Castling is an advanced rule not included here

        return moves;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wK" : "bK";
    }
}
