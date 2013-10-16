package ru.unn.agile.areaConverter;

public class AreaConverter {
    private double current;

    public AreaConverter() {

    }

    public AreaConverter(double metre) {
        if (metre > 0.0)
            this.current = metre;
        else
            this.current = 0.0;
    }

    public void setCurrentInMetre(double currentInMetre) {
        if (currentInMetre > 0.0)
            this.current = currentInMetre;
        else
            this.current = 0.0;
    }

    public double getCurrentInMetre() {
        return current;
    }

    public void setCurrentInHectare(double currentInHectare) {
        if (currentInHectare > 0.0)
            this.current = currentInHectare * 10000.0;
        else
            this.current = 0.0;
    }

    public double getCurrentInHectare() {
        return current / 10000.0;
    }

    public void setCurrentCentimetre(double currentInCentimetre) {
        if (currentInCentimetre > 0.0)
            this.current = currentInCentimetre / 10000.0;
        else
            this.current = 0.0;
    }

    public double getCurrentICentimetre() {
        return current * 10000.0;
    }

    public void setCurrentInYard(double currentInYard) {
        if (currentInYard > 0.0)
            this.current = currentInYard * 0.83612736;
        else
            this.current =  0.0;
    }

    public double getCurrentInYard() {
        return current * 1.195990;
    }
}