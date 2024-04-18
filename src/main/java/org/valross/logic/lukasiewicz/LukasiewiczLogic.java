package org.valross.logic.lukasiewicz;

import org.valross.logic.Logic;
import org.valross.logic.Value;

/// # Jan Łukasiewicz's Many-Valued Logic
public interface LukasiewiczLogic extends Logic<LukValue> {

    LukasiewiczLogic MANY_VALUED = new LukasiewiczLogic() {};
    Luk3Logic THREE_VALUED = new Luk3Logic() {};

    @Override
    default LukValue truth() {
        return LukNValue.TRUE; // FALSE -> FALSE
    }

    @Override
    default LukValue falsity() {
        return LukNValue.FALSE;
    }

    @Override
    default <Other extends Value> LukValue convert(Other value) {
        if (value instanceof LukValue ours) return ours;
        return this.convert(value.floatValue());
    }

    @Override
    default LukValue convert(Number value) {
        return this.convert(value.floatValue());
    }

    @Override
    default LukValue convert(boolean value) {
        return value ? this.truth() : this.falsity();
    }

    @Override
    default LukValue not(LukValue value) {
        return value.implies(this.falsity());
    }

    @Override
    default LukValue and(LukValue antecedent, LukValue consequent) {
        return this.not(this.or(this.not(antecedent), this.not(consequent)));
    }

    @Override
    default LukValue or(LukValue antecedent, LukValue consequent) {
        return this.implies(this.implies(antecedent, consequent), consequent);
    }

    @Override
    default LukValue implies(LukValue antecedent, LukValue consequent) {
        return this.convert(Math.min(1, 1 - antecedent.floatValue() + consequent.floatValue()));
    }

    @Override
    default LukValue equals(LukValue antecedent, LukValue consequent) {
        return this.and(this.implies(antecedent, consequent), this.implies(consequent, antecedent));
    }

    @Override
    default LukValue xor(LukValue antecedent, LukValue consequent) {
        return this.not(this.equals(antecedent, consequent));
    }

    default LukValue convert(float value) {
        if (value <= 0) return this.falsity();
        if (value >= 1) return this.truth();
        return new LukNValue(Math.min(1, Math.max(0, value)));
    }

}
