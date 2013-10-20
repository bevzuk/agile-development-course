package ru.unn.agile.Triangle;

import ru.unn.agile.Triangle.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest
{
    public final double delta = 0.001;

    @Test
    public void canCreateTriangle()
    {
        Point pointA = new Point(5, 5);
        Point pointB = new Point(4, 5);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertNotNull(triangle);
    }

    @Test
    public void canNotCreateTriangleWhihtTwoEqualPoints()
    {
        Point pointA = new Point(5, 5);
        Point pointB = new Point(5, 5);
        Point pointC = new Point(0, 0);

        try
        {
            Triangle triangle = new Triangle(pointA, pointB, pointC);
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("Points must be different.", ex.getMessage());
        }
    }

    @Test
    public void canNotCreateTriangleWhihtThreeEqualPoints()
    {
        Point pointA = new Point(5, 5);
        Point pointB = new Point(5, 5);
        Point pointC = new Point(5, 0);

        try
        {
            Triangle triangle = new Triangle(pointA, pointB, pointC);
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("Points must be different.", ex.getMessage());
        }
    }

    @Test
    public void canNotCreateTriangleWhihtCollinearPoints()
    {
        Point pointA = new Point(1, 5);
        Point pointB = new Point(2, 5);
        Point pointC = new Point(5, 5);

        try
        {
            Triangle triangle = new Triangle(pointA, pointB, pointC);
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("Points can't be collinear.", ex.getMessage());
        }
    }

    @Test
    public void canGetPerimeter()
    {
        Point pointA = new Point(0, 3);
        Point pointB = new Point(4, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(12.0, triangle.perimeter(), delta);
    }

    @Test
    public void canGetPerimeterWithPointNegativeCoordinate()
    {
        Point pointA = new Point(0, -3);
        Point pointB = new Point(-4, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(12.0, triangle.perimeter(), delta);
    }

    @Test
    public void canGetSquare()
    {
        Point pointA = new Point(0, 3);
        Point pointB = new Point(4, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(6.0, triangle.square(), delta);
    }

    @Test
    public void canGetSquareWithPointNegativeCoordinate()
    {
        Point pointA = new Point(0, -3);
        Point pointB = new Point(-4, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(6.0, triangle.square(), delta);
    }

    @Test
    public void canGetCircumradius()
    {
        Point pointA = new Point(0, 3);
        Point pointB = new Point(4, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(2.5, triangle.circumradius(), delta);
    }

    @Test
    public void canGetCircumradiusWithPointNegativeCoordinate()
    {
        Point pointA = new Point(0, -3);
        Point pointB = new Point(-4, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(2.5, triangle.circumradius(), delta);
    }

    @Test
    public void canGetInRadius()
    {
        Point pointA = new Point(0.5, Math.sqrt(3.0) / 2);
        Point pointB = new Point(1, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(Math.sqrt(3.0) / 6, triangle.inRadius(), delta);
    }

    @Test
    public void canGetInRadiusWithPointNegativeCoordinate()
    {
        Point pointA = new Point(-0.5, -Math.sqrt(3.0) / 2);
        Point pointB = new Point(-1, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(Math.sqrt(3.0) / 6, triangle.inRadius(), delta);
    }

    @Test
    public void canGetSideLength()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 10);
        Point pointC = new Point(5, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(10.0, triangle.sideLength("AB"), delta);
    }

    @Test
    public void canNotGetSideLengthForWrongSideName()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 10);
        Point pointC = new Point(9, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        try
        {
            triangle.sideLength("DB");
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
            assertEquals("The name of side is wrong.", ex.getMessage());
        }
    }

    @Test
    public void canNotGetSideLengthForWrongSideNameSecondLetter()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 10);
        Point pointC = new Point(9, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        try
        {
            triangle.sideLength("AF");
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
            assertEquals("The name of side is wrong.", ex.getMessage());
        }
    }

    @Test
    public void canNotGetSideLengthForWrongLengthSideName()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 10);
        Point pointC = new Point(9, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        try
        {
            triangle.sideLength("ABC");
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
            assertEquals("The name of side is wrong.", ex.getMessage());
        }
    }

    @Test
    public void canGetAngle()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 1);
        Point pointC = new Point(1, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        assertEquals(1.57, triangle.angle("A"), delta);
    }

    @Test
    public void canNotGetAngleForWrongAngleName()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 10);
        Point pointC = new Point(10, 9);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        try
        {
            triangle.angle("D");
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
            assertEquals("The name of angle is wrong.", ex.getMessage());
        }
    }

    @Test
    public void canNotGetAngleForWrongLengthAngleName()
    {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 10);
        Point pointC = new Point(10, 9);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        try
        {
            triangle.angle("ABC");
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("The name of angle is wrong.", ex.getMessage());
        }
    }

}

