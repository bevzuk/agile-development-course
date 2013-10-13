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
        if(moneyAmount >= 0){
            this.moneyAmount = moneyAmount;
        }
        else {
            throw new IllegalArgumentException("MoneyAmount must be non negative integer.");
        }
    }

    public void convertToCurrency(Currency newCurrency){
        double newMoneyCount = getMoneyAmount() * (newCurrency.nominal/newCurrency.value) * (currency.value/currency.nominal);
        setMoneyAmount(newMoneyCount);
        setCurrency(newCurrency);
    }

    public final boolean isInCurrency(final Currency checkCurrency) {
        return currency.isEqual(checkCurrency);
    }
}
