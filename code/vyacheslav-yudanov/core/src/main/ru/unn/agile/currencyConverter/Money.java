package ru.unn.agile.currencyConverter;

public class Money {
    private final Currency currency;
    private double moneyCount;

    public Money(Currency currency, double moneyCount){
        this.currency = currency;
        this.moneyCount = moneyCount;
    }

    public Currency getCurrency(){
        return currency;
    }

    public double getMoneyCount(){
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount){
        this.moneyCount = moneyCount;
    }
}
