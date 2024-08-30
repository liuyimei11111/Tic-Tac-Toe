package com.ttt;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for class Board
 *
 * @author gcsunn
 * @date 2024-08-26
 */
public class BoardTest {

    private Board board = new Board();

    /**
     * Test constructor of class Board - Positive test cases
     */
    @Test
    public void testConstructor1() {
        char[][] expectedBoard = new char[3][3];
        for (int i = 0; i < expectedBoard.length; i++) {
            for (int j = 0; j < expectedBoard[0].length; j++) {
                expectedBoard[i][j] = ' ';
            }
        }

        assertArrayEquals(expectedBoard, board.getCells());
    }

    /**
     * Test constructor of class Board - Negative test cases
     */
    @Test
    public void testConstructor2() {
        char[][] notExpectedBoard = new char[3][3];
        for (int i = 0; i < notExpectedBoard.length; i++) {
            for (int j = 0; j < notExpectedBoard[0].length; j++) {
                notExpectedBoard[i][j] = ' ';
            }
        }
        notExpectedBoard[1][1] = 'x';
        notExpectedBoard[1][0] = 'o';

        assertNotEquals(notExpectedBoard, board.getCells());
    }

    /**
     * Test isCellOnBoard method of class Board - Positive test cases
     */
    @Test
    public void testIsCellOnBoard1() {
        assertTrue(board.isCellOnBoard(0, 2));
        assertTrue(board.isCellOnBoard(1, 1));
        assertTrue(board.isCellOnBoard(2, 0));
    }

    /**
     * Test isCellOnBoard method of class Board - Negative test cases
     */
    @Test
    public void testIsCellOnBoard2() {
        assertFalse(board.isCellOnBoard(-1, 2));
        assertFalse(board.isCellOnBoard(0, 3));
        assertFalse(board.isCellOnBoard(3, 5));
    }

    /**
     * Test isCellEmpty method of class Board - Positive test cases
     */
    @Test
    public void testIsCellEmpty1() {
        board.place(1, 1, 'x');
        board.place(1, 0, 'o');

        assertTrue(board.isCellEmpty(0, 2));
        assertTrue(board.isCellEmpty(1, 2));
        assertTrue(board.isCellEmpty(2, 0));
    }

    /**
     * Test isCellEmpty method of class Board - Negative test cases
     */
    @Test
    public void testIsCellEmpty2() {
        // Negative test cases
        board.place(2, 1, 'x');
        board.place(1, 1, 'o');
        board.place(1, 2, 'x');

        assertFalse(board.isCellEmpty(2, 1));
        assertFalse(board.isCellEmpty(1, 1));
        assertFalse(board.isCellEmpty(1, 2));
    }

    /**
     * Test place method of class Board - Positive test cases
     */
    @Test
    public void testPlace1() {
        board.place(1, 1, 'x');
        board.place(1, 0, 'o');

        char[][] cells = board.getCells();

        assertEquals('x', cells[1][1]);
        assertEquals('o', cells[1][0]);
        assertEquals(' ', cells[2][2]);
    }

    /**
     * Test place method of class Board - Negative test cases
     */
    @Test
    public void testPlace2() {
        board.place(1, 1, 'x');
        board.place(1, 0, 'o');

        char[][] cells = board.getCells();

        assertNotEquals('o', cells[1][1]);
        assertNotEquals('x', cells[1][0]);
        assertNotEquals('x', cells[2][0]);
        assertNotEquals('x', cells[2][1]);
    }

    /**
     * Test isBoardFull method of class Board - Positive test cases
     */
    @Test
    public void testIsBoardFull1() {
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                board.place(i, j, 'x');
            }
        }
        assertTrue(board.isBoardFull());
    }

    /**
     * Test isBoardFull method of class Board - Negative test cases
     */
    @Test
    public void testIsBoardFull2() {
        assertFalse(board.isBoardFull());
    }

    /**
     * Test print method of class Board - Positive test cases
     */
    @Test
    public void testPrint1() {
        // Positive test case
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        board.print();

        assertEquals("-------\n| | | |\n| | | |\n| | | |\n-------\n", output.toString());
        System.setOut(System.out);
    }

    /**
     * Test print method of class Board - Negative test cases
     */
    @Test
    public void testPrint2() {
        // Negative test case
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        board.place(0, 1, 'x');
        board.place(1, 2, 'o');
        board.place(0, 0, 'x');
        board.print();

        assertNotEquals("-------\n| |x| |\n| | |o|\n| | | |\n-------\n", output.toString());
        System.setOut(System.out);
    }
}
