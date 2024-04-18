package org.valross.logic.kleene;

import org.valross.logic.Logic;
import org.valross.logic.Value;
import org.valross.logic.boole.BooleanValue;

public interface KleeneanLogic extends Logic<KleeneanValue> {

    KleeneanLogic LOGIC = new KleeneanLogic() {};

    @Override
    default KleeneanValue truth() {
        return KleeneanValue.TRUE;
    }

    @Override
    default KleeneanValue falsity() {
        return KleeneanValue.FALSE;
    }

    @Override
    default <Other extends Value> KleeneanValue convert(Other other) {
        return switch (other) {
            case KleeneanValue value:
                yield value;
            case BooleanValue value:
                if (value.booleanValue()) yield this.truth();
                yield this.falsity();
            case Value.RangeZeroOne value:
                if (value.floatValue() <= 0) yield this.truth();
                if (value.floatValue() >= 1) yield this.falsity();
                yield this.unknown();
            default:
                yield this.convert(other.intValue());
        };
    }

    @Override
    default KleeneanValue convert(Number value) {
        if (value.intValue() <= -1) return this.falsity();
        if (value.intValue() >= 1) return this.truth();
        return this.unknown();
    }

    @Override
    default KleeneanValue convert(boolean value) {
        return value ? this.truth() : this.falsity();
    }

    @Override
    default KleeneanValue not(KleeneanValue value) {
        return value.not();
    }

    @Override
    default KleeneanValue and(KleeneanValue antecedent, KleeneanValue consequent) {
        return (KleeneanValue) antecedent.and(consequent);
    }

    @Override
    default KleeneanValue or(KleeneanValue antecedent, KleeneanValue consequent) {
        return (KleeneanValue) antecedent.or(consequent);
    }

    @Override
    default KleeneanValue implies(KleeneanValue antecedent, KleeneanValue consequent) {
        return (KleeneanValue) antecedent.implies(consequent);
    }

    @Override
    default KleeneanValue equals(KleeneanValue antecedent, KleeneanValue consequent) {
        return (KleeneanValue) antecedent.equals(consequent);
    }

    @Override
    default KleeneanValue xor(KleeneanValue antecedent, KleeneanValue consequent) {
        return (KleeneanValue) antecedent.xor(consequent);
    }

    default KleeneanValue unknown() {
        return KleeneanValue.UNKNOWN;
    }

}
