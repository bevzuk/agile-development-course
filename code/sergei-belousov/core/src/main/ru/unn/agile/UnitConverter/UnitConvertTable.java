package ru.unn.agile.UnitConverter;

import java.util.HashMap;

public class UnitConvertTable {
    private HashMap<UnitKey, Unit> weightConvertTable;

    public UnitConvertTable() {
        weightConvertTable = new HashMap<UnitKey, Unit>();
    }

    public boolean isEmpty() {
        return weightConvertTable.isEmpty();
    }

    public void addPair(UnitKey pair, double factor) {
        weightConvertTable.put(pair, new Unit(pair.getTo(), factor));
        weightConvertTable.put(pair.reverse(), new Unit(pair.getFrom(), 1. / factor));
    }

    public Unit getFactor(UnitKey pair) throws UnitConvertTableException {
        if(!weightConvertTable.containsKey(pair)) {
            throw new UnitConvertTableException("key not found.");
        }
        else {
            return weightConvertTable.get(pair);
        }
    }
}
