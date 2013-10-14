package ru.unn.agile.geometry;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WhenPlainAndLineIntersection {
    IntersectionComputer intersectionComputer;

    @Before
    public void setUp()
    {
        intersectionComputer = new IntersectionComputer();
    }

    @Test
    public void nullPlainPassed() {
        Plain plain = null;
        Line line = new Line(new Point(0, 0, 0), new Point(0, 0, 1));
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
        Plain plain = new Plain(new Point(0, 0, 0), new Point(0, 0, 1));
        Line line = null;
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
