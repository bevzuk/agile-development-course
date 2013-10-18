package ru.unn.agile.WeightConverter;

public class WeightConverter {
    private WeightConvertTable weightConvertTable;

    WeightConverter() {
        weightConvertTable = new WeightConvertTable();
    }

    public boolean isEmpty() {
        return weightConvertTable.isEmpty();
    }

    public void addPair(String from, String to, double factor) {
        weightConvertTable.addPair(new WeightKey(from, to), factor);
    }

    private WeightKey getKeyFromString(String fromToFormatString) {
        String[] tokens = fromToFormatString.split("-");
        if(tokens.length == 1) {
            return null;
        }
        return new WeightKey(tokens[0], tokens[1]);
    }

    private double getFactor(String fromToFormatString) throws WeightConvertTableException {
        if(fromToFormatString.equals("")) {
            return 0;
        }
        double factor = 0.;
        try {
            factor = weightConvertTable.getFactor(getKeyFromString(fromToFormatString));
        }catch(WeightConvertTableException e)
        {
            throw e;
        }
        return factor;
    }

    public double convert(String fromToFormatString, double value) throws WeightConvertTableException {
        double factor = 0.;
        try {
            factor = getFactor(fromToFormatString);
        } catch (WeightConvertTableException e){
            throw e;
        }
        return factor * value;
    }
}
