package ru.unn.agile.WeightConverter;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class WeightKeyTest {

    @Test
    public void equalTwoEqualKeys() {
        WeightKey weightKey1 = new WeightKey("kg", "g");
        WeightKey weightKey2 = new WeightKey("kg", "g");
        assertEquals(weightKey1, weightKey2);
    }

    @Test
    public void noEqualTwoDifferentKeys() {
        WeightKey weightKey1 = new WeightKey("g", "g");
        WeightKey weightKey2 = new WeightKey("kg", "g");
        assertFalse(weightKey1.equals(weightKey2));
    }

    @Test
    public void equalsHashCodeTwoEqualKeys() {
        WeightKey weightKey1 = new WeightKey("kg", "g");
        WeightKey weightKey2 = new WeightKey("kg", "g");
        assertEquals(weightKey1.hashCode(), weightKey2.hashCode());
    }

    @Test
    public void noEqualsHashCodeTwoDifferentKeys() {
        WeightKey weightKey1 = new WeightKey("g", "g");
        WeightKey weightKey2 = new WeightKey("kg", "g");
        assertFalse(weightKey1.hashCode() == weightKey2.hashCode());
    }

    @Test
    public void keyReverseEqualReverseKey() {
        WeightKey weightKey = new WeightKey("kg", "g");
        assertEquals(weightKey.reverse(), new WeightKey("g", "kg"));
    }

    @Test
    public void keyToStringEqualStringFromHyphenToString() {
        WeightKey weightKey = new WeightKey("kg", "g");
        assertEquals("kg-g", weightKey.toString());
    }

}
