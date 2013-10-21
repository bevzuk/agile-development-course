package ru.unn.agile.quadsolver;

import java.security.InvalidParameterException;

public class QuadraticEquationSolver {
    private double a, b, c;
    private double[] X;

    QuadraticEquationSolver() {
        a = 0;
        b = 0;
        c = 0;
    }

    public void initializeSolver(double a, double b, double c) throws InvalidParameterException {
        if (a == 0 && b == 0 && c == 0)
            throw new InvalidParameterException("All arguments cannot be zero!");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getSolution() {
        return X;
    }

    public void Solve() {
        if (a == 0 && b == 0 && c == 0)
            throw new InvalidParameterException("Not Initialized Solver!");
        if (a == 0 && b == 0 && c != 0)
            throw new InvalidParameterException("Equation cannot be solve!");

        if (a == 0) {
            X = new double[1];
            X[0] = -c / b;
            return;
        }

        double D = getDiscriminant();

        if (Math.abs(D) <= 1e-10) {
            X = new double[1];
            X[0] = -b / (2 * a);
            return;
        }

        if (D < 0){
            X = new double[]{};
            return;
        }

        X = new double[2];
        X[0] = (-b - Math.sqrt(D)) / (2 * a);
        X[1] = (-b + Math.sqrt(D)) / (2 * a);
    }

    private double getDiscriminant() {
        return b * b - 4 * a * c;
    }
}
