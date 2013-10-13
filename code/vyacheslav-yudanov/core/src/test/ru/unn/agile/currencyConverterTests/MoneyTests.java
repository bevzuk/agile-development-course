package ru.unn.agile.currencyConverterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ru.unn.agile.currencyConverter.*;

import static ru.unn.agile.currencyConverter.ConstantCurrencyProvider.*;
import static ru.unn.agile.currencyConverterTests.TestConstants.doubleEpsilon;

public class MoneyTests {
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

        Assert.assertTrue(cash.isInCurrency(usd));
        Assert.assertEquals(1.0, cash.getMoneyAmount(), doubleEpsilon);
    }

    @Test
    public void isConversionRubToCnyCorrect(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];
        Currency cny = actual_currencies[Indexes.CNY.toInt()];
        Money cash = new Money(rub, 52.6499);

        cash.convertToCurrency(cny);

        Assert.assertTrue(cash.isInCurrency(cny));
        Assert.assertEquals(10.0, cash.getMoneyAmount(), doubleEpsilon);
    }

    @Test
    public void isConversionEurToInrCorrect(){
        Currency eur = actual_currencies[Indexes.EUR.toInt()];
        Currency inr = actual_currencies[Indexes.INR.toInt()];
        Money cash = new Money(eur, 10);

        cash.convertToCurrency(inr);

        Assert.assertTrue(cash.isInCurrency(inr));
        double right_answer = 10 * (inr.nominal/inr.value) * (eur.value/eur.nominal);
        Assert.assertEquals(right_answer, cash.getMoneyAmount(), doubleEpsilon);
    }

    @Test
    public void isConversionInrToInrCorrect(){
        Currency inr = actual_currencies[Indexes.INR.toInt()];
        Money cash = new Money(inr, 10);

        cash.convertToCurrency(inr);

        Assert.assertTrue(cash.isInCurrency(inr));
        double right_answer = 10 * (inr.nominal/inr.value) * (inr.value/inr.nominal);
        Assert.assertEquals(right_answer, cash.getMoneyAmount(), doubleEpsilon);
    }

    @Test
    public void moneyIsInCurrencySameCurrencyTest(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];

        Money cash = new Money(rub, 1);

        Assert.assertTrue(cash.isInCurrency(rub));
    }

    @Test
    public void moneyIsInCurrencyDifferentCurrenciesTest(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];
        Currency usd = actual_currencies[Indexes.USD.toInt()];

        Money cash = new Money(rub, 1);

        Assert.assertFalse(cash.isInCurrency(usd));
    }

    @Test
    public void moneyIsInCurrencyNullArgumentTest(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];

        Money cash = new Money(rub, 1);

        Assert.assertFalse(cash.isInCurrency(null));
    }

}
