package ru.unn.agile.currencyConverterTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ru.unn.agile.currencyConverter.ConstantCurrencyProvider;
import ru.unn.agile.currencyConverter.ICurrencyProvider;

public class ConstantCurrencyProviderTest {
    private ICurrencyProvider provider;
    @Before
    void init()
    {
        provider = new ConstantCurrencyProvider();
    }

}
