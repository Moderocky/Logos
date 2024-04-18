package org.valross.logic.operator;

import org.valross.constantine.Constant;
import org.valross.logic.Value;

@FunctionalInterface
@SuppressWarnings("unchecked")
public interface Operator<Type extends Value> extends Value, Constant.UnitConstant {

    @Override
    default OperatorLogic<Type> getLogic() {
        return (OperatorLogic<Type>) OperatorLogic.LOGIC;
    }

    @Override
    default Operator<Type> not() {
        return this.getLogic().not(this);
    }

    @Override
    default Operator<Type> and(Value other) {
        return this.getLogic().and(this, (Operator<Type>) other);
    }

    @Override
    default Operator<Type> or(Value other) {
        return this.getLogic().or(this, (Operator<Type>) other);
    }

    @Override
    default Operator<Type> xor(Value other) {
        return this.getLogic().xor(this, (Operator<Type>) other);
    }

    @Override
    default Operator<Type> implies(Value other) {
        return this.getLogic().implies(this, (Operator<Type>) other);
    }

    @Override
    default Operator<Type> equals(Value other) {
        return this.getLogic().equals(this, (Operator<Type>) other);
    }

    @Override
    default int intValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    default float floatValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    default boolean booleanValue() {
        throw new UnsupportedOperationException();
    }

    Type evaluate(Type... propositions);

}
