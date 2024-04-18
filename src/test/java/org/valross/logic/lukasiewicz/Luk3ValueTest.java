package org.valross.logic.lukasiewicz;

import org.valross.logic.Value;
import org.valross.logic.ValueTest;

import static org.valross.logic.lukasiewicz.Luk3Value.*;

public class Luk3ValueTest extends ValueTest {

    @Override
    protected Value truth() {
        return LukasiewiczLogic.THREE_VALUED.truth();
    }

    @Override
    protected Value falsity() {
        return LukasiewiczLogic.THREE_VALUED.falsity();
    }

    @Override
    public void implies() {
        super.implies();
        assert FALSE.implies(FALSE) == TRUE;
        assert FALSE.implies(UNKNOWN) == TRUE;
        assert FALSE.implies(TRUE) == TRUE;
        assert UNKNOWN.implies(FALSE) == UNKNOWN;
        assert UNKNOWN.implies(UNKNOWN) == TRUE;
        assert UNKNOWN.implies(TRUE) == TRUE;
        assert TRUE.implies(FALSE) == FALSE;
        assert TRUE.implies(UNKNOWN) == UNKNOWN;
        assert TRUE.implies(TRUE) == TRUE;
    }

}