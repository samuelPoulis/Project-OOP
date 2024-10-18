
package utils;

/**
 * Represents a position on the chessboard.
 */
public class Position {
    private int row; // 0 to 7 for rows 8 to 1
    private int column; // 0 to 7 for columns A to H

    /**
     * Constructs a Position with the specified row and column.
     *
     * @param row    the row index (0-7)
     * @param column the column index (0-7)
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getters

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    // Override equals and hashCode for proper comparison

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Position position = (Position) obj;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return 31 * row + column;
    }
}
