package org.valross.logic.operator;

import org.junit.Test;
import org.valross.logic.Logic;
import org.valross.logic.LogicTest;
import org.valross.logic.boole.BooleanValue;
import org.valross.logic.lukasiewicz.LukValue;
import org.valross.logic.lukasiewicz.LukasiewiczLogic;

public class OperatorLogicTest extends LogicTest<Operator<BooleanValue>> {

    @Override
    public Logic<Operator<BooleanValue>> logic() {
        return OperatorLogic.LOGIC;
    }

    @Test
    public void convert() {
    }

    @Test
    public void not() {
    }

    @Test
    public void and() {
    }

    @Test
    public void or() {
    }

    @Test
    public void xor() {
    }

    @Test
    public void of() {
        OperatorLogic<LukValue> logic = OperatorLogic.of(LukasiewiczLogic.MANY_VALUED);
        assert logic.truth().evaluate() == LukasiewiczLogic.MANY_VALUED.truth();
    }

    @Test
    public void input() {
    }

    @Test
    public void truth() {
    }

    @Test
    public void falsity() {
    }

    @Test
    public void implies() {
    }

    @Test
    public void testEquals() {
    }

}