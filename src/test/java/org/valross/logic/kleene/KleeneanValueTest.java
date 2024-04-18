package org.valross.logic.kleene;

import org.junit.Test;
import org.valross.logic.Value;
import org.valross.logic.ValueTest;

import java.util.Random;

public class KleeneanValueTest extends ValueTest {

    @Override
    protected Value truth() {
        return KleeneanValue.TRUE;
    }

    @Override
    protected Value falsity() {
        return KleeneanValue.FALSE;
    }

    @Test
    public void equals() {
        super.equals();
        final Random random = new Random();
        final KleeneanValue[] values = KleeneanValue.values();
        for (int i = 0; i < 100; i++) {
            final KleeneanValue a = values[(int) (random.nextFloat() * 2.99F)],
                b = values[(int) (random.nextFloat() * 2.99F)];
            assert a.equals(b) == a.implies(b).and(b.implies(a));
        }
    }

}