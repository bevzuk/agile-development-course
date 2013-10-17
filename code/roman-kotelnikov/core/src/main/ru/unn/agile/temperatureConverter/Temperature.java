package ru.unn.agile.temperatureConverter;

public class Temperature {
    private double current;
    private AvailableScales scale;

    public Temperature(double current, AvailableScales scale)
    {
        if(scale == null)
            throw new IllegalArgumentException("Scale cannot be null");
        this.scale = scale;
        this.current = current;
    }

    public double getCurrent() {
        return current;
    }

    public AvailableScales getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return scale.toString(current);
    }
}
