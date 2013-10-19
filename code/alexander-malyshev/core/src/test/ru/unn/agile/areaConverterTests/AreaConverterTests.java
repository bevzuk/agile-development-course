package ru.unn.agile.areaConverterTests;

import ru.unn.agile.areaConverter.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class AreaConverterTests {

    @Test
    public void canPerfromConvert() {
        double value = AreaConverter.convert(10.0, "Hectare", "Yard");
        Assert.assertEquals(value, 10.0 * 10000 / 0.83612736);
    }

}


