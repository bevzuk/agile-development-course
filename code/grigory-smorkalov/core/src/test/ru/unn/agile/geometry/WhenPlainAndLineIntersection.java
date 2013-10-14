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
        try {
            intersectionComputer.compute(plain, line);
            fail("Exception expected");
        } catch (RuntimeException e) {
            assertEquals("Null plain passed", e.getMessage());
        }
        catch (Exception e) {
            fail("Unexpected exception: " + e.toString());
        }
    }

    @Test
    public void nullLinePassed() {
        Plain plain = new Plain();
        Line line = null;
        IntersectionComputer intersectionComputer = new IntersectionComputer();
        try {
            intersectionComputer.compute(plain, line);
            fail("Exception expected");
        } catch (RuntimeException e) {
            assertEquals("Null line passed", e.getMessage());
        }
        catch (Exception e) {
            fail("Unexpected exception: " + e.toString());
        }
    }

    @Test
    public void nullArgsPassed() {
        Plain plain = null;
        Line line = null;
        IntersectionComputer intersectionComputer = new IntersectionComputer();
        try {
            intersectionComputer.compute(plain, line);
            fail("Exception expected");
        } catch (RuntimeException e) {
            assertEquals("Null plain and line passed", e.getMessage());
        }
        catch (Exception e) {
            fail("Unexpected exception: " + e.toString());
        }
    }
}
