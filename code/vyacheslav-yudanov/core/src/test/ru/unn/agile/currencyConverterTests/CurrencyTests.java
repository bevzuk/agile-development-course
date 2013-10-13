package ru.unn.agile.currencyConverterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ru.unn.agile.currencyConverter.*;

import static ru.unn.agile.currencyConverter.ConstantCurrencyProvider.*;
import static ru.unn.agile.currencyConverterTests.TestConstants.doubleEpsilon;

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
    public void currencyIsEqualFalseOnNullArgumentTest(){
        Assert.assertFalse(currencies[Indexes.RUB.toInt()].isEqual(null));
    }

    @Test
    public void currencyConstructingCorrectTest(){
        Currency usd = new Currency(840, "USD", "Доллар США", 1, 32.2133);

        Assert.assertEquals(840, usd.numCode);
        Assert.assertEquals("USD", usd.charCode);
        Assert.assertEquals("Доллар США", usd.name);
        Assert.assertEquals(1, usd.nominal);
        Assert.assertEquals(32.2133, usd.value, doubleEpsilon);
    }

    @Test
    public void currencyConstructingThrowsExceptionOnNullCharCodeTest(){
        try {
            Currency usd = new Currency(840, null, "Доллар США", 1, 32.2133);
            Assert.fail("Exception wasn't throwed.");
        }
        catch (IllegalArgumentException ex){
            Assert.assertEquals("Currency's charCode can't be null.", ex.getMessage());
        }
        catch (Exception e){
            Assert.fail("Invalid exception type");
        }
    }

}
