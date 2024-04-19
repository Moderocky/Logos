package org.valross.logic.operator;

import org.junit.Test;
import org.valross.logic.Logic;
import org.valross.logic.LogicTest;
import org.valross.logic.boole.BooleanLogic;
import org.valross.logic.boole.BooleanValue;
import org.valross.logic.lukasiewicz.LukValue;
import org.valross.logic.lukasiewicz.LukasiewiczLogic;

import java.util.Objects;

public class OperatorLogicTest extends LogicTest<Operator<BooleanValue>> implements OperatorLogic<BooleanValue> {

    @Override
    public Logic<Operator<BooleanValue>> logic() {
        return OperatorLogic.LOGIC;
    }

    @Override
    public Operator<BooleanValue> truth() {
        return OperatorLogic.of(BooleanLogic.LOGIC).truth();
    }

    @Override
    public Operator<BooleanValue> falsity() {
        return OperatorLogic.of(BooleanLogic.LOGIC).falsity();
    }

    @Test
    public void simple() {
        this.print(falsity().implies(falsity()), "(⊥ → ⊥)");
        this.print(falsity().implies(truth()), "(⊥ → ⊤)");
        this.print(input(0).and(input(0)), "(a ∧ a)");
        this.print(input(0).and(input(1)), "(a ∧ b)");
        this.print(input(0).or(input(1)), "(a ∨ b)");
        this.print(input(0).implies(input(1)), "(a → b)");
        this.print(input(0).not().implies(input(1)), "(¬a → b)");
        this.print(input(0).implies(input(1)).not(), "¬(a → b)");
        this.print(input(0).equals(input(1)), "(a = b)");
        this.print(input(0).not().equals(input(1).not()), "(¬a = ¬b)");
        this.print(input(0).and(input(1)).implies(falsity()), "((a ∧ b) → ⊥)");
    }

    @Test
    public void evaluation() {
        this.test(falsity().implies(falsity()));
        this.test(falsity().implies(truth()));
        this.test(truth().implies(truth()));
        this.test(truth().implies(falsity()).not());
        this.test(truth().not().implies(falsity()));
        this.test(truth().implies(falsity().not()));
        this.test(truth().not().implies(falsity().not()));
        this.test(input(0).not(), false);
        this.test(input(0).not().not(), true);
        this.test(input(0).and(input(0)), true);
        this.test(input(0).and(input(0)).not(), false);
        this.test(input(0).and(input(1)).not(), true, false);
        this.test(input(0).and(input(1).not()), true, false);
        this.test(input(0).or(input(0)), true);
        this.test(input(0).or(input(1)), true, false);
        this.test(input(1).or(input(0)), true, false);
        this.test(input(0).not().or(input(0)), false);
        this.test(input(0).or(input(0)).not(), false);
        this.test(input(0).or(input(0).not()), false);
        this.test(input(0).implies(input(0)), true);
        this.test(input(0).implies(input(0)), false);
        this.test(input(0).implies(input(1)), true, true);
        this.test(input(0).implies(input(1)), false, true);
        this.test(input(0).implies(input(1)), false, false);
        this.test(input(0).implies(input(1)).not(), true, false);
        this.test(input(0).implies(input(1).not()), true, false);
        this.test(input(0).not().implies(input(1)), true, false);
        this.test(input(0).equals(input(0)), true);
        this.test(input(0).equals(input(0)), false);
        this.test(input(0).equals(input(0)), true);
        this.test(input(0).equals(input(1)), true, true);
        this.test(input(0).equals(input(1)), false, false);
        this.test(input(0).equals(input(1).not()), true, false);
        this.test(input(0).not().equals(input(1)), true, false);
        this.test(input(0).equals(input(1)).not(), true, false);
        this.test(input(0).and(input(1)).implies(falsity()), true, false);
    }

    protected void test(Operator<BooleanValue> operator, boolean... values) {
        final BooleanValue[] arguments;
        if (values.length > 0) {
            arguments = new BooleanValue[values.length];
            for (int i = 0; i < values.length; i++) arguments[i] = BooleanLogic.LOGIC.convert(values[i]);
        } else arguments = new BooleanValue[0];
        assert operator.evaluate(arguments).booleanValue(): operator + " = false";
    }

    protected void print(Operator<?> operator, String expected) {
        assert Objects.equals(operator.toString(), expected) : operator + " != " + expected;
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
    public void truthTest() {
    }

    @Test
    public void falsityTest() {
    }

    @Test
    public void implies() {
    }

    @Test
    public void testEquals() {
    }

}