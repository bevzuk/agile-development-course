package ru.unn.agile.creditcalculator;

public class CreditCalculator
{
    private final double amount;

    private final int monthsCount;

    private final double percent;

    public double getAmount()
    {
        return amount;
    }

    public int getMonthsCount()
    {
        return monthsCount;
    }

    public double getPercent()
    {
        return percent;
    }

    public CreditCalculator(double amount, int monthsCount, double percent)
    {
        checkAmount(amount);
        checkMonthsCount(monthsCount);
        checkPercent(percent);

        this.amount = amount;
        this.monthsCount = monthsCount;
        this.percent = percent;
    }

    private void checkAmount(double amount)
    {
        if (amount <= 0.0)
            throw new IllegalArgumentException("amount argument value exception");
    }

    private void checkMonthsCount(double monthsCount)
    {
        if (monthsCount <= 0)
            throw new IllegalArgumentException("monthsCount argument value exception");
    }

    private void checkPercent(double percent)
    {
        if (percent < 0.0)
            throw new IllegalArgumentException("percent argument value exception");
    }

    private void checkMonthNumber(int monthNumber)
    {
        if (monthNumber <= 0 || monthNumber > getMonthsCount())
            throw new IllegalArgumentException("monthNumber argument value exception");
    }

    public double getAnnuityMonthPayment()
    {
        double interestRateCoefficient = getPercent()/1200.0;
        double annuityCoefficient = interestRateCoefficient*Math.pow(1 + interestRateCoefficient, getMonthsCount())
                                        /(Math.pow(1 + interestRateCoefficient, getMonthsCount()) - 1);
        return annuityCoefficient * getAmount();
    }

    public double getDifferentiatedMonthPayment(int monthNumber)
    {
        checkMonthNumber(monthNumber);
        double monthlyPrincipalPayment = getAmount() / getMonthsCount();
        return monthlyPrincipalPayment + (getAmount() - monthlyPrincipalPayment*(monthNumber-1)) * getPercent() / 1200.0;
    }

    public double getAnnuityTotalPayment()
    {
        return getMonthsCount() * getAnnuityMonthPayment();
    }

    public double getDifferentiatedTotalPayment()
    {
        double result = 0.0;
        for (int i=1; i<getMonthsCount()+1; i++)
            result += getDifferentiatedMonthPayment(i);
        return result;
    }
}
