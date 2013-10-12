package ru.unn.agile.leftistHeap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class WhenUsePair {
    private Pair pair;

    @Before
    public void setUp(){
        pair = new Pair();
    }

    @Test
    public void correctlyCreatedPair() {
        pair = new Pair(1, "Hello");
        assertArrayEquals(new Object[] {pair.getKey(), pair.getValue()}, new Object[] {1, "Hello"});
    }

    @Test
    public void incorrectKeyInPair() {
        try {
            pair = new Pair(-1, "Bad");
            fail("IllegalArgumentException should be thrown");
        }
        catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void incorrectValueInPair() {
        try {
            pair = new Pair(1, null);
            fail("IllegalArgumentException should be thrown");
        }
        catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void incorrectPair() {
        try {
            pair = new Pair(-1, null);
            fail("IllegalArgumentException should be thrown");
        }
        catch (IllegalArgumentException ex) {
        }
    }
}
