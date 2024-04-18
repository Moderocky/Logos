package org.valross.logic.lukasiewicz;

import org.junit.Test;
import org.valross.logic.Value;
import org.valross.logic.ValueTest;

import java.util.Random;

public class LukNValueTest extends ValueTest {

    @Override
    protected Value truth() {
        return LukasiewiczLogic.MANY_VALUED.truth();
    }

    @Override
    protected Value falsity() {
        return LukasiewiczLogic.MANY_VALUED.falsity();
    }

    @Test
    public void axioms() {
        final Random random = new Random();
        for (int i = 0; i < 100; i++) {
            final LukValue a = new LukNValue(random.nextFloat()),
                b = new LukNValue(random.nextFloat()),
                c = new LukNValue(random.nextFloat());
            assert a.implies(b.implies(a)).floatValue() == 1;
            assert a.implies(b).implies(b.implies(c).implies(a.implies(c))).floatValue() == 1;
            assert a.implies(b).implies(b).implies(b.implies(a).implies(a)).floatValue() == 1;
            assert b.not().implies(a.not()).implies(a.implies(b)).floatValue() == 1;
            assert a.not().not().implies(a).floatValue() == 1;
        }
    }

}