package ru.unn.agile.UnitConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitConverterTest {
    final double epsilon = 1e-15;
    private UnitConverter unitConverter;

    @Before
    public void setUp() {
        unitConverter = new UnitConverter();
        unitConverter.addPair("kg", "g", 1000.);
        unitConverter.addPair("kg", "ct", 5000.);
        unitConverter.addPair("kg", "lb", 2.205);
    }

    @Test
    public void InOneKilogramThousandGrams() {
        assertConvertReturns(1000., "kg", "g", 1.);
    }

    @Test
    public void InOneKilogramFiveThousandCarats() {
        assertConvertReturns(5000., "kg", "ct", 1.);
    }

    @Test
    public void InOneGramOneThousandthKilogram() {
        assertConvertReturns(0.001, "g", "kg", 1.);
    }

    @Test
    public void InOneKilogramTwoPointTwoHundredAndFivePound() {
        assertConvertReturns(2.205, "kg", "lb", 1.);
    }

    private void assertConvertReturns(double expected, String from, String to, double value)
    {
        try {
            String formatString = from + "-" + to;
            assertEquals(expected, unitConverter.convert(formatString, value).getValue(), epsilon);
        } catch (UnitConvertTableException e) {
            System.out.println(e.getMessage());
            fail("catch exception");
        }
    }
}
