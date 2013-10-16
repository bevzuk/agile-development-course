package ru.unn.agile.areaConverterTests;

import ru.unn.agile.areaConverter.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class AreaConverterTests {

    private void canSetAreaConverterInstanceWithNegativeAreaInMetre() {
        areaConverter.setCurrentInMetre(-1.0);
        Assert.assertEquals(0.0,areaConverter.getCurrentInMetre());
    }

    private void canSetAreaConverterInstanceWithNegativeAreaInCentimetre() {
        areaConverter.setCurrentCentimetre(-123.456);
        Assert.assertEquals(0.0,areaConverter.getCurrentInMetre());
    }

    private void canSetAreaConverterInstanceWithNegativeAreaInHectare() {
        areaConverter.setCurrentInHectare(-789.012);
        Assert.assertEquals(0.0,areaConverter.getCurrentInMetre());
    }

    private void canSetAreaConverterInstanceWithNegativeAreaInYard() {
        areaConverter.setCurrentInYard(-34.56);
        Assert.assertEquals(0.0,areaConverter.getCurrentInMetre());
    }


    private AreaConverter areaConverter;

    @Before
    public void Setup() {
        areaConverter = new AreaConverter();
    }

    @Test
    public void canCreateAreaConverterInstance() {
        Assert.assertNotNull(areaConverter);
    }

    @Test
    public void canSetNegativeArea() {
        canSetAreaConverterInstanceWithNegativeAreaInCentimetre();
        canSetAreaConverterInstanceWithNegativeAreaInHectare();
        canSetAreaConverterInstanceWithNegativeAreaInMetre();
        canSetAreaConverterInstanceWithNegativeAreaInYard();
    }

    @Test
    public void canCreateAreaConverterInstanceWithDefaultInitialValue() {
        double defaultArea = 0.0;
        Assert.assertEquals(defaultArea, areaConverter.getCurrentInMetre());
    }

    @Test
    public void canCreateAreaConverterInstanceWithInitialValueInMetre() {
        areaConverter = new AreaConverter(32.1);
        Assert.assertEquals(32.1, areaConverter.getCurrentInMetre());
    }

    @Test
    public void canSetCurrentAreInMetre() {
        areaConverter.setCurrentInMetre(636.123);
        Assert.assertEquals(636.123, areaConverter.getCurrentInMetre());
    }

    @Test
    public void canSetCurrentTemperatureInHectare() {
        areaConverter.setCurrentInHectare(0.217);
        Assert.assertEquals(0.217, areaConverter.getCurrentInHectare());
    }

    @Test
    public void canSetInYardAndGetInHectare() {
        areaConverter.setCurrentInYard(11959.9);
        Assert.assertEquals(11959.9  * 0.83612736 / 10000, areaConverter.getCurrentInHectare());
    }

    @Test
    public void canSetInMetreAndGetInYard() {
        areaConverter.setCurrentInMetre(10.0);
        Assert.assertEquals(10.0 * 1.195990, areaConverter.getCurrentInYard());
    }

    @Test
    public void canSetCurrentAreaInYard() {
        areaConverter.setCurrentInYard(10);
        Assert.assertEquals(8.3612736, areaConverter.getCurrentInMetre());
    }
}


