package org.valross.logic.lukasiewicz;

import org.valross.logic.Value;

/// # Jan Łukasiewicz's 3-Valued Logic
/// This overrides methods from the many-valued logic to ensure only 3 values exist.
public interface Luk3Logic extends LukasiewiczLogic {

    default LukValue unknown() {
        return Luk3Value.UNKNOWN;
    }

    @Override
    default LukValue truth() {
        return Luk3Value.TRUE;
    }

    @Override
    default LukValue falsity() {
        return Luk3Value.FALSE;
    }

    @Override
    default <Other extends Value> LukValue convert(Other value) {
        return this.convert(value.floatValue());
    }

    @Override
    default LukValue convert(float value) {
        if (value <= 0) return this.falsity();
        if (value >= 1) return this.truth();
        return this.unknown();
    }

}
