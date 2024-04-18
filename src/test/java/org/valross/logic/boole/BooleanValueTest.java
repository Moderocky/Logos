package org.valross.logic.boole;

import org.valross.logic.Value;
import org.valross.logic.ValueTest;

public class BooleanValueTest extends ValueTest {

    @Override
    protected Value truth() {
        return BooleanValue.TRUE;
    }

    @Override
    protected Value falsity() {
        return BooleanValue.FALSE;
    }

}