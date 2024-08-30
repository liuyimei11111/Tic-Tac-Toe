package com.ttt;

/**
 * Player class, which is an entity class to describe a player in the game
 *
 * @author gcsunn
 * @date 2024-08-22
 */
public class Player {

    private char marker;  // Marker of player (either 'x' or 'o')

    /**
     * Default Constructor
     */
    public Player(char marker) {
        this.marker = marker;
    }

    /**
     * Get marker of current player
     */
    public char getMarker() {
        return marker;
    }
}
