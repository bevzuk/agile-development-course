package ru.unn.agile.temperatureConverter;

import ru.unn.agile.temperatureConverter.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemperatureConverterTests {


    private TemperatureConverter temperatureConverter;

    @Before
    public void Setup() {
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    public void canCreateTemperatureConverterInstance() {
        Assert.assertNotNull(temperatureConverter);
    }

    @Test
    public void canCreateTemperatureConverterInstanceWithDefaultInitialValue() {
        double defaultTemperature = 0;
        Assert.assertEquals(defaultTemperature, temperatureConverter.getCurrentInCelsius());
    }

    @Test
    public void canCreateTemperatureConverterInstanceWithInitialValueInCelsius() {
        temperatureConverter = new TemperatureConverter(12.3);
        Assert.assertEquals(12.3, temperatureConverter.getCurrentInCelsius());
    }

    @Test
    public void canSetCurrentTemperatureInCesius() {
        temperatureConverter.setCurrentInCelsius(10.0);
        Assert.assertEquals(10.0, temperatureConverter.getCurrentInCelsius());
    }

    @Test
    public void canSetCurrentTemperatureInFahrenheit() {
        temperatureConverter.setCurrentInFahrenheit(96.6);
        Assert.assertEquals(96.6, temperatureConverter.getCurrentInFahrenheit());
    }

    @Test
    public void canSetInFahrenheitAdnGetInCelsius() {
        temperatureConverter.setCurrentInFahrenheit(90.5);
        Assert.assertEquals(32.5, temperatureConverter.getCurrentInCelsius());
    }

    @Test
    public void canSetInCelsiusAdnGetInFahrenheit() {
        temperatureConverter.setCurrentInCelsius(-32.5);
        Assert.assertEquals(-26.5, temperatureConverter.getCurrentInFahrenheit());
    }

    @Test
    public void canSetCurrentTemperatureInKelvin() {
        temperatureConverter.setCurrentInKelvin(10);
        Assert.assertEquals(10.0, temperatureConverter.getCurrentInKelvin());
    }

    @Test
    public void canSetInKelvinAndGetInCelsius() {
        temperatureConverter.setCurrentInKelvin(0);
        Assert.assertEquals(-273.15, temperatureConverter.getCurrentInCelsius());
    }

    @Test
    public void canSetInCelsiusAndGetInKelvin() {
        temperatureConverter.setCurrentInCelsius(0);
        Assert.assertEquals(273.15, temperatureConverter.getCurrentInKelvin());
    }

    @Test
    public void canSetCurrentTemperatureInNewton() {
        temperatureConverter.setCurrentInNewton(132.0);
        Assert.assertEquals(132.0, temperatureConverter.getCurrentInNewton());
    }

    @Test
    public void canSetInNewtonAndGetInCelsius() {
        temperatureConverter.setCurrentInNewton(132.0);
        Assert.assertEquals(400.0, temperatureConverter.getCurrentInCelsius());
    }

    @Test
    public void canSetInCelsiusAndGetInNewton() {
        temperatureConverter.setCurrentInCelsius(400.0);
        Assert.assertEquals(132.0, temperatureConverter.getCurrentInNewton());
    }
}
