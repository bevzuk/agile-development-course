package ru.unn.agile.determinant;

import java.lang.String;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestMatrix {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    public void createZeroMatrixTest()
    {
        Matrix a = new Matrix(3);
        assertEquals (a.getNorm(), 0, Matrix.EPS);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createZeroSizeMatrixTest()
    {
        Matrix a = new Matrix(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createNegativeSizeMatrixTest()
    {
        Matrix a = new Matrix(-3);
    }

    @Test
    public void SetItemTest()
    {
       Matrix a = new Matrix(3);
       double val = 10.0;
       a.setItem(2, 1, val);
       assertEquals(a.getItem(2, 1), val, Matrix.EPS);
    }

    @Test
    public void SetBoundaryValueTest()
    {
        Matrix a = new Matrix(3);
        double val = 10.0;
        a.setItem(2, 2, val);
        assertEquals(a.getItem(2, 2), val, Matrix.EPS);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void SetOutOfRangeItemTest()
    {
        Matrix a = new Matrix(3);
        double val = 10.0;
        a.setItem(3, 2, val);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void GetOutOfRangeItemTest()
    {
        Matrix a = new Matrix(3);
        a.getItem(3, 2);
    }

    @Test
    public void GetNormOfIdentityTest()
    {
        Matrix a = new Matrix(3);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                a.setItem(i, j, 1.0);
        assertEquals(a.getNorm(), (double)3, Matrix.EPS);
    }

    @Test
    public void GetNormTest()
    {
        Matrix a = new Matrix(2);
        a.setItem(0, 0, 2.0);
        a.setItem(0, 1, 1.0);
        a.setItem(1, 0, -5.0);
        a.setItem(1, 1, 3.0);
        assertEquals(a.getNorm(), Math.sqrt(39.0), Matrix.EPS);
    }
}
