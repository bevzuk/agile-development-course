package ru.unn.agile.temperatureConverterTests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.*;

import ru.unn.agile.temperatureConverter.*;
import static ru.unn.agile.temperatureConverter.AvailableScales.*;
import static ru.unn.agile.temperatureConverter.Converter.*;

public class TemperatureConverterTests {

    private Temperature t;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        t = new Temperature(36.5, Celsius);
    }

    @Test
    public void canCreateTemperature() {
        assertNotNull(t);
        assertEquals("36.5 C", t.toString());
    }

    @Test
    public void temperatureScaleIsNullExceptionThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Scale cannot be null");
        Temperature t = new Temperature(36.6, null);
    }

    @Test
    public void canScaleCelsiusToFahrenheit() {
        assertEquals(97.7, Fahrenheit.scaleTo(36.5));
    }

    @Test
    public void canScaleCelsiusFromKelvin() {
        assertEquals(0.0, Kelvin.scaleFrom(273.15));
    }

    @Test
    public void canGetPrettyFormat() {
        assertEquals("24.3 Ro", Romer.toString(24.3));
    }

    @Test
    public void canConvertFromRomerToCelsius() {
        Temperature t = new Temperature(28.5, Romer);
        Temperature result = convert(t, Celsius);
        assertEquals(Celsius, result.getScale());
        assertEquals(40.0, result.getCurrent());
    }

    @Test
    public void convertTemperatureIsNullExceptionThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Temperature cannot be null");
        convert(null, Romer);
    }

    @Test
    public void convertScaleIsNullExceptionThrown() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Scale cannot be null");
        convert(t, null);
    }
}
