package org.valross.logic.operator;

import org.valross.constantine.Constant;
import org.valross.constantine.RecordConstant;
import org.valross.logic.Logic;
import org.valross.logic.Value;

import java.lang.constant.Constable;
import java.util.function.Supplier;

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

record Wrapper<Type extends Value>(Supplier<String> printer, Operator<Type> operator)
    implements Operator<Type>, RecordConstant {

    Wrapper(String string, Operator<Type> operator) {
        this(() -> string, operator);
    }

    @Override
    public OperatorLogic<Type> getLogic() {
        return operator.getLogic();
    }

    @Override
    @SafeVarargs
    public final Type evaluate(Type... propositions) {
        return operator.evaluate(propositions);
    }

    @Override
    public Constable[] serial() throws Throwable {
        return RecordConstant.super.serial();
    }

    @Override
    public Class<?>[] canonicalParameters() {
        return RecordConstant.super.canonicalParameters();
    }

    @Override
    public String toString() {
        return printer.get();
    }

}
