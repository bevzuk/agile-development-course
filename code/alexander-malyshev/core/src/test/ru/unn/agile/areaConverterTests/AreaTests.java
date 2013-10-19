package ru.unn.agile.areaConverterTests;

import ru.unn.agile.areaConverter.*;

import junit.framework.*;
import org.junit.Before;
import org.junit.Test;

public class AreaTests {
    private Area area;

    @Test
    public void canCreateAreaInstance() {
        area = new Area(1.0, "Metre");
        Assert.assertNotNull(area);
    }

    @Test
    public void canSetNegativeArea() {
        try {
            area = new Area(-1.0, "Metre");
        }
        catch (Exception e) {
            Assert.assertEquals(e.getMessage(),"Negative measure");
        }
    }

    @Test
    public void canSetWrongScale() {
        try {
            area = new Area(1.0, "some wrong scale");
        }
        catch (Exception e) {
            Assert.assertEquals(e.getMessage(),"Wrong or empty scale");
        }
    }

    @Test
    public void canPerformToSiConvertation() {
        area = new Area(1.0, "Hectare");
        Assert.assertEquals(area.toSI(), 10000.0);
    }

    @Test
    public void canPerformFromSiConvertation() {
        area = new Area(12.3, "Metre");
        Assert.assertEquals(area.fromSI("Yard"), 12.3 / 0.83612736);
    }

}
