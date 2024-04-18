package org.valross.logic.boole;

import org.valross.logic.Logic;
import org.valross.logic.Value;

public interface BooleanLogic extends Logic<BooleanValue> {

    BooleanLogic LOGIC = new BooleanLogic() {};

    @Override
    default BooleanValue truth() {
        return BooleanValue.TRUE;
    }

    @Override
    default BooleanValue falsity() {
        return BooleanValue.FALSE;
    }

    @Override
    default <Other extends Value> BooleanValue convert(Other value) {
        if (value instanceof BooleanValue ours) return ours;
        return value.booleanValue() ? this.truth() : this.falsity();
    }

    @Override
    default BooleanValue convert(Number value) {
        if (value == null) return this.falsity();
        return value.intValue() > 0 ? this.truth() : this.falsity();
    }

    @Override
    default BooleanValue convert(boolean value) {
        return value ? this.truth() : this.falsity();
    }

    @Override
    default BooleanValue not(BooleanValue value) {
        return value.booleanValue() ? this.falsity() : this.truth();
    }

    @Override
    default BooleanValue and(BooleanValue antecedent, BooleanValue consequent) {
        return antecedent.booleanValue() && consequent.booleanValue() ? this.truth() : this.falsity();
    }

    @Override
    default BooleanValue or(BooleanValue antecedent, BooleanValue consequent) {
        return antecedent.booleanValue() ? this.truth() : consequent;
    }

    @Override
    default BooleanValue implies(BooleanValue antecedent, BooleanValue consequent) {
        return antecedent.booleanValue() ? consequent : this.truth();
    }

    @Override
    default BooleanValue equals(BooleanValue antecedent, BooleanValue consequent) {
        return antecedent.booleanValue() == consequent.booleanValue() ? this.truth() : this.falsity();
    }

}
