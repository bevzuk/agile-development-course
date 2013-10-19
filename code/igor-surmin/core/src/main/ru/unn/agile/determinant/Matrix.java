package ru.unn.agile.determinant;


public class Matrix {
    private int n;
    private double[] data;
    public static double EPS = 1e-6;

    public Matrix(int n)
    {
        this.n = n;
        data = new double[n * n];
        for (int i = 0; i < n * n; i++)
            data[i] = 0.0;
    }

    public double getNorm()
    {
        double norm = 0;
        for (int i = 0; i < n * n; i++)
            norm += data[i] * data[i];
        return Math.sqrt(norm);
    }
}
