package ru.unn.agile.fraction;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class FractionCalculatorTest {

    @Test
    public void canCreateFractionWithInitialValues() {
        Fraction fraction = new Fraction(0, 1);
        assertNotNull(fraction);
    }

    @Test
    public void canSetInitialValue() {
        Fraction fraction = new Fraction(1, 3);
        assertEquals(1, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test (expected=IllegalArgumentException.class)
    public void canDenominatorBeZero() {
        Fraction fraction = new Fraction(5, 0);
    }

    @Test
    public void canDenominatorBeNegative() {
        Fraction fraction = new Fraction(5, -7);
        assertEquals(-5, fraction.getNumerator());
        assertEquals(7, fraction.getDenominator());
    }

    @Test
    public void canNumeratorAndDenominatorBeNegative() {
        Fraction fraction = new Fraction(-5, -7);
        assertEquals(5, fraction.getNumerator());
        assertEquals(7, fraction.getDenominator());
    }

    @Test
    public void canReduce() {
        Fraction fraction = new Fraction(18, 24);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void canParseFraction() {
        Fraction fraction = Fraction.parse("3/8");
        assertEquals(3, fraction.getNumerator());
        assertEquals(8, fraction.getDenominator());
    }

    @Test
    public void canParseInteger() {
        Fraction fraction = Fraction.parse("5");
        assertEquals(5, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    public void canTryParseNoFraction() {
        assertFalse(Fraction.tryParse("string"));
    }

    @Test
    public void canTryParseFraction() {
        assertTrue(Fraction.tryParse("7/8"));
    }

    @Test
    public void canConvertToString() {
        Fraction fraction = new Fraction(5, 6);
        assertEquals("5/6", fraction.toString());
    }

    @Test
    public void canAddPositiveFraction() {
        Fraction first = new Fraction(2, 5);
        Fraction second = new Fraction(3, 10);
        Fraction result = first.add(second);

        assertEquals(7, result.getNumerator());
        assertEquals(10, result.getDenominator());
    }

    @Test
    public void canAddNegativeFraction() {
        Fraction first = new Fraction(-5, 13);
        Fraction second = new Fraction(-7, 11);
        Fraction result = first.add(second);

        assertEquals(- 5 * 11 - 7 * 13, result.getNumerator());
        assertEquals(13 * 11, result.getDenominator());
    }

    @Test
    public void canSubtractPositiveFraction() {
        Fraction first = new Fraction(2,7);
        Fraction second = new Fraction(3,8);
        Fraction result = first.subtract(second);

        assertEquals(2 * 8 - 3 * 7, result.getNumerator());
        assertEquals(7 * 8, result.getDenominator());
    }

    @Test
    public void canSubtractNegativeFraction() {
        Fraction first = new Fraction(-2,7);
        Fraction second = new Fraction(-3,8);
        Fraction result = first.subtract(second);

        assertEquals(- 2 * 8 + 3 * 7, result.getNumerator());
        assertEquals(7 * 8, result.getDenominator());
    }

    @Test
    public void canMultiplyPositiveFraction() {
        Fraction first = new Fraction(5, 6);
        Fraction second = new Fraction(5, 7);
        Fraction result = first.multiply(second);

        assertEquals(5 * 5, result.getNumerator());
        assertEquals(6 * 7, result.getDenominator());
    }

    @Test
    public void canMultiplyNegativeFraction() {
        Fraction first = new Fraction(-19, 33);
        Fraction second = new Fraction(-2, 7);
        Fraction result = first.multiply(second);

        assertEquals(19 * 2, result.getNumerator());
        assertEquals(33 * 7, result.getDenominator());
    }

    @Test
    public void canMultiplyZeroFraction() {
        Fraction first = new Fraction(0, 33);
        Fraction second = new Fraction(-2, 7);
        Fraction result = first.multiply(second);

        assertEquals(0, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    public void canDividePositiveFraction() {
        Fraction first = new Fraction(3, 8);
        Fraction second = new Fraction(5, 9);
        Fraction result = first.divide(second);

        assertEquals(3 * 9, result.getNumerator());
        assertEquals(5 * 8, result.getDenominator());
    }

    @Test
    public void canDivideNegativeFraction() {
        Fraction first = new Fraction(-1, 3);
        Fraction second = new Fraction(5, 14);
        Fraction result = first.divide(second);

        assertEquals(- 1 * 14, result.getNumerator());
        assertEquals(3 * 5, result.getDenominator());
    }

    @Test (expected=IllegalArgumentException.class)
    public void canDivideZeroFraction() {
        Fraction first = new Fraction(3, 5);
        Fraction second = new Fraction(0, 1);
        Fraction result = first.divide(second);
    }
}
