package ru.unn.agile.calculating;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    private final double calcError = 1e-10;
    private final String wrongOpsExceptionText = "Wrong operator position in expression";
    private final String wrongParensExceptionText = "Wrong parens in expression";
    private final String fewOpsExceptionText = "Not enough operators in expression";
    private final String notAllowedSymbolsExceptionText = "Undefined symbol in expression";

    @Test
    public void emptyStringGivesZero() {
        double res = StringCalculator.calculate("");
        assertEquals(0.0, res, calcError);
    }

    @Test
    public void oneNumberGivesNumber() {
        double res = StringCalculator.calculate("5");
        assertEquals(5.0, res, calcError);
    }

    @Test
    public void oneRealNumberGivesRealNumber() {
        double res = StringCalculator.calculate("5.7");
        assertEquals(5.7, res, calcError);
    }

    @Test
    public void sumGivesSum() {
        double res = StringCalculator.calculate("5+5");
        assertEquals(5.0 + 5, res, calcError);
    }

    @Test
    public void wrongSymbolsGivesException() {
        checkExprGivesException("5+a", notAllowedSymbolsExceptionText);
    }

    @Test
    public void sumWithSpacesGivesSum() {
        double res = StringCalculator.calculate("5  +5  ");
        assertEquals(5.0 + 5, res, calcError);
    }

    @Test
    public void sumWithParensGivesSum() {
        double res = StringCalculator.calculate("2+(5+5)");
        assertEquals(2.0 + (5 + 5), res, calcError);
    }

    @Test
    public void checkOperationPriorsWithParens() {
        double res = StringCalculator.calculate(" 2 - (5+5)");
        assertEquals(2.0 - (5 + 5), res, calcError);
    }

    @Test
    public void checkMultiply() {
        double res = StringCalculator.calculate(" 2 * (5+5)");
        assertEquals(2.0 * (5 + 5), res, calcError);
    }

    @Test
    public void checkDivision() {
        double res = StringCalculator.calculate(" 2 / (5+5*7)");
        assertEquals(2.0 / (5 + 5 * 7), res, calcError);
    }

    @Test
    public void wrongParensGivesException() {
        checkExprGivesException("5+5)", wrongParensExceptionText);
    }

    @Test
    public void checkComplexExpression() {
        double res = StringCalculator.calculate("(1.1-2*7)/19+1+2*(2+2/2)");
        assertEquals((1.1 - 2 * 7) / 19 + 1 + 2 * (2 + 2 / 2), res, calcError);
    }

    @Test
    public void tooFewOpsGivesException() {
        checkExprGivesException("5 5", fewOpsExceptionText);

    }

    @Test
    public void opInBeginGivesException() {
        checkExprGivesException("+5 5", wrongOpsExceptionText);
    }

    @Test
    public void opInEndGivesException() {
        checkExprGivesException("5 5 + ", wrongOpsExceptionText);
    }

    @Test
    public void wrongOpGivesException() {
        checkExprGivesException("5 6 + * 5 ", wrongOpsExceptionText);
    }

    @Test
    public void checkOpsPriorWithDivisionAndMinus() {
        double res = StringCalculator.calculate("1/1-1");
        assertEquals(1.0 / 1 - 1, res, calcError);
    }

    @Test
    public void checkOpsPriorWithDivisionAndMinusAndParens() {
        double res = StringCalculator.calculate("2/(2-2)");
        assertEquals(2.0 / (2 - 2), res, calcError);
    }

    @Test
    public void checkOneOpGiveException() {
        checkExprGivesException("+", wrongOpsExceptionText);
    }

    @Test
    public void checkUnaryMinusIsNotAllowed() {
        checkExprGivesException("-1", wrongOpsExceptionText);
    }

    @Test
    public void checkOpsPriorParseCorrectly() {
        double res = StringCalculator.calculate("2/1 + 2*8 - (2.7+3)");
        assertEquals(2.0 / 1 + 2 * 8 - (2.7 + 3), res, calcError);
    }

    @Test
    public void checkDivisionIsLeftAssoc() {
        double res = StringCalculator.calculate("2/2/2/2");
        assertEquals(((2.0 / 2) / 2) / 2, res, calcError);
    }

    @Test
    public void checkMinusIsLeftAssoc() {
        double res = StringCalculator.calculate("2-2-2-2");
        assertEquals(((2.0 - 2) - 2) - 2, res, calcError);
    }

    private void checkExprGivesException(String expr, String exceptionText) {
        try {
            StringCalculator.calculate(expr);
            fail("Exception must be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals(exceptionText, e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception type.");
        }
    }
}
