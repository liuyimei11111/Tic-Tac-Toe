package com.ttt;

/**
 * Board class, which is an entity class to describe an interface for players to play the game
 *
 * @author liuyimei11111
 * @date 2024-08-21
 */
public class Board {

    private char[][] cells;  // Cells of board

    /**
     * Default constructor
     */
    public Board() {
        // Create the cells of board, which is a two-dimentional array with 3 rows and 3 columns
        // In the game, ' ' represents blank, 'x' represents player1's piece, 'o' represents player2's piece
        this.cells = new char[3][3];

        // Set piece of every position is empty
        this.clear();
    }

    /**
     * Get cells of current board
     */
    public char[][] getCells() {
        return cells;
    }

    /**
     * Check whether position (x, y) the player will set piece is in the range of board
     */
    public boolean isCellOnBoard(int x, int y) {
        return x >= 0 && x < cells.length && y >= 0 && y < cells[0].length;
    }

    /**
     * Check whether player's input position (x, y) of cell is empty
     */
    public boolean isCellEmpty(int x, int y) {
        return isCellOnBoard(x, y) && cells[x][y] == ' ';
    }

    /**
     * Check whether the board is full (If and only if every cell of the board is not ' ')
     */
    public boolean isBoardFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Place an piece at position (x, y) for current player
     */
    public void place(int x, int y, char marker) {
        // If there is a piece('x' or 'o') in the position (x, y), then the piece cannot be placed
        if (!isCellEmpty(x, y)) {
            return;
        }
        // Otherwise, the piece of current player can be placed
        cells[x][y] = marker;
    }

    /**
     * Clear the board
     */
    public void clear() {
        // Set all pieces on the board is ' '
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /**
     * Print the board with specific format
     */
    public void print() {
        for (int i = 0; i < cells.length; i++) {
            // Print top border of the board
            if (i == 0) {
                System.out.print("-");
                for (int j = 0; j < cells[0].length; j++) {
                    System.out.print("--");
                }
                System.out.print("\n");
            }
            // Print every cell in the board
            System.out.print("|");
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j] + "|");
            }
            System.out.print("\n");
        }
        // Print bottom border of the board
        System.out.print("-");
        for (int i = 0; i < cells.length; i++) {
            System.out.print("--");
        }
        System.out.print("\n");
    }
}
