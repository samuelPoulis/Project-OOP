import javax.swing.JButton;

/**
 * Represents a square on the chessboard.
 */
public class SquareButton extends JButton {
    public int row;
    public int col;

    /**
     * Constructs a SquareButton with specified row and column.
     *
     * @param row the row index
     * @param col the column index
     */
    public SquareButton(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
