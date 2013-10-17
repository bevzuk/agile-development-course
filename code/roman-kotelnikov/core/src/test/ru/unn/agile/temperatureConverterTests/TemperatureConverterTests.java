package ru.unn.agile.temperatureConverterTests;

import org.junit.Before;
import ru.unn.agile.temperatureConverter.*;
import junit.framework.Assert;
import org.junit.Test;

public class TemperatureConverterTests {

    private Temperature t;

    @Before
    public void setUp() {
        t = new Temperature(36.6, AvailableScales.Celsius);
    }

    @Test
    public void canCreateTemperature() {
        Assert.assertNotNull(t);
        Assert.assertEquals("36.6 C", t.toString());
    }

    @Test
    public void temperatureScaleIsNullExceptionThrown() {
        try {
            Temperature t = new Temperature(36.6, null);
            assert false;
        }
        catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Scale cannot be null");
        }
        catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void canConvertFromCelsiusToFahrenheit() {
        double result = Converter.convert(t, AvailableScales.Fahrenheit).getCurrent();
        Assert.assertEquals(97.7, result);
    }

    @Test
    public void convertTemperatureIsNullExceptionThrown() {
        expectedErrorMessage(null, AvailableScales.Romer, "Temperature cannot be null");
    }

    @Test
    public void convertScaleIsNullExceptionThrown() {
        expectedErrorMessage(t, null, "Scale cannot be null");
    }

    private void expectedErrorMessage(Temperature t, AvailableScales scale, String expectedError) {
        try {
            Converter.convert(t, scale);
            assert false;
        }
        catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), expectedError);
        }
        catch (Exception e) {
            assert false;
        }
    }
}
