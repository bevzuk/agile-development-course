package ru.unn.agile.currencyConverter;


public class ConstantCurrencyProvider implements ICurrencyProvider {
    @Override
    public Currency[] getActualCurrencyCourse() {
        Currency[] test_currencies = new Currency[5];

        //For information about currency num codes look at http://www.cbr.ru/scripts/XML_daily.asp
        test_currencies[0] = new Currency(840, "USD", "Доллар США", 1, 32.2133);
        test_currencies[1] = new Currency(978, "EUR", "Евро", 1, 43.6039);
        test_currencies[2] = new Currency(356, "INR", "Индийских рупий", 100, 52.5203);
        test_currencies[3] = new Currency(156, "CNY", "Китайских юаней", 10, 52.6499);
        test_currencies[4] = new Currency(1, "RUB", "Рубль", 1, 1);

        return test_currencies;
    }

    public enum Indexes{
        USD, EUR, INR, CNY, RUB
    }
}
