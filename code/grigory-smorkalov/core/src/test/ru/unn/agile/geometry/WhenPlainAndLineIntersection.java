package ru.unn.agile.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WhenPlainAndLineIntersection {
    @Test
    public void nullPlainPassed() {
        Plain plain = null;
        Line line = new Line();
        IntersectionComputer intersectionComputer = new IntersectionComputer();
        try
        {
            intersectionComputer.compute(plain, line);
            fail("Exception expected");
        } catch (RuntimeException e) {
            assertEquals("Null plain passed", e.getMessage());
        }
        catch (Exception e) {
            fail("Unexpected exception: " + e.toString());
        }
    }
}
