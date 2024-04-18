package org.valross.logic.lukasiewicz;

import org.valross.constantine.RecordConstant;
import org.valross.logic.Value;

public interface LukValue extends Value.FloatBasedValue, Value.RangeZeroOne, RecordConstant {

    @Override
    LukasiewiczLogic getLogic();

    @Override
    default LukValue not() {
        return this.getLogic().convert(1 - this.floatValue());
    }

    @Override
    default LukValue and(Value other) {
        return this.getLogic().convert(Math.min(this.floatValue(), other.floatValue()));
    }

    @Override
    default LukValue or(Value other) {
        return this.getLogic().convert(Math.max(this.floatValue(), other.floatValue()));
    }

    @Override
    default LukValue implies(Value other) {
        return this.getLogic().convert(Math.min(1, 1 - this.floatValue() + other.floatValue()));
    }

    @Override
    default LukValue equals(Value other) {
        return this.getLogic().convert(1 - Math.abs(this.floatValue() - other.floatValue()));
    }

    @Override
    default boolean booleanValue() {
        return this.floatValue() > 0;
    }

}
