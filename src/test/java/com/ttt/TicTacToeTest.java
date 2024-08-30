package com.ttt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TicTacToe class
 *
 * @author gcsunn
 * @date 2024-08-26
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe = new TicTacToe();

    /**
     * Test constructor of class TicTacToe - Positive test cases
     */
    @Test
    public void testConstructor1() {
        // Positive test case
        Player player1 = new Player('x');
        Player player2 = new Player('o');
        Board board = new Board();
        char[][] ticTacToeBoardCells = ticTacToe.getBoard().getCells();
        char[][] newBoardCells = board.getCells();

        assertEquals(ticTacToe.getPlayer1().getMarker(), player1.getMarker());
        assertEquals(ticTacToe.getPlayer2().getMarker(), player2.getMarker());
        assertEquals(ticTacToe.getCurrentPlayer().getMarker(), player1.getMarker());

        for (int i = 0; i < newBoardCells.length; i++) {
            for (int j = 0; j < newBoardCells[0].length; j++) {
                assertEquals(ticTacToeBoardCells[i][j], newBoardCells[i][j]);
            }
        }
    }

    /**
     * Test constructor of class TicTacToe - Negative test cases
     */
    @Test
    public void testConstructor2() {
        Player player1 = new Player('x');
        Player player2 = new Player('o');
        Board board = new Board();
        char[][] ticTacToeBoardCells = ticTacToe.getBoard().getCells();

        assertEquals(ticTacToe.getPlayer1().getMarker(), player1.getMarker());
        assertEquals(ticTacToe.getPlayer2().getMarker(), player2.getMarker());
        assertEquals(ticTacToe.getCurrentPlayer().getMarker(), player1.getMarker());

        for (int i = 0; i < ticTacToeBoardCells.length; i++) {
            for (int j = 0; j < ticTacToeBoardCells[0].length; j++) {
                assertNotEquals(ticTacToeBoardCells[i][j], 'x');
            }
        }
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - Positive test cases
     */
    @Test
    public void testSwitchCurrentPlayer1() {
        assertEquals('x', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertEquals('o', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertEquals('x', ticTacToe.getCurrentPlayer().getMarker());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - Negative test cases
     */
    @Test
    public void testSwitchCurrentPlayer2() {
        assertNotEquals('o', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertNotEquals('x', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertNotEquals(' ', ticTacToe.getCurrentPlayer().getMarker());
    }

    /**
     * Test hasWinner method of class TicTacToe - Positive test cases
     */
    @Test
    public void testHasWinner1() {
        // Three pieces('x') at the same column
        ticTacToe.getBoard().place(0, 1, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(0, 0, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(1, 1, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(0, 2, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(2, 1, ticTacToe.getCurrentPlayer().getMarker());

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Test hasWinner method of class TicTacToe - Negative test cases
     */
    @Test
    public void testHasWinner2() {
        // A draw game
        ticTacToe.getBoard().place(1, 1, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(1, 0, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(0, 1, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(2, 1, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(1, 2, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(0, 2, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(2, 0, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(0, 0, ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        ticTacToe.getBoard().place(2, 2, ticTacToe.getCurrentPlayer().getMarker());

        assertFalse(ticTacToe.hasWinner());
    }

}