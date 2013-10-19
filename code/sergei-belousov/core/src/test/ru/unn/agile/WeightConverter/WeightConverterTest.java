package ru.unn.agile.WeightConverter;

import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.UnitConverter.Unit;
import ru.unn.agile.UnitConverter.UnitConvertTableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class WeightConverterTest {
    private final double epsilon = 1e-12;
    private WeightConverter weightConverter;

    @Before
    public void setup() {
        weightConverter = new WeightConverter();
        try {
            weightConverter.loadTable("C:\\DevTools\\work\\unn\\agile-development-course\\code\\sergei-belousov\\core\\resources\\table.txt");
        } catch(IOException e) {
            System.out.println("can't open file");
            fail();
        }
    }

    @Test
    public void loadedTableNotEmpty() {
        assertFalse(weightConverter.isEmpty());
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
            assertEquals(expected, weightConverter.convert(formatString, new Unit(to, value)).getValue(), epsilon);
        } catch (UnitConvertTableException e) {
            System.out.println(e.getMessage());
            fail("catch exception");
        }
    }
}
