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

    /**
     * Checks if this position is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the positions are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Position position = (Position) obj;
        return row == position.row && column == position.column;
    }

    /**
     * Generates a hash code for this position.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return 31 * row + column;
    }

    /**
     * Returns a string representation of the position.
     *
     * @return the position as a string
     */
    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
