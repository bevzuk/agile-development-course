package ru.unn.agile.currencyConverter;

//used standart format.  Look at http://www.cbr.ru/scripts/XML_daily.asp
public class Currency {
    public final int numCode;
    public final int charCode;
    public final String name;
    public final int nominal;
    public final int value;

    public Currency(int numCode, int numCode1, int charCode, String name, int nominal, int value){
        this.numCode = numCode;
        this.charCode = charCode;
        this.name = name;
        this.nominal = nominal;
        this.value = value;
    }
}
