package ru.unn.agile.temperatureConverterTests;

import ru.unn.agile.temperatureConverter.*;
import junit.framework.Assert;
import org.junit.Test;

public class TemperatureConverterTests {

    private Converter temperatureConverter;

    @Test
    public void canConvertFromCelsiusToFahrenheit() {
        Converter converter = new Converter(AvailableScales.Celsius,
                AvailableScales.Fahrenheit);

        double result = converter.leftToRight(36.5);
        Assert.assertEquals(97.7, result);
    }

    @Test
    public void converterScaleIsNullExceptionThrown() {
        try {
            Converter converter = new Converter(null, AvailableScales.Rankine);
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
    public void canCreateTemperature() {
        Temperature t = new Temperature(36.6, AvailableScales.Celsius);

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
}
