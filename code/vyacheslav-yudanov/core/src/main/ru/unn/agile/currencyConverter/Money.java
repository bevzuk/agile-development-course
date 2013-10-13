package ru.unn.agile.currencyConverter;

public class Money {
    private Currency currency;
    private double moneyAmount;

    public Money(Currency currency, double moneyAmount){
        this.currency = currency;
        this.moneyAmount = moneyAmount;
    }

    public final Currency getCurrency(){
        return currency;
    }

    private void setCurrency(Currency newCurrency){
        this.currency = newCurrency;
    }

    public final double getMoneyAmount(){
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount){
        this.moneyAmount = moneyAmount;
    }

    public void convertToCurrency(Currency newCurrency){
        double new_money_count = getMoneyAmount() * (newCurrency.nominal/newCurrency.value) * (currency.value/currency.nominal);
        setMoneyAmount(new_money_count);
        setCurrency(newCurrency);
    }

    public final boolean isInCurrency(Currency checkCurrency) {
        return currency.isEqual(checkCurrency);
    }
}
