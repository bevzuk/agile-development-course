package ru.unn.agile.converter;

public class ConverterOfLenght {
    private double valueInMeter = -1;
    double factorKilometerToMeter = 1000;
    double factorInchToMeter = 2.54 / 100;

    public double setValueFromMeter(double input){
        if ((input < 0)||(input >= Double.MAX_VALUE ))
            throw new IllegalArgumentException();
        return valueInMeter = input;
    }
    public double setValueFromKilometer(double input){
        if ((input < 0)||(input >= Double.MAX_VALUE / factorKilometerToMeter))
            throw new IllegalArgumentException();
        return valueInMeter = input * factorKilometerToMeter;
    }
    public double setValueFromInch(double input){
        if ((input < 0)||(input * factorInchToMeter >= Double.MAX_VALUE))
            throw new IllegalArgumentException();
        return valueInMeter = input * factorInchToMeter;
    }
    public double convertToMeter(){
        if (valueInMeter == -1)
           throw new IllegalArgumentException();
        return valueInMeter;
    }
    public double convertToKilometer(){
        if (valueInMeter == -1)
            throw new IllegalArgumentException();
        return valueInMeter / factorKilometerToMeter;
    }
    public double convertToInch(){
        if ((valueInMeter == -1)||(valueInMeter >= Double.MAX_VALUE / factorInchToMeter))
            throw new IllegalArgumentException();
        return valueInMeter / factorInchToMeter;
    }
}
