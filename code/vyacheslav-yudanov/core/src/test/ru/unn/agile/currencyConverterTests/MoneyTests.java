package ru.unn.agile.currencyConverterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ru.unn.agile.currencyConverter.*;

import static ru.unn.agile.currencyConverter.ConstantCurrencyProvider.*;

public class MoneyTests {
    private final double epsilon = 0.00001;
    private Currency[] actual_currencies;

    @Before
    public void init(){
        ICurrencyProvider provider = new ConstantCurrencyProvider();
        actual_currencies = provider.getActualCurrencyCourse();
    }

    @Test
    public void isConversionRubToUsdCorrect(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];
        Currency usd = actual_currencies[Indexes.USD.toInt()];
        Money cash = new Money(rub, 32.2133);

        cash.convertToCurrency(usd);

        Assert.assertTrue(cash.getCurrency().isEqual(usd));
        Assert.assertEquals(1.0, cash.getMoneyAmount(), epsilon);
    }

    @Test
    public void isConversionRubToCnyCorrect(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];
        Currency cny = actual_currencies[Indexes.CNY.toInt()];
        Money cash = new Money(rub, 52.6499);

        cash.convertToCurrency(cny);

        Assert.assertTrue(cash.getCurrency().isEqual(cny));
        Assert.assertEquals(10.0, cash.getMoneyAmount(), epsilon);
    }

    @Test
    public void isConversionEurToInrCorrect(){
        Currency eur = actual_currencies[Indexes.EUR.toInt()];
        Currency inr = actual_currencies[Indexes.INR.toInt()];
        Money cash = new Money(eur, 10);

        cash.convertToCurrency(inr);

        Assert.assertTrue(cash.getCurrency().isEqual(inr));
        double right_answer = 10 * (inr.nominal/inr.value) * (eur.value/eur.nominal);
        Assert.assertEquals(right_answer, cash.getMoneyAmount(), epsilon);
    }

    @Test
    public void isConversionInrToInrCorrect(){
        Currency inr = actual_currencies[Indexes.INR.toInt()];
        Money cash = new Money(inr, 10);

        cash.convertToCurrency(inr);

        Assert.assertTrue(cash.getCurrency().isEqual(inr));
        double right_answer = 10 * (inr.nominal/inr.value) * (inr.value/inr.nominal);
        Assert.assertEquals(right_answer, cash.getMoneyAmount(), epsilon);
    }
}
