package org.valross.logic.lukasiewicz;

record Luk3Value(float floatValue) implements LukValue {

    public static final LukasiewiczLogic LOGIC = LukasiewiczLogic.THREE_VALUED;
    public static final Luk3Value TRUE = new Luk3Value(1);
    public static final Luk3Value UNKNOWN = new Luk3Value(0.5F);
    public static final Luk3Value FALSE = new Luk3Value(0);

    @Override
    public LukasiewiczLogic getLogic() {
        return LOGIC;
    }

    @Override
    public String toString() {
        if (floatValue >= 1) return "true";
        if (floatValue <= 0) return "false";
        return "unknown";
    }

}
