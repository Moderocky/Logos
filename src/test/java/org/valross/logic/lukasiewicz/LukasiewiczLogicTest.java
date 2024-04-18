package org.valross.logic.lukasiewicz;

import org.junit.Test;
import org.valross.logic.Logic;
import org.valross.logic.LogicTest;

public class LukasiewiczLogicTest extends LogicTest<LukValue> {

    @Override
    public Logic<LukValue> logic() {
        return LukasiewiczLogic.MANY_VALUED;
    }

    @Test
    public void not() {
        assert this.logic().not(this.logic().falsity()).booleanValue();
        assert !this.logic().not(this.logic().truth()).booleanValue();
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
    public void truth() {
        assert this.logic().truth().booleanValue();
        assert this.logic().truth() == this.logic().convert(1);
        assert this.logic().equals(this.logic().truth(), this.logic().convert(1)).booleanValue();
    }

    @Test
    public void falsity() {
        assert !this.logic().falsity().booleanValue();
        assert this.logic().falsity() == this.logic().convert(0);
        assert this.logic().equals(this.logic().falsity(), this.logic().convert(0)).booleanValue();
    }

    @Test
    public void testConvert() {
        super.convert();
    }

    @Test
    public void testConvertNumber() {
        assert this.logic().convert(100).equals(this.logic().truth()).booleanValue();
        assert this.logic().convert(1).equals(this.logic().truth()).booleanValue();
        assert this.logic().convert(0).equals(this.logic().falsity()).booleanValue();
        assert this.logic().convert(-100).equals(this.logic().falsity()).booleanValue();
    }

    @Test
    public void testConvertBoolean() {
        assert this.logic().convert(true).equals(this.logic().truth()).booleanValue();
        assert this.logic().convert(false).equals(this.logic().falsity()).booleanValue();
    }

    @Test
    public void implies() {
    }

    @Test
    public void testEquals() {
    }

}