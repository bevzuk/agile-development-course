package ru.unn.agile.calculating;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    @Test
    public void emptyStringGivesZero() {
        double res = StringCalculator.calculate("");
        assertEquals(0.0, res, 1e-10);
    }

    @Test
    public void oneNumberGivesNumber() {
        double res = StringCalculator.calculate("5");
        assertEquals(5.0, res, 1e-10);
    }

    @Test
    public void oneRealNumberGivesRealNumber() {
        double res = StringCalculator.calculate("5.7");
        assertEquals(5.7, res, 1e-10);
    }

    @Test
    public void sumGivesSum() {
        double res = StringCalculator.calculate("5+5");
        assertEquals(5.0+5, res, 1e-10);
    }

    @Test
    public void wrongSymbolsGivesException() {
        try {
            StringCalculator.calculate("5+a");
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Undefined symbol in expression", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type");
        }
    }

    @Test
    public void sumWithSpacesGivesSum() {
        double res = StringCalculator.calculate("5  +5  ");
        assertEquals(5.0+5, res, 1e-10);
    }

    @Test
    public void sumWithParensGivesSum() {
        double res = StringCalculator.calculate("2+(5+5)");
        assertEquals(2.0+(5+5), res, 1e-10);
    }

    @Test
    public void checkOperationPriorsWithParens() {
        double res = StringCalculator.calculate(" 2 - (5+5)");
        assertEquals(2.0-(5+5), res, 1e-10);
    }

    @Test
    public void checkMultiply() {
        double res = StringCalculator.calculate(" 2 * (5+5)");
        assertEquals(2.0*(5+5), res, 1e-10);
    }

    @Test
    public void checkDivision() {
        double res = StringCalculator.calculate(" 2 / (5+5*7)");
        assertEquals(2.0/(5+5*7), res, 1e-10);
    }

    @Test
    public void wrongParensGivesException() {
        try {
            StringCalculator.calculate("5+5)");
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong parens in expression", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type");
        }
    }

    @Test
    public void checkComplexExpression() {
        double res = StringCalculator.calculate("(1.1-2*7)/19+1+2*(2+2/2)");
        assertEquals((1.1-2*7)/19+1+2*(2+2/2), res, 1e-10);
    }

    @Test
    public void tooFewOpsGivesException() {
        try {
            StringCalculator.calculate("5 5");
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Not enough operators in expression", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type");
        }
    }

    @Test
    public void opInBeginGivesException() {
        try {
            StringCalculator.calculate("+5 5");
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong operator position in expression", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type");
        }
    }

    @Test
    public void opInEndGivesException() {
        try {
            StringCalculator.calculate("5 5 + ");
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong operator position in expression", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type");
        }
    }

    @Test
    public void wrongOpGivesException() {
        try {
            StringCalculator.calculate("5 6 + * 5 ");
            fail("Exception must be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong operator position in expression", e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type");
        }
    }

}
