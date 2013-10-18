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
    public void isCorrectConvertRodToKilometer(){
        assertEquals(0.050292, converterOfLenght.convertLenght("rod", "kilometer", 10), eps);
    }

    @Test
    public void isCorrectConvertMileToChain(){
        assertEquals(800, converterOfLenght.convertLenght("mile", "chain", 10), eps);
    }

    @Test
    public void isCorrectConvertDecimeterToYard(){
        assertEquals(1.093613298, converterOfLenght.convertLenght("decimeter", "yard", 10), eps);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnOverflowInConvertMileToMillimeter(){
        converterOfLenght.convertLenght("mile", "millimeter", Double.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnOverflowInConvertKilometerToDecimeter(){
        converterOfLenght.convertLenght("kilometer", "decimeter", Double.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnOverflowInConvertChainToYard(){
        converterOfLenght.convertLenght("chain", "yard", Double.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnOverflowExponentInConvert(){
        converterOfLenght.convertLenght("millimeter", "mile", Double.MIN_NORMAL);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnIllegalInputUnitInConvertLenght(){
        String inputUnit = "parrot";
        converterOfLenght.convertLenght(inputUnit, "meter", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnIllegalOutputUnitInConvertLenght(){
        String outputUnit = "parrot";
        converterOfLenght.convertLenght("chain", outputUnit, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwsOnNegativeInputValueInConvertLenght(){
        converterOfLenght.convertLenght("meter", "kilometer", -10);
    }

}
