package org.valross.logic.operator;

import org.valross.logic.Logic;
import org.valross.logic.Value;
import org.valross.logic.boole.BooleanLogic;
import org.valross.logic.boole.BooleanValue;

@SuppressWarnings("unchecked")
public interface OperatorLogic<Type extends Value> extends Logic<Operator<Type>> {

    OperatorLogic<BooleanValue> LOGIC = of(BooleanLogic.LOGIC);

    static <Type extends Value, Target extends Logic<Type>> OperatorLogic<Type> of(Target logic) {
        //<editor-fold desc="Return localised values." defaultstate="collapsed">
        return new OperatorLogic<>() {
            @Override
            public Operator<Type> truth() {
                return _ -> logic.truth();
            }

            @Override
            public Operator<Type> falsity() {
                return _ -> logic.falsity();
            }

            @Override
            public Operator<Type> convert(Value value) {
                return _ -> logic.convert(value);
            }

            @Override
            public Operator<Type> convert(Number value) {
                return _ -> logic.convert(value);
            }

            @Override
            public Operator<Type> convert(boolean value) {
                return _ -> logic.convert(value);
            }
        };
        //</editor-fold>
    }

    default Operator<Type> input(int index) {
        return propositions -> propositions[index];
    }

    @Override
    default Operator<Type> truth() {
        return propositions -> propositions.length > 0 ? (Type) propositions[0].getLogic().truth() : null;
    }

    @Override
    default Operator<Type> falsity() {
        return propositions -> propositions.length > 0 ? (Type) propositions[0].getLogic().falsity() : null;
    }

    @Override
    default <Other extends Value> Operator<Type> convert(Other value) {
        throw new UnsupportedOperationException();
    }

    @Override
    default Operator<Type> convert(Number value) {
        throw new UnsupportedOperationException();
    }

    @Override
    default Operator<Type> convert(boolean value) {
        throw new UnsupportedOperationException();
    }

    @Override
    default Operator<Type> not(Operator<Type> value) {
        return propositions -> (Type) value.evaluate(propositions).not();
    }

    @Override
    default Operator<Type> and(Operator<Type> antecedent, Operator<Type> consequent) {
        return propositions -> (Type) antecedent.evaluate(propositions).and(consequent.evaluate(propositions));
    }

    @Override
    default Operator<Type> or(Operator<Type> antecedent, Operator<Type> consequent) {
        return propositions -> (Type) antecedent.evaluate(propositions).or(consequent.evaluate(propositions));
    }

    @Override
    default Operator<Type> implies(Operator<Type> antecedent, Operator<Type> consequent) {
        return propositions -> (Type) antecedent.evaluate(propositions).implies(consequent.evaluate(propositions));
    }

    @Override
    default Operator<Type> equals(Operator<Type> antecedent, Operator<Type> consequent) {
        return propositions -> (Type) antecedent.evaluate(propositions).equals(consequent.evaluate(propositions));
    }

    @Override
    default Operator<Type> xor(Operator<Type> antecedent, Operator<Type> consequent) {
        return propositions -> (Type) antecedent.evaluate(propositions).xor(consequent.evaluate(propositions));
    }

}
