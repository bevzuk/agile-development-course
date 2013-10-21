package ru.unn.agile.quadsolver;


import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertArrayEquals;

public class QuadraticEquationSolverTest {

    protected static final double delta = 1e-10;
    protected QuadraticEquationSolver qSolver = new QuadraticEquationSolver();

    @Test(expected = InvalidParameterException.class)
    public void equationWithZeroParametersThrowsException() {
        qSolver.initializeSolver(0, 0, 0);
    }

    @Test(expected = InvalidParameterException.class)
    public void nonInitializedSolverThrowsException() {
        qSolver.Solve();
    }

    @Test(expected = InvalidParameterException.class)
    public void equationWithCNonZeroOnlyThrowsException() {
        qSolver.initializeSolver(0, 0, 5);
        qSolver.Solve();
    }

    @Test
    public void linearEquationIsSolvedCorrectly() {
        qSolver.initializeSolver(0, 5, 10);
        qSolver.Solve();
        double[] solution = qSolver.getSolution();
        assertArrayEquals(new double[]{-2}, solution, delta);
    }

    @Test
    public void quadraticEquationIsSolvedCorrectly() {
        qSolver.initializeSolver(1, -4, 3);
        qSolver.Solve();
        double[] solution = qSolver.getSolution();
        assertArrayEquals(new double[]{1, 3}, solution, delta);
    }

    @Test
    public void equationWithZeroDiscriminantIsSolvedCorrectly() {
        qSolver.initializeSolver(1, -4, 4);
        qSolver.Solve();
        double[] solution = qSolver.getSolution();
        assertArrayEquals(new double[]{2}, solution, delta);
    }

    @Test
    public void equationWithNegativeDiscriminantGivesEmptySolution() {
        qSolver.initializeSolver(1, -4, 5);
        qSolver.Solve();
        double[] solution = qSolver.getSolution();
        assertArrayEquals(new double[]{}, solution, delta);
    }
}

