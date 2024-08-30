package com.ttt;

import java.util.Scanner;

/**
 * TicTacToe class of TicTacToe, which is an entity & driver class to describe the scenario of the game
 * It includes an entry for users to play the game
 *
 * @author Liu010517
 * @date 2024-08-24
 */
public class TicTacToe {

    private static Player player1;  // Player 1
    private static Player player2;  // Player 2
    private static Player currentPlayer;  // Current player (Player 1 or player 2)
    private static Board board;  // Current board
    private static final Scanner in = new Scanner(System.in);  // Scanner for inputting data

    /**
     * Default constructor
     */
    public TicTacToe() {
        // Here, we suppose the piece of player1 and player2 is 'x' and 'o' respectively
        player1 = new Player('x');
        player2 = new Player('o');
        currentPlayer = player1;
        board = new Board();
    }

    /**
     * Getter for player 1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Getter for player 2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Getter for current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter for current board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Start the game
     */
    public static void start() {
        // Before the winner of game is determined, the process of game is continuing
        while (true) {
            // Get marker of current player
            char currentPlayerMarker = currentPlayer.getMarker();
            // Two players place their piece alternatively
            while (true) {
                System.out.println("Current Player: " + currentPlayerMarker);
                board.print();
                try {
                    System.out.print("row (0-" + (board.getCells().length - 1) + "): ");
                    int row = Integer.parseInt(in.nextLine());
                    System.out.print("col (0-" + (board.getCells()[0].length - 1) + "): ");
                    int col = Integer.parseInt(in.nextLine());
                    if (!board.isCellOnBoard(row, col)) {
                        System.out.println("Input position if not on board, place the piece failed!");
                    } else if (!board.isCellEmpty(row, col)) {
                        System.out.println("There is a piece on the input position, place the piece failed!");
                    } else {
                        board.place(row, col, currentPlayerMarker);
                        System.out.println("Place a piece " + currentPlayerMarker + " on the position (" + row + ", " + col + ") successfully!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please try again!");
                }
            }
            // After current player places a piece, the application should check whether the winner is determined automatically
            if (hasWinner()) {  // Player1 or player2 is the winner
                board.print();
                if (currentPlayer == player1) {
                    System.out.println("Player 1 (" + currentPlayerMarker + ") is the winner!");
                } else {
                    System.out.println("Player 2 (" + currentPlayerMarker + ") is the winner");
                }
                break;
            } else if (board.isBoardFull()) {  // Draw game
                board.print();
                System.out.println("The board is full without winner, this is a draw game!");
                break;
            } else {  // Otherwise, switch current player
                switchCurrentPlayer();
            }
        }
    }

    /**
     * Switch current player
     */
    protected static void switchCurrentPlayer() {
        // Player1 -> Player2, or Player2 -> Player1
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Check whether the winner of game is determined
     * If the winner of game is determined, then there are three same pieces at a row / a column / main diagonal / sub diagonal
     * Attention: The permission modifier of the method should be protected, instead of private
     */
    protected static boolean hasWinner() {
        // Get cells of current board
        char[][] cells = board.getCells();
        char target = currentPlayer.getMarker();
        boolean found;

        // 1. Check whether there are three same pieces at a row
        for (int i = 0; i < cells.length; i++) {
            found = true;
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] != target) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }

        // 2. Check whether there are three same pieces at a row
        for (int j = 0; j < cells.length; j++) {
            found = true;
            for (int i = 0; i < cells[0].length; i++) {
                if (cells[i][j] != target) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }

        // 3. Check whether there are three same pieces at main diagonal
        found = true;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][i] != target) {
                found = false;
                break;
            }
        }
        if (found) {
            return true;
        }

        // 4. Check whether there are three same pieces at sub diagonal
        found = true;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][cells.length - 1 - i] != target) {
                found = false;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        while (true) {
            // Start a new game
            System.out.println("********** TicTacToe game **********");
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.start();

            // User can select continue playing the game
            boolean isExit = false;
            while (true) {
                System.out.print("Start a new game [Y or N]? ");
                String choice = in.nextLine();
                if (choice.equals("N")) {
                    System.out.println("You have exited the TicTacToe game, bye!");
                    isExit = true;
                    break;
                } else if (choice.equals("Y")) {
                    System.out.println("Continue playing the game!\n");
                    break;
                } else {
                    System.out.println("Invalid choice, please try again!");
                }
            }

            if (isExit) {
                break;
            }
        }
    }
}
