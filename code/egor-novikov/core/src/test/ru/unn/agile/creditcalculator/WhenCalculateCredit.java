package ru.unn.agile.creditcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WhenCalculateCredit
{
    @Test
    public void incorrectAmountArgumentThrowExceptionInConstructor()
    {
        try
        {
            new CreditCalculator(0, 24, 10);
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("amount argument value exception", ex.getMessage());
        }
    }

    @Test
    public void incorrectMonthsCountArgumentThrowExceptionInConstructor()
    {
        try
        {
            new CreditCalculator(180000, 0, 10);
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("monthsCount argument value exception", ex.getMessage());
        }
    }

    @Test
    public void incorrectPercentArgumentThrowExceptionInConstructor()
    {
        try
        {
            new CreditCalculator(180000, 24, -10.0);
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("percent argument value exception", ex.getMessage());
        }
    }

    @Test
    public void correctData1WorksProperlyInGetAnnuityMonthPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(120000, 12, 24);
        assertDoubles(11347.15, creditCalculator.getAnnuityMonthPayment());
    }

    @Test
    public void correctData2WorksProperlyInGetAnnuityMonthPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(100000, 36, 10);
        assertDoubles(3226.72, creditCalculator.getAnnuityMonthPayment());
    }

    @Test
    public void correctData3WorksProperlyInGetAnnuityMonthPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(400000, 11, 7);
        assertDoubles(37648.70, creditCalculator.getAnnuityMonthPayment());
    }

    @Test
    public void correctData1WorksProperlyInGetDifferentiatedMonthPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(120000, 12, 24);
        assertDoubles(11600.00, creditCalculator.getDifferentiatedMonthPayment(5));
    }

    @Test
    public void correctData2WorksProperlyInGetDifferentiatedMonthPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(120000, 12, 24);
        assertDoubles(11000.00, creditCalculator.getDifferentiatedMonthPayment(8));
    }

    @Test
    public void correctData3WorksProperlyInGetDifferentiatedMonthPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(170000, 6, 5);
        assertDoubles(28805.56, creditCalculator.getDifferentiatedMonthPayment(3));
    }

    @Test
    public void incorrectMonthNumberArgument1InGetDifferentiatedMonthPaymentThrowException()
    {
        try
        {
            CreditCalculator creditCalculator = new CreditCalculator(180000, 24, 16);
            creditCalculator.getDifferentiatedMonthPayment(0);
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("monthNumber argument value exception", ex.getMessage());
        }
    }

    @Test
    public void incorrectMonthNumberArgument2InGetDifferentiatedMonthPaymentThrowException()
    {
        try
        {
            CreditCalculator creditCalculator = new CreditCalculator(180000, 24, 16);
            creditCalculator.getDifferentiatedMonthPayment(24+1);
            fail();
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("monthNumber argument value exception", ex.getMessage());
        }
    }

    @Test
    public void correctData1WorksProperlyInGetAnnuityTotalPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(120000, 12, 24);
        assertDoubles(136165.82, creditCalculator.getAnnuityTotalPayment());
    }

    @Test
    public void correctData2WorksProperlyInGetAnnuityTotalPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(180000, 18, 10);
        assertDoubles(194584.94, creditCalculator.getAnnuityTotalPayment());
    }

    @Test
    public void correctData3WorksProperlyInGetAnnuityTotalPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(35000, 10, 15);
        assertDoubles(37451.08, creditCalculator.getAnnuityTotalPayment());
    }

    @Test
    public void correctData1WorksProperlyInGetDifferentiatedTotalPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(180000, 18, 10);
        assertDoubles(194250.00, creditCalculator.getDifferentiatedTotalPayment());
    }

    @Test
    public void correctData2WorksProperlyInGetDifferentiatedTotalPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(200000, 6, 5);
        assertDoubles(202916.67, creditCalculator.getDifferentiatedTotalPayment());
    }

    @Test
    public void correctData3WorksProperlyInGetDifferentiatedTotalPaymentMethod()
    {
        CreditCalculator creditCalculator = new CreditCalculator(150000, 9, 15);
        assertDoubles(159375.00, creditCalculator.getDifferentiatedTotalPayment());
    }



    private void assertDoubles(double expected, double input)
    {
        assertEquals(expected, input, 1.0);
    }
}
