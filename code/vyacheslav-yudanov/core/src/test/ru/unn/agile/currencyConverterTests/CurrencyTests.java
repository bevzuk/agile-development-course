package ru.unn.agile.currencyConverterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ru.unn.agile.currencyConverter.*;

import static ru.unn.agile.currencyConverter.ConstantCurrencyProvider.*;

public class CurrencyTests {
    Currency[] currencies;

    @Before
    public void init(){
        ICurrencyProvider provider = new ConstantCurrencyProvider();
        currencies = provider.getActualCurrencyCourse();
    }

    @Test
    public void currencyIsEqualCompareSameCurrenciesTest(){
        Assert.assertTrue(currencies[Indexes.RUB.toInt()].isEqual(currencies[Indexes.RUB.toInt()]));
    }

    @Test
    public void currencyIsEqualCompareDifferentCurrenciesTest(){
        Assert.assertFalse(currencies[Indexes.RUB.toInt()].isEqual(currencies[Indexes.USD.toInt()]));
    }

    @Test
    public void currencyIsEqualFalseOnNullArgument(){
        Assert.assertFalse(currencies[Indexes.RUB.toInt()].isEqual(null));
    }
}
