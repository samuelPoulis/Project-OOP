import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Launch the Chess GUI
        SwingUtilities.invokeLater(() -> new ChessGUI());
    }
}
