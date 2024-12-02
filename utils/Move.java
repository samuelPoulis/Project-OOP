package utils;

import utils.Position;

/**
 * Represents a chess move from one position to another.
 */
public class Move {
    private Position from;
    private Position to;

    /**
     * Constructs a Move with the specified source and destination positions.
     *
     * @param from the source position
     * @param to   the destination position
     */
    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Gets the source position of the move.
     *
     * @return the source position
     */
    public Position getFrom() {
        return from;
    }

    /**
     * Gets the destination position of the move.
     *
     * @return the destination position
     */
    public Position getTo() {
        return to;
    }

    /**
     * Checks if this move is equal to another move.
     *
     * @param obj the object to compare
     * @return true if the moves are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Move move = (Move) obj;
        return from.equals(move.from) && to.equals(move.to);
    }

    /**
     * Generates a hash code for this move.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return 31 * from.hashCode() + to.hashCode();
    }

    /**
     * Returns a string representation of the move.
     *
     * @return the move as a string
     */
    @Override
    public String toString() {
        return "Move from " + from + " to " + to;
    }
}
