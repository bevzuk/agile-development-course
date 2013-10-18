package ru.unn.agile.converter;


public class ConverterOfLenght {
    double factorMeterToMeter = 1;
    double factorKilometerToMeter = 1000;
    double factorInchToMeter = 2.54 / 100;
    double factorDecimeterToMeter = 0.1;
    double factorCentimeterToMeter = 0.01;
    double factorMillimeterToMeter = 0.001;
    double factorLeagueToMeter = 4828.032;
    double factorMileToMeter = 1609.344;
    double factorFurhlongToMeter = 201.16;
    double factorChainToMeter = 20.1168;
    double factorRodToMeter = 5.0292;
    double factorYardToMeter = 0.9144;

    private enum Unit {
        zero, meter, decimeter, centimeter, kilometer, millimeter, inch, league, mile, furhlong, chain, rod, yard;
    }

    private double calculateFactor(String inputUnit, String outputUnit){
        double factor = 1;
        Unit input = Unit.valueOf("zero");
        Unit output = Unit.valueOf("zero");
        input = Unit.valueOf(inputUnit);
        if (input.compareTo(Unit.valueOf("zero")) == 0)
            throw new IllegalArgumentException();
        output = Unit.valueOf(outputUnit);
        if (output.compareTo(Unit.valueOf("zero")) == 0)
            throw new IllegalArgumentException();

        switch (input)
        {
            case meter:
                factor *= factorMeterToMeter;
                break;
            case decimeter:
                factor *= factorDecimeterToMeter;
                break;
            case centimeter:
                factor *= factorCentimeterToMeter;
                break;
            case millimeter:
                factor *= factorMillimeterToMeter;
                break;
            case kilometer:
                factor *= factorKilometerToMeter;
                break;
            case inch:
                factor *= factorInchToMeter;
                break;
            case league:
                factor *= factorLeagueToMeter;
                break;
            case mile:
                factor *= factorMileToMeter;
                break;
            case furhlong:
                factor *= factorFurhlongToMeter;
                break;
            case chain:
                factor *= factorChainToMeter;
                break;
            case rod:
                factor *=factorRodToMeter;
                break;
            case yard:
                factor *= factorYardToMeter;
                break;
        }
        switch (output)
        {
            case meter:
                factor /= factorMeterToMeter;
                break;
            case decimeter:
                factor /= factorDecimeterToMeter;
                break;
            case centimeter:
                factor /= factorCentimeterToMeter;
                break;
            case millimeter:
                factor /= factorMillimeterToMeter;
                break;
            case kilometer:
                factor /= factorKilometerToMeter;
                break;
            case inch:
                factor /= factorInchToMeter;
                break;
            case league:
                factor /= factorLeagueToMeter;
                break;
            case mile:
                factor /= factorMileToMeter;
                break;
            case furhlong:
                factor /= factorFurhlongToMeter;
                break;
            case chain:
                factor /= factorChainToMeter;
                break;
            case rod:
                factor /=factorRodToMeter;
                break;
            case yard:
                factor /= factorYardToMeter;
                break;
        }
        return factor;
    }

    private boolean isCorrectInputValue(double inputValue, double factor){
        boolean isCorrect = true;
        if ((inputValue * factor >= Double.MAX_VALUE)||(inputValue * factor <= Double.MIN_NORMAL)||(inputValue < 0))
            isCorrect = false;
        return isCorrect;
    }

    public double convertLenght(String inputUnit, String outputUnit, double inputValue){
        double outputValue;
        double factor = calculateFactor(inputUnit, outputUnit);
        if (!isCorrectInputValue(inputValue, factor))
            throw new IllegalArgumentException();
        outputValue = inputValue * factor;
        return outputValue;
    }
}
