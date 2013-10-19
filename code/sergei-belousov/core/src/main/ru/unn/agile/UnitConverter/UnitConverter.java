package ru.unn.agile.UnitConverter;

public class UnitConverter {
    private UnitConvertTable unitConvertTable;

    public UnitConverter() {
        unitConvertTable = new UnitConvertTable();
    }

    public boolean isEmpty() {
        return unitConvertTable.isEmpty();
    }

    public void addPair(String from, String to, double factor) {
        unitConvertTable.addPair(new UnitKey(from, to), factor);
    }

    private UnitKey getKeyFromString(String fromToFormatString) {
        String[] tokens = fromToFormatString.split("-");
        if(tokens.length == 1) {
            return null;
        }
        return new UnitKey(tokens[0], tokens[1]);
    }

    private Unit getFactor(String fromToFormatString) throws UnitConvertTableException {
        if(fromToFormatString.equals("")) {
            throw new UnitConvertTableException("format string empty.");
        }
        try {
            return unitConvertTable.getFactor(getKeyFromString(fromToFormatString));
        }catch(UnitConvertTableException e)
        {
            throw e;
        }
    }

    public Unit convert(String fromToFormatString, Unit value) throws UnitConvertTableException {
        try {
            Unit result = getFactor(fromToFormatString);
            if(!result.isEqualType(value)){
                throw new UnitConvertTableException("can not be converted, since the goal is not as expected.");
            }
            else{
                result.MultiplyByScalar(value.getValue());
                return result;
            }
        } catch (UnitConvertTableException e){
            throw e;
        }
    }
}
