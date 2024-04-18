package org.valross.logic;

import org.junit.Test;

public abstract class ValueTest {

    protected abstract Value truth();

    protected abstract Value falsity();

    @Test
    public void not() {
        assert truth().not().booleanValue() == falsity().booleanValue();
        assert falsity().not().booleanValue() == truth().booleanValue();
        assert truth().not().equals(falsity()).booleanValue();
        assert falsity().not().equals(truth()).booleanValue();
    }

    @Test
    public void and() {
        assert truth().and(truth()).booleanValue();
        assert !truth().and(falsity()).booleanValue();
        assert !falsity().and(truth()).booleanValue();
        assert !falsity().and(falsity()).booleanValue();
    }

    @Test
    public void or() {
        assert truth().or(truth()).booleanValue();
        assert truth().or(falsity()).booleanValue();
        assert falsity().or(truth()).booleanValue();
        assert !falsity().or(falsity()).booleanValue();
    }

    @Test
    public void implies() {
        assert truth().implies(truth()).booleanValue();
        assert !truth().implies(falsity()).booleanValue();
        assert falsity().implies(truth()).booleanValue();
        assert falsity().implies(falsity()).booleanValue();
    }

    @Test
    public void equals() {
        assert truth().equals(truth()).booleanValue();
        assert !truth().equals(falsity()).booleanValue();
        assert !falsity().equals(truth()).booleanValue();
        assert falsity().equals(falsity()).booleanValue();
    }

    @Test
    public void xor() {
        assert !truth().xor(truth()).booleanValue();
        assert truth().xor(falsity()).booleanValue();
        assert falsity().xor(truth()).booleanValue();
        assert !falsity().xor(falsity()).booleanValue();
    }

}
