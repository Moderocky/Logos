package org.valross.logic;

import org.valross.constantine.Constant;

/// # Value
///
/// Represents a value in a logic.
/// A value can be expressed as a number of some kind.
/// A value can be mathematically-compared to other values (typically from the same logic).
///
/// Operators in this class should be computed mathematically rather than semantically,
/// since they may operate on things *similar to* logical numbers but not of the same type.
///
public interface Value extends Constant {

    Logic<? extends Value> getLogic();

    Value not();

    Value and(Value other);

    Value or(Value other);

    default Value xor(Value other) {
        return this.equals(other).not();
    }

    Value implies(Value other);

    Value equals(Value other);

    int intValue();

    float floatValue();

    boolean booleanValue();

    default double doubleValue() {
        return this.floatValue();
    }

    default long longValue() {
        return this.intValue();
    }

    default short shortValue() {
        return (short) this.intValue();
    }

    default byte byteValue() {
        return (byte) this.intValue();
    }

    interface IntegerBasedValue extends Value, Comparable<Value> {

        @Override
        default float floatValue() {
            return this.intValue();
        }

        @Override
        default int compareTo(Value other) {
            return Integer.compare(this.intValue(), other.intValue());
        }

    }

    interface FloatBasedValue extends Value, Comparable<Value> {

        @Override
        default int intValue() {
            return (int) this.floatValue();
        }

        @Override
        default int compareTo(Value other) {
            return Float.compare(this.floatValue(), other.floatValue());
        }

    }

    interface EnumBasedValue extends Value {

    }

    /// Something that has its numerical values in an inclusive range of zero (falsity) to one (truth).
    /// This is used for the purposes of guess-conversion.
    interface RangeZeroOne extends Value {}

}
