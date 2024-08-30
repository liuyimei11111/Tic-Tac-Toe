package com.ttt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Player class
 *
 * @author gcsunn
 * @date 2024-08-26
 */
public class PlayerTest {

    private Player player = new Player('o');

    /**
     * Test constructor and getMarker method of class Player - Positive test cases
     */
    @Test
    public void testConstructor1() {
        // Positive test case
        assertEquals('o', player.getMarker());
    }

    /**
     * Test constructor and getMarker method of class Player - Negative test cases
     */
    @Test
    public void testConstructor2() {
        // Negative test case
        assertNotEquals('x', player.getMarker());
    }
}
