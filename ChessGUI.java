import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import board.Board;
import pieces.Piece;
import utils.Position;

/**
 * The main GUI class for the chess game.
 */
public class ChessGUI extends JFrame {
    private Board board;
    private JPanel boardPanel;
    private SquareButton[][] squares;
    private String currentPlayer;
    private SquareButton selectedSquare;

    /**
     * Constructs the Chess GUI.
     */
    public ChessGUI() {
        board = new Board();
        board.initialize();
        currentPlayer = "white";
        initializeGUI();
    }

    /**
     * Initializes the GUI components.
     */
    private void initializeGUI() {
        setTitle("Chess Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel = new JPanel(new GridLayout(8, 8));
        squares = new SquareButton[8][8];

        // Create squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                SquareButton button = new SquareButton(row, col);
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setPreferredSize(new Dimension(75, 75));
                button.setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                button.addActionListener(new SquareListener());
                button.addMouseListener(new DragListener());
                updateIcon(button);
                squares[row][col] = button;
                boardPanel.add(button);
            }
        }

        add(boardPanel);
        setVisible(true);
    }

    /**
     * Updates the icon of a square based on the piece present.
     *
     * @param button the square button to update
     */
    private void updateIcon(SquareButton button) {
        Piece piece = board.getPiece(new Position(button.row, button.col));
        if (piece != null) {
            String name = piece.getClass().getSimpleName();
            String color = piece.getColor();
            ImageIcon icon = new ImageIcon("images/" + color + name + ".png");
            Image img = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(img));
        } else {
            button.setIcon(null);
        }
    }

    /**
     * Listener for square button actions.
     */
    private class SquareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SquareButton button = (SquareButton) e.getSource();
            Position pos = new Position(button.row, button.col);
            Piece piece = board.getPiece(pos);

            if (selectedSquare == null) {
                // Select a piece to move
                if (piece != null && piece.getColor().equals(currentPlayer)) {
                    selectedSquare = button;
                    button.setBackground(Color.YELLOW);
                }
            } else {
                // Move the selected piece
                Position from = new Position(selectedSquare.row, selectedSquare.col);
                Position to = new Position(button.row, button.col);
                movePiece(from, to);
                selectedSquare
                        .setBackground((selectedSquare.row + selectedSquare.col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                selectedSquare = null;
            }
        }
    }

    /**
     * Listener for drag-and-drop functionality.
     */
    private class DragListener extends MouseAdapter {
        private Piece draggedPiece;
        private JLabel dragLabel;

        @Override
        public void mousePressed(MouseEvent e) {
            SquareButton button = (SquareButton) e.getSource();
            Position pos = new Position(button.row, button.col);
            Piece piece = board.getPiece(pos);

            if (piece != null && piece.getColor().equals(currentPlayer)) {
                draggedPiece = piece;
                ImageIcon icon = (ImageIcon) button.getIcon();
                dragLabel = new JLabel(icon);
                dragLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
                boardPanel.add(dragLabel);
                boardPanel.addMouseMotionListener(this);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (dragLabel != null) {
                dragLabel.setLocation(e.getX() - dragLabel.getWidth() / 2, e.getY() - dragLabel.getHeight() / 2);
                boardPanel.repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (dragLabel != null) {
                Component component = boardPanel.getComponentAt(e.getPoint());
                if (component instanceof SquareButton) {
                    SquareButton targetButton = (SquareButton) component;
                    Position from = new Position(draggedPiece.getPosition().getRow(),
                            draggedPiece.getPosition().getColumn());
                    Position to = new Position(targetButton.row, targetButton.col);
                    movePiece(from, to);
                }
                boardPanel.remove(dragLabel);
                boardPanel.repaint();
                draggedPiece = null;
                dragLabel = null;
                boardPanel.removeMouseMotionListener(this);
            }
        }
    }

    /**
     * Moves a piece from one position to another and updates the GUI.
     *
     * @param from the source position
     * @param to   the destination position
     */
    private void movePiece(Position from, Position to) {
        Piece piece = board.getPiece(from);
        Piece targetPiece = board.getPiece(to);

        if (piece != null) {
            if (targetPiece != null && targetPiece.getColor().equals(currentPlayer)) {
                // Can't capture own piece
                return;
            }

            board.movePiece(from, to);
            updateIcon(squares[from.getRow()][from.getColumn()]);
            updateIcon(squares[to.getRow()][to.getColumn()]);

            // Check if the king is captured
            if (targetPiece != null && targetPiece instanceof pieces.King) {
                JOptionPane.showMessageDialog(this, currentPlayer + " wins!");
                System.exit(0);
            }

            // Switch player
            currentPlayer = currentPlayer.equals("white") ? "black" : "white";
        }
    }
}