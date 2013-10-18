package ru.unn.agile.temperatureConverterTests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import ru.unn.agile.temperatureConverter.*;
import junit.framework.Assert;
import org.junit.Test;

public class TemperatureConverterTests {

    private Temperature t;

    @Before
    public void setUp() {
        t = new Temperature(36.5, AvailableScales.Celsius);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void canCreateTemperature() {
        Assert.assertNotNull(t);
        Assert.assertEquals("36.5 C", t.toString());
    }

    @Test
    public void temperatureScaleIsNullExceptionThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Scale cannot be null");
        Temperature t = new Temperature(36.6, null);
    }

    @Test
    public void canScaleCelsiusToFahrenheit() {
        AvailableScales scale = AvailableScales.Fahrenheit;
        Assert.assertEquals(97.7, scale.scaleTo(36.5));
    }

    @Test
    public void canScaleCelsiusFromKelvin() {
        AvailableScales scales = AvailableScales.Kelvin;
        Assert.assertEquals(0, scales.scaleFrom(273.15));
    }

    @Test
    public void canGetPrettyFormat() {
        Assert.assertEquals("24.3 Ro", AvailableScales.Romer.toString(24.3));
    }

    @Test
    public void canConvertFromRomerToCelsius() {
        Temperature t = new Temperature(28.5, AvailableScales.Romer);
        Temperature result = Converter.convert(t, AvailableScales.Celsius);
        Assert.assertEquals(AvailableScales.Celsius, result.getScale());
        Assert.assertEquals(40.0, result.getCurrent());
    }

    @Test
    public void convertTemperatureIsNullExceptionThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Temperature cannot be null");
        Converter.convert(null, AvailableScales.Romer);
    }

    @Test
    public void convertScaleIsNullExceptionThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Scale cannot be null");
        Converter.convert(t, null);
    }
}
