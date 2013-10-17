package ru.unn.agile.temperatureConverter;

public class Converter {
    private Scale scaleFrom;
    private Scale scaleTo;

    public Converter(Scale scaleFrom, Scale scaleTo) {
        this.scaleFrom = scaleFrom;
        this.scaleTo = scaleTo;
    }

    public double leftToRight(double value) {
        return scaleTo.scaleForward(scaleFrom.scaleBackward(value));
    }

    public double rightToLeft(double value) {
        return scaleFrom.scaleForward(scaleTo.scaleBackward(value));
    }
}