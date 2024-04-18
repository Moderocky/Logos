package org.valross.logic;

/// # Logic
///
/// A logic is a framework in which propositions and their connectives can be evaluated.
///
/// ## Definition
///
/// In order to define a logic, two absolutes are required: a definite, atomic value
/// (typically for either 'true or 'false') and one absolute, atomic, binary connective, from which
/// all other connectives can be derived.
/// For example, defining a value 'false' and an atomic rule for AND, and then deriving all
/// other rules (OR, NOT, etc.) from this.
///
/// ## Good Logic
///
/// A complete logic requires the unary operator NOT, and the basic binary operators AND, OR, IMPLICATION
/// and EQUIVALENT. All other common rules are derived from these by default, but can be overridden
/// (and are permitted to be excluded).
///
/// ## Conversion
///
/// Logics may attempt conversion between one another, but no accuracy can be guaranteed, especially where
/// one value cannot be represented in another format.
///

public interface Logic<Type extends Value> {

    Type truth();

    Type falsity();

    <Other extends Value> Type convert(Other value);

    Type convert(Number value);

    Type convert(boolean value);

    Type not(Type value);

    Type and(Type antecedent, Type consequent);

    Type or(Type antecedent, Type consequent);

    Type implies(Type antecedent, Type consequent);

    Type equals(Type antecedent, Type consequent);

    default Type xor(Type antecedent, Type consequent) {
        return this.not(this.equals(antecedent, consequent));
    }

    default Type nand(Type antecedent, Type consequent) {
        return this.not(this.and(antecedent, consequent));
    }

    default Type nor(Type antecedent, Type consequent) {
        return this.not(this.or(antecedent, consequent));
    }

    default Type xnor(Type antecedent, Type consequent) {
        return this.not(this.xor(antecedent, consequent));
    }

}
