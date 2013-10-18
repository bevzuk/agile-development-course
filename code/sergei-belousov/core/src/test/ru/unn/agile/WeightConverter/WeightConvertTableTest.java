package ru.unn.agile.WeightConverter;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class WeightConvertTableTest {
    private final double epsilone = 1e-12;

    @Test
    public void emptyTableRealyEmpty() {
        WeightConvertTable weightConvertTable = new WeightConvertTable();
        assertTrue(weightConvertTable.isEmpty());
    }

    @Test
    public void notEmptyTableRealyNotEmpty() {
        WeightConvertTable weightConvertTable = new WeightConvertTable();
        weightConvertTable.addPair(new WeightKey("kg", "g"), 1000.);
        assertFalse(weightConvertTable.isEmpty());
    }

    @Test
    public void ifAddKeyThenCanGetKey() {
        WeightConvertTable weightConvertTable = new WeightConvertTable();
        weightConvertTable.addPair(new WeightKey("kg", "g"), 1000.);
        try {
            assertEquals(1000., weightConvertTable.getFactor(new WeightKey("kg", "g")), epsilone);
        } catch(WeightConvertTableException e){
            System.out.println("key not found.");
        }
    }

    @Test
    public void correctAutoAddReversePair() {
        WeightConvertTable weightConvertTable = new WeightConvertTable();
        weightConvertTable.addPair(new WeightKey("kg", "g"), 1000.);
        try {
            assertEquals(0.001, weightConvertTable.getFactor(new WeightKey("g", "kg")), epsilone);
        } catch(WeightConvertTableException e){
            System.out.println("key not found.");
        }
    }

    @Test
    public void correctExceptionForUnknownKey() {
        WeightConvertTable weightConvertTable = new WeightConvertTable();
        try {
            weightConvertTable.getFactor(new WeightKey("g", "kg"));
        } catch(WeightConvertTableException e) {
            assertTrue(e.getMessage().contains("key not found."));
        }
    }
}
