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
}
