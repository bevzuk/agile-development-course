package ru.unn.agile.MathStatistic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathStatisticTest {
    private MathStatistic mathStatistic;
    private float[] tinyInputData = {0.0f};
    private float[] mediumInputData = {0.0f, 0.0f, 0.1f, 0.2f, 1.3f, 1.4f, 1.3f, 1.5f, 2.0f, 2.0f, 2.0f, 2.3f, 2.5f};
    private float[] bigInputData  = {0.0f, 0.0f, 0.1f, 0.2f, 1.3f, 1.4f, 1.3f, 1.5f, 2.0f, 2.0f, 2.0f, 2.3f, 2.5f, 2.6f, 3.1f, 4.2f, 4.5f, 5.1f, 5.1f};

    @Before
    public void setUp() {
        mathStatistic = new MathStatistic();
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnEmptyDataCalcExpectedValue() {
        float[] inputData = {};
        mathStatistic.calcExpectedValue(inputData);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnEmptyDataCalcVariance() {
        float[] inputData = {};
        mathStatistic.calcVariance(inputData);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnEmptyDataCalcThirdCentralMoment() {
        float[] inputData = {};
        mathStatistic.calcThirdCentralMoment(inputData);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnEmptyDataCalcFourthCentralMoment() {
        float[] inputData = {};
        mathStatistic.calcFourthCentralMoment(inputData);
    }

    @Test
    public void testExpectedValueOnTinyData() {
        float result;
        result =   mathStatistic.calcExpectedValue(tinyInputData);
        assertEquals(result, 0, 1e-5);
    }

    @Test
    public void testExpectedValueOnMediumData() {
        float result;
        result =   mathStatistic.calcExpectedValue(mediumInputData);
        assertEquals(result, 1.27692, 1e-5);
    }

    @Test
    public void testExpectedValueOnBigData() {
        float result;
        result =   mathStatistic.calcExpectedValue(bigInputData);
        assertEquals(result, 2.16842, 1e-5);
    }

    @Test
    public void testVarianceValueOnTinyData() {
        float result;
        result =   mathStatistic.calcVariance(tinyInputData);
        assertEquals(result, 0, 1e-5);
    }

    @Test
    public void testVarianceValueOnMediumData() {
        float result;
        result =   mathStatistic.calcVariance(mediumInputData);
        assertEquals(result, 0.76793, 1e-5);
    }

    @Test
    public void testVarianceValueOnBigData() {
        float result;
        result =   mathStatistic.calcVariance(bigInputData);
        assertEquals(result, 2.53269, 1e-5);
    }

    @Test
    public void testThirdCentralMomentValueOnTinyData() {
        float result;
        result =   mathStatistic.calcThirdCentralMoment(tinyInputData);
        assertEquals(result, 0, 1e-5);
    }

    @Test
    public void testThirdCentralMomentValueOnMediumData() {
        float result;
        result =   mathStatistic.calcThirdCentralMoment(mediumInputData);
        assertEquals(result, -0.23043, 1e-5);
    }

    @Test
    public void testThirdCentralMomentValueOnBigData() {
        float result;
        result =   mathStatistic.calcThirdCentralMoment(bigInputData);
        assertEquals(result, 1.75955, 1e-5);
    }

    @Test
    public void testFourthCentralMomentValueOnTinyData() {
        float result;
        result =   mathStatistic.calcFourthCentralMoment(tinyInputData);
        assertEquals(result, 0, 1e-5);
    }

    @Test
    public void testFourthCentralMomentValueOnMediumData() {
        float result;
        result =   mathStatistic.calcFourthCentralMoment(mediumInputData);
        assertEquals(result, 0.97977, 1e-5);
    }

    @Test
    public void testFourthCentralMomentValueOnBigData() {
        float result;
        result =   mathStatistic.calcFourthCentralMoment(bigInputData);
        assertEquals(result, 14.43848, 1e-5);
    }
}

