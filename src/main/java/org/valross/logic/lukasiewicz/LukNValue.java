package org.valross.logic.lukasiewicz;

record LukNValue(float floatValue) implements LukValue {

    public static final LukasiewiczLogic LOGIC = LukasiewiczLogic.MANY_VALUED;
    public static final LukNValue TRUE = new LukNValue(1);
    public static final LukNValue FALSE = new LukNValue(0);

    @Override
    public LukasiewiczLogic getLogic() {
        return LOGIC;
    }

    @Override
    public String toString() {
        return Float.toString(floatValue);
    }

}
