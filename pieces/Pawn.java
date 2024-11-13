package pieces;

import board.Board;
import utils.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Pawn chess piece.
 */
public class Pawn extends Piece {

    public Pawn(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int direction = color.equals("white") ? -1 : 1; // White moves up, black moves down

        int row = position.getRow();
        int col = position.getColumn();

        // Single step forward
        Position oneStepForward = new Position(row + direction, col);
        if (board.isValidPosition(oneStepForward) && board.getPiece(oneStepForward) == null) {
            moves.add(oneStepForward);

            // Double step forward from starting position
            if ((color.equals("white") && row == 6) || (color.equals("black") && row == 1)) {
                Position twoStepsForward = new Position(row + 2 * direction, col);
                if (board.isValidPosition(twoStepsForward) && board.getPiece(twoStepsForward) == null) {
                    moves.add(twoStepsForward);
                }
            }
        }

        // Captures
        int[] captureCols = { col - 1, col + 1 };
        for (int c : captureCols) {
            Position capturePos = new Position(row + direction, c);
            if (board.isValidPosition(capturePos)) {
                Piece targetPiece = board.getPiece(capturePos);
                if (targetPiece != null && !targetPiece.getColor().equals(color)) {
                    moves.add(capturePos);
                }
            }
        }

        // Note: En Passant and Promotion are advanced rules not included here

        return moves;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "wp" : "bp";
    }
}
