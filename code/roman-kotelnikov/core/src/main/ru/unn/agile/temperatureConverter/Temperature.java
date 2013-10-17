package ru.unn.agile.temperatureConverter;

/**
 * Created with IntelliJ IDEA.
 * User: zak
 * Date: 17.10.13
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
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

    public AvailableScales getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return scale.toString(current);
    }
}
