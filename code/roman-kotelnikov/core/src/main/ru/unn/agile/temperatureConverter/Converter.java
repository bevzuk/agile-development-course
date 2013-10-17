package ru.unn.agile.temperatureConverter;

public class Converter {
    private AvailableScales scaleFrom;
    private AvailableScales scaleTo;

    public Converter(AvailableScales scaleFrom, AvailableScales scaleTo) {
        if(scaleFrom == null || scaleTo == null)
            throw new IllegalArgumentException("Scale cannot be null");

        this.scaleFrom = scaleFrom;
        this.scaleTo = scaleTo;
    }

    public double leftToRight(double value) {
        return scaleTo.scaleTo(scaleFrom.scaleFrom(value));
    }

    public double rightToLeft(double value) {
        return scaleFrom.scaleFrom(scaleTo.scaleTo(value));
    }
}