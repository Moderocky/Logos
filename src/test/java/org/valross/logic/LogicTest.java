package org.valross.logic;

import org.junit.Test;

public abstract class LogicTest<Type extends Value> {

    public abstract Logic<Type> logic();

    @Test
    public void convert() {
        assert this.logic().convert(true) == this.logic().truth();
        assert this.logic().equals(this.logic().convert(true), this.logic().truth()).booleanValue();
        assert this.logic().convert(false) == this.logic().falsity();
        assert this.logic().equals(this.logic().convert(false), this.logic().falsity()).booleanValue();
    }

    protected Type getTrue() {
        return this.logic().truth();
    }

    protected Type getFalse() {
        return this.logic().falsity();
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

}