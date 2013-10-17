package ru.unn.agile.temperatureConverterTests;

import ru.unn.agile.temperatureConverter.*;
import junit.framework.Assert;
import org.junit.Test;

public class TemperatureConverterTests {

    private Converter temperatureConverter;

    @Test
    public void canCreateCustomScale() {
        Scale dummyScale = new Scale("Dummy", 2, 3);

        Assert.assertEquals("Dummy", dummyScale.getName());
        Assert.assertEquals(9.0, dummyScale.scaleForward(3));
        Assert.assertEquals(3.0, dummyScale.scaleBackward(9));
    }

    @Test
    public void canGetScaleFromList() {
        Scale scale = ScaleProvider.get(ScaleFormat.Celsius);
        Assert.assertNotNull(scale);
        Assert.assertEquals("Celsius", scale.getName());
    }
}
