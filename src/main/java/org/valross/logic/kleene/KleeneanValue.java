package org.valross.logic.kleene;

import org.valross.constantine.Constant;
import org.valross.logic.Value;

public enum KleeneanValue implements Value, Value.EnumBasedValue, Constant.UnitConstant {

    TRUE,
    UNKNOWN,
    FALSE;

    @Override
    public KleeneanLogic getLogic() {
        return KleeneanLogic.LOGIC;
    }

    @Override
    public KleeneanValue not() {
        return switch (this) {
            case TRUE -> FALSE;
            case FALSE -> TRUE;
            case UNKNOWN -> UNKNOWN;
        };
    }

    @Override
    public Value and(Value other) {
        final KleeneanValue theirs = this.getLogic().convert(other);
        return switch (this) {
            case TRUE -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> FALSE;
            };
            case UNKNOWN -> switch (theirs) {
                case TRUE, UNKNOWN -> UNKNOWN;
                case FALSE -> FALSE;
            };
            case FALSE -> FALSE;
        };
    }

    @Override
    public Value or(Value other) {
        final KleeneanValue theirs = this.getLogic().convert(other);
        return switch (this) {
            case TRUE -> TRUE;
            case UNKNOWN -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN, FALSE -> UNKNOWN;
            };
            case FALSE -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> FALSE;
            };
        };
    }

    @Override
    public Value xor(Value other) {
        final KleeneanValue theirs = this.getLogic().convert(other);
        return switch (this) {
            case TRUE -> switch (theirs) {
                case TRUE -> FALSE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> TRUE;
            };
            case UNKNOWN -> UNKNOWN;
            case FALSE -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> FALSE;
            };
        };
    }

    @Override
    public Value implies(Value other) {
        final KleeneanValue theirs = this.getLogic().convert(other);
        return switch (this) {
            case TRUE -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> FALSE;
            };
            case UNKNOWN -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN, FALSE -> UNKNOWN;
            };
            case FALSE -> TRUE;
        };
    }

    @Override
    public Value equals(Value other) {

        final KleeneanValue theirs = this.getLogic().convert(other);
        return switch (this) {
            case TRUE -> switch (theirs) {
                case TRUE -> TRUE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> FALSE;
            };
            case UNKNOWN -> UNKNOWN;
            case FALSE -> switch (theirs) {
                case TRUE -> FALSE;
                case UNKNOWN -> UNKNOWN;
                case FALSE -> TRUE;
            };
        };
    }

    @Override
    public int intValue() {
        return switch (this) {
            case TRUE -> 1;
            case UNKNOWN -> 0;
            case FALSE -> -1;
        };
    }

    @Override
    public float floatValue() {
        return this.intValue();
    }

    @Override
    public boolean booleanValue() {
        return this != FALSE;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
