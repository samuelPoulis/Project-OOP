package pieces;

import board.Board;
import utils.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Bishop chess piece.
 */
public class Bishop extends Piece {

    public Bishop(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getColumn();

        // Directions: diagonals
        int[] rowDirections = { -1, -1, 1, 1 };
        int[] colDirections = { -1, 1, -1, 1 };

        for (int i = 0; i < rowDirections.length; i++) {
            int r = row + rowDirections[i];
            int c = col + colDirections[i];

            while (board.isValidPosition(new Position(r, c))) {
                Position pos = new Position(r, c);
                Piece piece = board.getPiece(pos);
                if (piece == null) {
                    moves.add(pos);
                } else {
                    if (!piece.getColor().equals(color)) {
                        moves.add(pos); // Can capture
                    }
                    break; // Blocked by any piece
                }
                r += rowDirections[i];
                c += colDirections[i];
            }
        }

        return moves;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wB" : "bB";
    }
}
