package ru.unn.agile.currencyConverter;

public class Money {
    private Currency currency;
    private double moneyCount;

    public Money(Currency currency, double moneyCount){
        this.currency = currency;
        this.moneyCount = moneyCount;
    }

    public Currency getCurrency(){
        return currency;
    }

    private void setCurrency(Currency newCurrency){
        this.currency = newCurrency;
    }

    public double getMoneyCount(){
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount){
        this.moneyCount = moneyCount;
    }

    public void convertToCurrency(Currency new_currency){
        double new_money_count = getMoneyCount() * (new_currency.nominal/new_currency.value) * (currency.value/currency.nominal);
        setMoneyCount(new_money_count);
        setCurrency(new_currency);
    }
}
