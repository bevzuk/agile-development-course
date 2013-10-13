package ru.unn.agile.currencyConverter;

//used standart format.  Look at http://www.cbr.ru/scripts/XML_daily.asp
public class Currency {
    public final int numCode;
    public final String charCode;
    public final String name;
    public final int nominal;
    public final double value;

    public Currency(int numCode, String charCode, String name, int nominal, double value){
        ConstructorArgumentChecks(charCode, nominal, value);

        this.numCode = numCode;
        this.charCode = charCode;
        this.name = name;
        this.nominal = nominal;
        this.value = value;
    }

    private final void ConstructorArgumentChecks(String charCode, int nominal, double value){
        if(charCode == null){
            throw new IllegalArgumentException("Currency's charCode can't be null.");
        }

        if(nominal <= 0){
            throw new IllegalArgumentException("Nominal must be positive integer.");
        }

        if(value <= 0){
            throw new IllegalArgumentException("Value must be positive integer.");
        }
    }

    public final boolean isEqual(Currency compareCurrency){
        if(compareCurrency == null){
            return false;
        }

        return this.numCode == compareCurrency.numCode && this.charCode.equals(compareCurrency.charCode);
    }
}
