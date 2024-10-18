package board;

import pieces.*;
import utils.Position;

/**
 * Represents the chessboard.
 */
public class Board {
    private Piece[][] squares = new Piece[8][8];

    /**
     * Initializes the board with pieces in their starting positions.
     */
    public void initialize() {
        // Initialize all squares to null
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = null;
            }
        }

        // Place black pieces
        squares[0][0] = new Rook("black", new Position(0, 0));
        squares[0][1] = new Knight("black", new Position(0, 1));
        squares[0][2] = new Bishop("black", new Position(0, 2));
        squares[0][3] = new Queen("black", new Position(0, 3));
        squares[0][4] = new King("black", new Position(0, 4));
        squares[0][5] = new Bishop("black", new Position(0, 5));
        squares[0][6] = new Knight("black", new Position(0, 6));
        squares[0][7] = new Rook("black", new Position(0, 7));

        for (int col = 0; col < 8; col++) {
            squares[1][col] = new Pawn("black", new Position(1, col));
        }

        // Place white pieces
        squares[7][0] = new Rook("white", new Position(7, 0));
        squares[7][1] = new Knight("white", new Position(7, 1));
        squares[7][2] = new Bishop("white", new Position(7, 2));
        squares[7][3] = new Queen("white", new Position(7, 3));
        squares[7][4] = new King("white", new Position(7, 4));
        squares[7][5] = new Bishop("white", new Position(7, 5));
        squares[7][6] = new Knight("white", new Position(7, 6));
        squares[7][7] = new Rook("white", new Position(7, 7));

        for (int col = 0; col < 8; col++) {
            squares[6][col] = new Pawn("white", new Position(6, col));
        }
    }

    /**
     * Gets the piece at the specified position.
     *
     * @param position the position on the board
     * @return the piece at the position, or null if empty
     */
    public Piece getPiece(Position position) {
        return squares[position.getRow()][position.getColumn()];
    }

    /**
     * Moves a piece from one position to another.
     *
     * @param from the source position
     * @param to   the destination position
     */
    public void movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if (piece != null) {
            squares[to.getRow()][to.getColumn()] = piece;
            squares[from.getRow()][from.getColumn()] = null;
            piece.move(to);
        }
    }

    /**
     * Displays the board in the console.
     */
    public void display() {
        System.out.println("    A  B  C  D  E  F  G  H");
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + "  ");
            for (int col = 0; col < 8; col++) {
                Piece piece = squares[row][col];
                if (piece != null) {
                    System.out.print(piece.toString() + " ");
                } else {
                    System.out.print("## ");
                }
            }
            System.out.println(" " + (8 - row));
        }
        System.out.println("    A  B  C  D  E  F  G  H");
    }

    /**
     * Checks if a position is within the bounds of the board.
     *
     * @param position the position to check
     * @return true if within bounds, false otherwise
     */
    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getColumn();
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
