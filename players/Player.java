package players;

import java.util.ArrayList;
import pieces.Piece;

/**
 * Represents a player in the game.
 */
public class Player {
    private String color; // either white or black 
    private ArrayList<Piece> activePieces;

    /**
     * Constructs a Player with the specified color.
     *
     * @param color the color of the player ("white" or "black")
     */
    public Player(String color) {
        this.color = color;
        this.activePieces = new ArrayList<>();
    }

    /**
     * Adds a piece to the player's active pieces.
     *
     * @param piece the piece to add
     */
    public void addPiece(Piece piece) {
        activePieces.add(piece);
    }

    /**
     * Removes a piece from the player's active pieces.
     *
     * @param piece the piece to remove
     */
    public void removePiece(Piece piece) {
        activePieces.remove(piece);
    }

    // Getters

    public String getColor() {
        return color;
    }

    public ArrayList<Piece> getActivePieces() {
        return activePieces;
    }
}
