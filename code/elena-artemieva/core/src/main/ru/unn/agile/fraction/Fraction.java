package ru.unn.agile.fraction;

public class Fraction {

    private int m_numerator;
    private int m_denominator;

    Fraction(int numerator, int denominator) {

        m_numerator = numerator;
        m_denominator = denominator;

        checkDenominatorZero();
        checkDenominatorNegative();
        reduce();
    }

    private void checkDenominatorZero() {

        if(m_denominator == 0)
        {
            m_numerator = 0;
            m_denominator = 1;
        }
    }

    private void checkDenominatorNegative() {

        if (m_denominator < 0)
        {
            m_numerator = -m_numerator;
            m_denominator = -m_denominator;
        }
    }

    private void reduce() {

        int greatestCommonDivisor = GreatestCommonDivisor.calculate(m_numerator, m_denominator);

        m_numerator /= greatestCommonDivisor;
        m_denominator /= greatestCommonDivisor;
    }

    public static Fraction parse(String input) {

        String[] part = input.split("/");

        int numerator = Integer.parseInt(part[0]);
        int denominator = 1;

        if (part.length > 1)
        {
            denominator = Integer.parseInt(part[1]);
        }

        return new Fraction(numerator, denominator);
    }

    public static Boolean tryParse(String input)
    {
        try
        {
            parse(input);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public Fraction add(Fraction other) {

        return new Fraction(this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
    }

    public Fraction subtract(Fraction other) {

        return new Fraction(this.getNumerator() * other.getDenominator() - other.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
    }

    public Fraction multiply(Fraction other) {

        return new Fraction(this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator());
    }

    public Fraction divide(Fraction other) {

        return new Fraction(this.getNumerator() * other.getDenominator(), this.getDenominator() * other.getNumerator());
    }

    public int getNumerator() {

        return m_numerator;
    }

    public int getDenominator() {

        return m_denominator;
    }

    public String toString() {

        return String.format("%d/%d", getNumerator(), getDenominator());
    }
}
