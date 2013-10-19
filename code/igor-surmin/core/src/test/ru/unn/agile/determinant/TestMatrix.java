package ru.unn.agile.determinant;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMatrix {
    @Test
    public void createZeroMatrixTest()
    {
        Matrix a = new Matrix(3);
        assertEquals (a.getNorm(), 0, Matrix.EPS);
    }
}
