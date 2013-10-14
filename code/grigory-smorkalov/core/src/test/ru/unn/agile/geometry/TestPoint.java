package ru.unn.agile.geometry;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestPoint {
    @Test
    public void scalarMultZeroPoint()
    {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 2, 3);

        double result = p1.scalarMultiply(p2);

        assertEquals(result, 0.0, Point.ACCURACY);
    }

    @Test
    public void scalarMultNormal()
    {
        Point p1 = new Point(4, 5, 6);
        Point p2 = new Point(1, 2, 3);

        double result = p1.scalarMultiply(p2);

        assertEquals(result, 32.0, Point.ACCURACY);
    }

    @Test
    public void minusNormal()
    {
        Point p1 = new Point(4, 5, 6);
        Point p2 = new Point(1, 2, 3);

        Point result = p1.minus(p2);

        assertEquals(result, new Point(3, 3, 3));
    }
}
