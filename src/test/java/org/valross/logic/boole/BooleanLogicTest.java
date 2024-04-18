package org.valross.logic.boole;

import org.junit.Test;
import org.valross.logic.LogicTest;

public class BooleanLogicTest extends LogicTest<BooleanValue> {

    @Override
    public BooleanLogic logic() {
        return BooleanLogic.LOGIC;
    }

    @Test
    public void convert() {
        assert this.logic().convert(true).booleanValue();
        assert this.logic().convert(1).booleanValue();
        assert this.logic().convert(100).booleanValue();
        assert !this.logic().convert(false).booleanValue();
        assert !this.logic().convert(0).booleanValue();
        assert !this.logic().convert(-1).booleanValue();
    }

    @Test
    public void not() {
        assert this.logic().not(this.logic().falsity()).booleanValue();
        assert !this.logic().not(this.logic().truth()).booleanValue();
    }

    @Test
    public void and() {
        assert logic().and(this.logic().truth(), this.logic().truth()).booleanValue();
        assert !logic().and(this.logic().truth(), this.logic().falsity()).booleanValue();
        assert !logic().and(this.logic().falsity(), this.logic().truth()).booleanValue();
        assert !logic().and(this.logic().falsity(), this.logic().falsity()).booleanValue();
    }

    @Test
    public void or() {
        assert logic().or(this.logic().truth(), this.logic().truth()).booleanValue();
        assert logic().or(this.logic().truth(), this.logic().falsity()).booleanValue();
        assert logic().or(this.logic().falsity(), this.logic().truth()).booleanValue();
        assert !logic().or(this.logic().falsity(), this.logic().falsity()).booleanValue();
    }

    @Test
    public void xor() {
        assert !logic().xor(this.logic().truth(), this.logic().truth()).booleanValue();
        assert logic().xor(this.logic().truth(), this.logic().falsity()).booleanValue();
        assert logic().xor(this.logic().falsity(), this.logic().truth()).booleanValue();
        assert !logic().xor(this.logic().falsity(), this.logic().falsity()).booleanValue();
    }

    @Test
    public void truth() {
        assert this.logic().truth().booleanValue();
        assert this.logic().truth() == BooleanValue.TRUE;
        assert this.logic().truth().not() == BooleanValue.FALSE;
    }

    @Test
    public void falsity() {
        assert !this.logic().falsity().booleanValue();
        assert this.logic().falsity() == BooleanValue.FALSE;
        assert this.logic().falsity().not() == BooleanValue.TRUE;
    }

    @Test
    public void implies() {
    }

    @Test
    public void testEquals() {
    }

}