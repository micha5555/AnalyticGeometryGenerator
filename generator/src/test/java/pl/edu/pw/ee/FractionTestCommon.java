package pl.edu.pw.ee;

import static org.junit.Assert.assertTrue;

public abstract class FractionTestCommon {
    public void checkFraction(Fraction f, int expectedNumerator, int expectedDenominator){
        assertTrue(f.getNumerator() == expectedNumerator);
        assertTrue(f.getDenominator() == expectedDenominator);
    }

    public void checkFraction(Fraction f, int expectedNumerator, int expectedDenominator, int expectedNumeratorSqr, int expectedDenominatorSqr){
        checkFraction(f, expectedNumerator, expectedDenominator);
        assertTrue(f.getNumeratorSqr() == expectedNumeratorSqr);
        assertTrue(f.getDenominatorSqr() == expectedDenominatorSqr);
    }
}
