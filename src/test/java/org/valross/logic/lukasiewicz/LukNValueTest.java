package org.valross.logic.lukasiewicz;

import org.junit.Test;
import org.valross.logic.Value;
import org.valross.logic.ValueTest;

import java.util.Random;

import static org.valross.logic.lukasiewicz.LukasiewiczLogic.MANY_VALUED;

public class LukNValueTest extends ValueTest {

    @Override
    protected Value truth() {
        return MANY_VALUED.truth();
    }

    @Override
    protected Value falsity() {
        return MANY_VALUED.falsity();
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

    @Test
    public void equivalency() {
        final Random random = new Random();
        for (int i = 0; i < 100; i++) {
            final LukValue a = new LukNValue(random.nextFloat()), b = new LukNValue(random.nextFloat());
            assert a.implies(b).floatValue() == MANY_VALUED.implies(a, b).floatValue();
            assert a.equals(b).floatValue() == MANY_VALUED.equals(a, b).floatValue();
            assert a.not().floatValue() == MANY_VALUED.not(a).floatValue();
            assert a.or(b).floatValue() == MANY_VALUED.or(a, b).floatValue();
            assert a.and(b).floatValue() == MANY_VALUED.and(a, b).floatValue();
        }
    }

}