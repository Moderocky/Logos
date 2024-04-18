Logos
=====

A library for defining and evaluating logic frameworks.

## Terminology & Connectives

This project uses specific terminology and iconography in explanation and documentation.

Since these terms (or associated symbols) might be unfamiliar to users of different backgrounds
(classical logic, set notation and computing terminology often use different words or symbols
to mean the same thing), it is recommended that all users familiarise themselves with the versions
used in this library, to avoid confusion.

### Fundamental Logic Operators

| Instruction | Symbol           | Alternative Names                     |
|:------------|------------------|---------------------------------------|
| TRUE        | `⊤`, `true`      |                                       |
| FALSE       | `⊥`, `false`     |                                       |
| NOT         | `¬`, `!`         | Negation.                             |
| IMPLICATION | `→`, `->`        | Material conditional/implication.     |
| EQUIVALENCE | `=`, `==`, `<->` | Bi-conditional. Also known as 'XNOR'. |
| AND         | `∧`, `&`         | Conjunction.                          |
| OR          | `∨`, `\|`        | Inclusive disjunction.                |
| XOR         | `⊻`, `^`         | Exclusive disjunction.                |

**Note**: do not confuse Java's XOR symbol `^` (circumflex) with the logical AND `∧`.

The following are not strictly used but may be referenced.

| Instruction | Symbol |
|:------------|--------|
| NAND        | `⊼`    | 
| NOR         | `⊽`    |

### Predicate Logic Operators

| Instruction | Symbol | Alternative Names                              |
|:------------|--------|------------------------------------------------|
| FOR ALL     | `∀`    | Universal quantifier. 'For all x...'           |
| EXISTS      | `∃`    | Existential quantifier. 'There is an x...'     |
| NONE        | `∄`    | Non-existential quantifier. 'There is no x...' |
| UNIQUE      | `∃!`   | Unique quantifier. 'There is exactly one x...' |

### Modal Logic Operators

| Instruction | Symbol | Alternative Names |
|:------------|--------|-------------------|
| NECESSARY   | `□`    | Necessity.        |
| POSSIBLe    | `◇`    | Possibility.      |

## Supplied Frameworks

### George Boole's Boolean Logic

A [logic](https://en.wikipedia.org/wiki/Boolean_algebra) with two values; TRUE (1) and FALSE (0).

This is functionally equivalent to Java's primitive booleans, expressed through the framework for conversion.

### Jan Łukasiewicz's Three-Valued 'Ł3' Logic

A [logic](https://en.wikipedia.org/wiki/Three-valued_logic) with three values; TRUE (1), UNKNOWN (0.5) and FALSE (0).

### Jan Łukasiewicz's Many-Valued Logic

A [logic](https://en.wikipedia.org/wiki/%C5%81ukasiewicz_logic) with a range of values; TRUE (1), FALSE (0), and
POTENTIAL TRUTH in a range (0 -> 1).

Two atoms are provided: constant FALSE `0` and binary conjunction IMPLICATION `min(1, 1 - x + y)`.
Everything is derived from this:

| Operation   | Derivation          | Calculation         |
|-------------|---------------------|---------------------|
| IMPLICATION |                     | `min(1, 1 - X + Y)` |
| FALSE       |                     | `0`                 |
| TRUE        | `FALSE → FALSE`     | `1`                 |
| NEGATION    | `X → FALSE`         | `1 - X`             |
| OR          | `(X → Y) → Y`       | `max(X, Y)`         |
| AND         | `¬(¬X ∨ ¬Y)`        | `min(X, Y)`         |
| EQUIVALENCY | `(X → Y) ∧ (Y → X)` | `1 - abs(X - Y)`    |

### Stephen Cole Kleene's Strong Logic of Indeterminacy

A [logic](https://en.wikipedia.org/wiki/Three-valued_logic) with three values; TRUE (1), UNKNOWN (0) and FALSE (-1).
