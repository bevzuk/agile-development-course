package ru.unn.agile.currencyConverterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ru.unn.agile.currencyConverter.*;

import static ru.unn.agile.currencyConverter.ConstantCurrencyProvider.*;
import static ru.unn.agile.currencyConverterTests.TestConstants.doubleEpsilon;

public class CurrencyTests {
    Currency[] actual_currencies;

    @Before
    public void init(){
        ICurrencyProvider provider = new ConstantCurrencyProvider();
        actual_currencies = provider.getActualCurrencyCourse();
    }

    @Test
    public void currencyIsEqualCompareSameCurrenciesTest(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];

        Assert.assertTrue(rub.isEqual(rub));
    }

    @Test
    public void currencyIsEqualCompareDifferentCurrenciesTest(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];
        Currency usd = actual_currencies[Indexes.USD.toInt()];

        Assert.assertFalse(rub.isEqual(usd));
    }

    @Test
    public void currencyIsEqualFalseOnNullArgumentTest(){
        Currency rub = actual_currencies[Indexes.RUB.toInt()];

        Assert.assertFalse(rub.isEqual(null));
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
