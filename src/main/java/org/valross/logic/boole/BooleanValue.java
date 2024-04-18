package org.valross.logic.boole;

import org.valross.constantine.Constant;
import org.valross.logic.Value;

public enum BooleanValue implements Value, Value.RangeZeroOne, Constant.UnitConstant {

    TRUE,
    FALSE;

    @Override
    public BooleanLogic getLogic() {
        return BooleanLogic.LOGIC;
    }

    @Override
    public BooleanValue not() {
        return this == TRUE ? FALSE : TRUE;
    }

    @Override
    public Value and(Value other) {
        return this.booleanValue() && other.booleanValue() ? TRUE : FALSE;
    }

    @Override
    public Value or(Value other) {
        return this.booleanValue() || other.booleanValue() ? TRUE : FALSE;
    }

    @Override
    public Value xor(Value other) {
        return this.booleanValue() ^ other.booleanValue() ? TRUE : FALSE;
    }

    @Override
    public Value implies(Value other) {
        return this.booleanValue() ? other : TRUE;
    }

    @Override
    public Value equals(Value other) {
        return this.booleanValue() == other.booleanValue() ? TRUE : FALSE;
    }

    @Override
    public int intValue() {
        return this.ordinal();
    }

    @Override
    public float floatValue() {
        return this.intValue();
    }

    @Override
    public boolean booleanValue() {
        return this == TRUE;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
