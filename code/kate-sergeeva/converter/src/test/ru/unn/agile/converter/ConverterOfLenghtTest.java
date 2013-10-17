package ru.unn.agile.converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConverterOfLenghtTest {
    double eps = 1e-5;
    private ConverterOfLenght converterOfLenght;

    @Before
    public void setUp() {
        converterOfLenght = new ConverterOfLenght();
    }

    @Test
    public void isCorrectSetValueFromMeter(){
        assertEquals(24.67, converterOfLenght.setValueFromMeter(24.67), eps);
    }

    @Test
    public void isCorrectSetValueFromKilometer() {
        assertEquals(24670, converterOfLenght.setValueFromKilometer(24.67), eps);
    }

    @Test
    public void isCorrectSetValueFromInch() {
        assertEquals(0.626618, converterOfLenght.setValueFromInch(24.67), eps);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInSetFromMeter() {
        converterOfLenght.setValueFromMeter(-10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnBigInputValueInSetFromMeter() {
        converterOfLenght.setValueFromMeter(Double.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInSetFromKilometer() {
        converterOfLenght.setValueFromKilometer(-10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnBigInputValueInSetFromKilometer() {
        converterOfLenght.setValueFromKilometer(Double.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInSetFromInch() {
        converterOfLenght.setValueFromInch(-10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnBigInputValueInSetFromInch() {
        converterOfLenght.setValueFromInch(Double.MAX_VALUE / converterOfLenght.factorInchToMeter);
    }


    @Test
    public void isCorrectConvertToMeterSmallValue(){
        converterOfLenght.setValueFromMeter(2.34e-12);
        assertEquals(2.34e-12, converterOfLenght.convertToMeter(), eps);
    }

    @Test
    public void isCorrectConvertToKilometerSmallValue(){
        converterOfLenght.setValueFromKilometer(2.34e-12);
        assertEquals(2.34e-12, converterOfLenght.convertToKilometer(), eps);
    }

    @Test
    public void isCorrectConvertToInchSmallValue(){
        converterOfLenght.setValueFromInch(2.34e-12);
        assertEquals(2.34e-12, converterOfLenght.convertToInch(), eps);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInConvertToMeter() {
        converterOfLenght.convertToMeter();
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInConvertToKilometer() {
        converterOfLenght.convertToKilometer();
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInConvertToInch() {
        converterOfLenght.convertToInch();
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnBigValueInConvertToInch() {
        converterOfLenght.setValueFromMeter(Double.MAX_VALUE - eps);
        converterOfLenght.convertToInch();
    }

}
