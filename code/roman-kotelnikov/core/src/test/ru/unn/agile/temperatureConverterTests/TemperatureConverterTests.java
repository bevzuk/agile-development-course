package ru.unn.agile.temperatureConverterTests;

import ru.unn.agile.temperatureConverter.*;
import junit.framework.Assert;
import org.junit.Test;

public class TemperatureConverterTests {

    private Converter temperatureConverter;

    @Test
    public void canCreateCustomScale() {
        try {
            Scale dummyScale = new Scale("Dummy", 2, 3);

            Assert.assertEquals("Dummy", dummyScale.getName());
            Assert.assertEquals(9.0, dummyScale.scaleForward(3));
            Assert.assertEquals(3.0, dummyScale.scaleBackward(9));
        }
        catch (Exception e)
        {
           assert false;
        }
    }

    @Test
    public void nullScaleNameExceptionThrown() {
        try{
            Scale dummyScale = new Scale(null, 3 , 4);
            assert false;
        }
        catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Scale name cannot be null");
        }
    }

    @Test
    public void canGetExistentScale() {
        Scale scale = ScaleProvider.get(AvailableScales.Celsius);
        Assert.assertNotNull(scale);
        Assert.assertEquals("Celsius", scale.getName());
    }

    @Test
    public void canConvertFromCelsiusToFahrenheit() {
        Converter converter = new Converter(ScaleProvider.get(AvailableScales.Celsius),
                ScaleProvider.get(AvailableScales.Fahrenheit));

        double result = converter.leftToRight(36.5);
        Assert.assertEquals(90.5, result);
    }
}
