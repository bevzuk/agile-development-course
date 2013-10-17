package ru.unn.agile.temperatureConverter;

public class Converter {
    public static Temperature convert(Temperature from, AvailableScales scale) {
        if(from == null)
            throw new IllegalArgumentException("Temperature cannot be null");
        if(scale == null)
            throw new IllegalArgumentException("Scale cannot be null");

        double inputInCelsium = from.getScale().scaleFrom(from.getCurrent());
        return new Temperature(scale.scaleTo(inputInCelsium), scale);
    }
}