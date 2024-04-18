package org.valross.logic.kleene;

import org.valross.logic.Logic;
import org.valross.logic.LogicTest;

public class KleeneanLogicTest extends LogicTest<KleeneanValue> {

    @Override
    public Logic<KleeneanValue> logic() {
        return KleeneanLogic.LOGIC;
    }

}