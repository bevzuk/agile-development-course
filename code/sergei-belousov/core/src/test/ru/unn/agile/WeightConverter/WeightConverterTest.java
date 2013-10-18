package ru.unn.agile.WeightConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightConverterTest {
    final double epsilone = 1e-15;
    private WeightConverter weightConverter;

    @Before
    public void setUp() {
        weightConverter = new WeightConverter();
        weightConverter.addPair("kg", "g", 1000.);
        weightConverter.addPair("kg", "ct", 5000.);
        weightConverter.addPair("kg", "lb", 2.205);
    }

    @Test
    public void emptyKeyGivenZero() {
        assertConvertReturns(0., "", 0.);
    }

    @Test
    public void InOneKilogramThousandGrams() {
        assertConvertReturns(1000., "kg-g", 1.);
    }

    @Test
    public void InOneKilogramFiveThousandCarats() {
        assertConvertReturns(5000., "kg-ct", 1.);
    }

    @Test
    public void InOneGramOneThousandthKilogram() {
        assertConvertReturns(0.001, "g-kg", 1.);
    }

    @Test
    public void InOneKilogramTwoPointTwoHundredAndFivePound() {
        assertConvertReturns(2.205, "kg-lb", 1.);
    }

    private void assertConvertReturns(double expected, String from_to, double value)
    {
        try {
            assertEquals(expected, weightConverter.convert(from_to, value), epsilone);
        } catch (WeightConvertTableException e) {
            System.out.println(e.getMessage());
        }
    }
}
