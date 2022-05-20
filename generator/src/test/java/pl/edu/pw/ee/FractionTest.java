package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class FractionTest extends FractionTestCommon{
    
    @Test
    public void should_CorrectlyCreateFractions_WhenNumbersAreNormal() throws IncorrectFractionException{
        Fraction f = new Fraction(5, 2);
        checkFraction(f, 5, 2);
    }

    @Test
    public void should_CorrectlyCreateFraction_WhenNumeratorAndDenominatorAreNegative() throws IncorrectFractionException{
        Fraction f = new Fraction(-2, -3);
        checkFraction(f, 2, 3);
    }

    @Test
    public void should_CorrectlyCreateFraction_WhenNumeratorIsNegative_AndDenominatorIsPositive() throws IncorrectFractionException{
        Fraction f = new Fraction(-5, 3);
        checkFraction(f, -5, 3);
    }

    @Test
    public void should_CorrectlyCreateFraction_WhenNumeratorIsPositive_AndDenominatorIsNegative() throws IncorrectFractionException{
        Fraction f = new Fraction(8, -9);
        checkFraction(f, -8, 9);
    }

    @Test(expected = IncorrectFractionException.class)
    public void should_ThrowException_WhenDenominatorIsZero() throws IncorrectFractionException{
        Fraction f = new Fraction(8, 0);
    }

    @Test
    public void should_ReduceCorrectly_WhenNumeratorIsLowerThanDenominator() throws IncorrectFractionException{
        Fraction f = new Fraction(8, 12);
        checkFraction(f, 2,3);
    }

    @Test
    public void should_ReduceCorrectly_WhenNumeratorIsGreaterThanDenominator() throws IncorrectFractionException{
        Fraction f = new Fraction(55, 11);
        checkFraction(f, 5,1);
    }

    @Test
    public void should_ReduceCorrectly_WhenNumeratorIsZeroAndDenominatorIsNotOne() throws IncorrectFractionException{
        Fraction f = new Fraction(0, 4);
        checkFraction(f, 0, 1);
    }

    @Test
    public void should_ReduceCorrectly_WhenNumeratorIsZero_AndGiveNumeratorAndDenominatroSqrInConsructor() throws IncorrectFractionException{
        Fraction f1 = new Fraction(0, 5, 3, 1);
        checkFraction(f1, 0, 1, 1, 1);
        Fraction f2 = new Fraction(0, 11, 1, 15);
        checkFraction(f2, 0, 1, 1, 1);
        Fraction f3 = new Fraction(0, 33, 8, 4);
        checkFraction(f3, 0, 1, 1, 1);
    }

    @Test
    public void should_ReturnZero_WhenMultiplyZeroByNormalFraction() throws IncorrectFractionException{
        Fraction f1 = new Fraction(0, 1);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = Fraction.multiplyFractions(f1, f2);
        checkFraction(result, 0, 1, 1, 1);
    }

    @Test
    public void should_ReturnZero_WhenMultiplyZeroByFractionWithSqr() throws IncorrectFractionException{
        Fraction f1 = new Fraction(5, 3, 2, 1);
        Fraction f2 = new Fraction(0, 1);
        Fraction result = Fraction.multiplyFractions(f1, f2);
        checkFraction(result, 0, 1, 1, 1);
    }

    @Test
    public void should_ReturnZero_WhenMultiplyZeroByZero() throws IncorrectFractionException{
        Fraction f1 = new Fraction(0, 1);
        Fraction result = Fraction.multiplyFractions(f1, f1);
        checkFraction(result, 0, 1, 1, 1);
    }

    @Test
    public void should_CorrectlyAddFractions_WhenFractionsHaveSameDenominator() throws IncorrectFractionException{
        Fraction f1 = new Fraction(5, 3);
        Fraction f2 = new Fraction(8, 3);
        Fraction result = Fraction.addFractions(f1, f2);
        checkFraction(result, 13, 3);
    }

    @Test
    public void shouls_CorrectlyAddFractions_WhenBothAreNegative() throws IncorrectFractionException{
        Fraction f1 = new Fraction(-2, 5);
        Fraction f2 = new Fraction(-3, 4);
        Fraction result = Fraction.addFractions(f1, f2);
        checkFraction(result, -23, 20);
    }

    @Test
    public void should_CorrectlyAddFractions_WhenFractionsHaveDifferentDenominators() throws IncorrectFractionException{
        Fraction f1 = new Fraction(5, 3);
        Fraction f2 = new Fraction(8, 7);
        Fraction result = Fraction.addFractions(f1, f2);
        checkFraction(result, 59, 21);
    }

    @Test
    public void should_CorrectlyAddFractions_AndReduceResult_WhenFractionsHaveDifferentDenominators() throws IncorrectFractionException{
        Fraction f1 = new Fraction(8, 3);
        Fraction f2 = new Fraction(2, 15);
        Fraction result = Fraction.addFractions(f1, f2);
        checkFraction(result, 14, 5);
    }

    @Test
    public void should_CorrectlyAddFractions_WhenOneFractionIsNegative() throws IncorrectFractionException{
        Fraction f1 = new Fraction(-6, 7);
        Fraction f2 = new Fraction(1, 2);
        Fraction result = Fraction.addFractions(f1, f2);
        checkFraction(result, -5, 14);
    }

    @Test
    public void should_CorrectlySubstract_WhenFractionsHaveSameDenominator() throws IncorrectFractionException{
        Fraction f1 = new Fraction(8, 15);
        Fraction f2 = new Fraction(2, 15);
        Fraction result = Fraction.subFractions(f1, f2);
        checkFraction(result, 2, 5);
    }

    @Test
    public void should_CorrectlySubstract_WhenFractionsHaveDifferentDenominators() throws IncorrectFractionException{
        Fraction f1 = new Fraction(8, 15);
        Fraction f2 = new Fraction(4, 30);
        Fraction result = Fraction.subFractions(f1, f2);
        checkFraction(result, 2, 5);
    }

    @Test
    public void should_CorrectlySubstract_WhenBothNumbersAreNegative() throws IncorrectFractionException{
        Fraction f1 = new Fraction(-5, 7);
        Fraction f2 = new Fraction(-3, 8);
        Fraction result = Fraction.subFractions(f1, f2);
        checkFraction(result, -19, 56);
    }

    @Test
    public void should_CorrectlySubstract_WhenFirstNumberIsNegative_AndSecondIsPositive() throws IncorrectFractionException{
        Fraction f1 = new Fraction(-3, 4);
        Fraction f2 = new Fraction(5, 33);
        Fraction result = Fraction.subFractions(f1, f2);
        checkFraction(result, -119, 132);
    }

    @Test
    public void should_CorrectlySubstract_WhenFirstNumberIsPositive_AndSecondIsNegative() throws IncorrectFractionException{
        Fraction f1 = new Fraction(4, 11);
        Fraction f2 = new Fraction(-2, 13);
        Fraction result = Fraction.subFractions(f1, f2);
        checkFraction(result, 74, 143);
    }

    @Test
    public void should_CorrectlyMultply_WhenThereIsNoSqr() throws IncorrectFractionException{
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(5, 4);
        Fraction result = Fraction.multiplyFractions(f1, f2);
        checkFraction(result, 5, 6);
    }

    @Test
    public void should_CorrectlyMultiply_WhenThereIsSqrInOneFraction() throws IncorrectFractionException{
        Fraction f1 = new Fraction(4, 5, 5, 1);
        Fraction f2 = new Fraction(10, 11);
        Fraction result = Fraction.multiplyFractions(f1, f2);
        checkFraction(result, 8, 11, 5, 1);
    }

    @Test
    public void should_CorrectlyMultiply_WhenThereAreSameSqrsInBothFractions() throws IncorrectFractionException{
        Fraction f1 = new Fraction(5, 3, 10, 1);
        Fraction f2 = new Fraction(9, 11, 10, 1);
        Fraction result = Fraction.multiplyFractions(f1, f2);
        checkFraction(result, 150, 11, 1, 1);
    }

    @Test
    public void should_CorrectlyMultiply_WhenThereAreDifferentSqrsInFractions() throws IncorrectFractionException{
        Fraction f1 = new Fraction(6, 13, 19, 1);
        Fraction f2 = new Fraction(4, 7, 21, 1);
        Fraction result = Fraction.multiplyFractions(f1, f2);
        checkFraction(result, 24, 91, 399, 1);
    }

    @Test
    public void should_CorrectlyDivide_WhenFractionsAreNormal() throws IncorrectFractionException, IllegalMathOperation{
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(12, 17);
        Fraction result1 = Fraction.divFractions(f1, f2);
        Fraction result2 = Fraction.divFractions(f2, f1);
        Fraction result3 = Fraction.divFractions(f1, f1);
        Fraction result4 = Fraction.divFractions(f2, f2);
        checkFraction(result1, 17, 16, 1, 1);
        checkFraction(result2, 16, 17, 1, 1);
        checkFraction(result3, 1, 1, 1, 1);
        checkFraction(result4, 1, 1, 1, 1);
    }

    @Test
    public void should_CorrectlyDivide_WhenInOneFractionThereIsSqr() throws IncorrectFractionException, IllegalMathOperation{
        Fraction f1 = new Fraction(4, 5, 3, 1);
        Fraction f2 = new Fraction(6, 7);
        Fraction result1 = Fraction.divFractions(f1, f2);
        Fraction result2 = Fraction.divFractions(f2, f1);
        Fraction result3 = Fraction.divFractions(f1, f1);
        Fraction result4 = Fraction.divFractions(f2, f2);
        checkFraction(result1, 14, 15, 3, 1);
        checkFraction(result2, 5, 14, 3, 1);
        checkFraction(result3, 1, 1, 1, 1);
        checkFraction(result4, 1, 1, 1, 1);
    }

    @Test
    public void should_CorrectlyDivide_WhenThereIsSameSqrInBothFraction() throws IncorrectFractionException, IllegalMathOperation{
        Fraction f1 = new Fraction(4, 5, 3, 1);
        Fraction f2 = new Fraction(6, 7, 3, 1);
        Fraction result1 = Fraction.divFractions(f1, f2);
        Fraction result2 = Fraction.divFractions(f2, f1);
        Fraction result3 = Fraction.divFractions(f1, f1);
        Fraction result4 = Fraction.divFractions(f2, f2);
        checkFraction(result1, 14, 15, 1, 1);
        checkFraction(result2,15, 14, 1, 1);
        checkFraction(result3, 1, 1, 1, 1);
        checkFraction(result4, 1, 1, 1, 1);
    }

    @Test
    public void should_CorrectlyDivide_WhenThereAreDifferentSqrsInBothFraction() throws IncorrectFractionException, IllegalMathOperation{
        Fraction f1 = new Fraction(4, 5, 5, 1);
        Fraction f2 = new Fraction(6, 7, 3, 1);
        Fraction result1 = Fraction.divFractions(f1, f2);
        Fraction result2 = Fraction.divFractions(f2, f1);
        Fraction result3 = Fraction.divFractions(f1, f1);
        Fraction result4 = Fraction.divFractions(f2, f2);
        checkFraction(result1, 14, 45, 15, 1);
        checkFraction(result2, 3, 14, 15, 1);
        checkFraction(result3, 1, 1, 1, 1);
        checkFraction(result4, 1, 1, 1, 1);
    }

    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowException_WhenTryingToDivideByZero() throws IncorrectFractionException, IllegalMathOperation{
        Fraction f1 = new Fraction(5, 8);
        Fraction f2 = new Fraction(0, 1);
        Fraction result = Fraction.divFractions(f1, f2);
    }
    
    @Test
    public void should_ReturnZero_WhenZeroIsDividedBySomethingEsle() throws IncorrectFractionException, IllegalMathOperation{
        Fraction f1 = new Fraction(0, 1);
        Fraction f2 = new Fraction(4, 7);
        Fraction f3 = new Fraction(5, 1, 4, 1);
        Fraction result1 = Fraction.divFractions(f1, f2);
        Fraction result2 = Fraction.divFractions(f1, f3);
        checkFraction(result1, 0, 1, 1, 1);
        checkFraction(result2, 0, 1, 1, 1);
    }

    @Test
    public void should_CompareToReturnOne_WhenCurrentFractionIsBigger() throws IncorrectFractionException{
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(1, 2);
        assertTrue(f1.compareTo(f2) == 1);
    }

    @Test
    public void should_CompareToReturnMinusOne_WhenCurrentFractionIsLower() throws IncorrectFractionException{
        Fraction f1 = new Fraction(-1, 2);
        Fraction f2 = new Fraction(1, 2);
        assertTrue(f1.compareTo(f2) == -1);
    }

    @Test
    public void should_CompareToReturnZero_WhenFraactionsAreTheSame() throws IncorrectFractionException{
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(4,6);
        assertTrue(f1.compareTo(f2) == 0);
    }

    @Test
    public void should_CorrectlyReduce_WhenThereIsSqrInNumerator() throws IncorrectFractionException{
        Fraction f = new Fraction(4, 2, 3, 1);
        checkFraction(f, 2, 1, 3, 1);
    }

    @Test
    public void should_CorrectlyReduce_WhenThereIsSqrInDenominator() throws IncorrectFractionException{
        Fraction f = new Fraction(9, 18, 1, 2);
        checkFraction(f, 1, 4, 2, 1);
    }

    @Test
    public void should_CorrectlyReduce_WhenThereAreDifferentSqrsInNumeratorAndDenominator() throws IncorrectFractionException{
        Fraction f = new Fraction(25, 5, 6, 5);
        checkFraction(f, 1, 1, 30, 1);
    }

    @Test
    public void should_CorrectlyReduce_WhenThereAreTheSameSqrsInNumeratorAndDenominator() throws IncorrectFractionException{
        Fraction f = new Fraction(5, 25, 10, 10);
        checkFraction(f, 1, 5, 1, 1);
    }

    @Test
    public void should_CorrectlyCountSqr_WhenNumerator_AndDenominatorCanBeSquareWithoutRest() throws IncorrectFractionException{
        Fraction f = new Fraction(4, 9);
        f = f.sqrFraction(f);
        checkFraction(f, 2, 3, 1, 1);
    }

    @Test
    public void should_CorrectlyCountSqr_WhenNumeratorShouldHaveSqr_AndDenominatorNot() throws IncorrectFractionException{
        Fraction f = new Fraction(125, 16);
        f = f.sqrFraction(f);
        checkFraction(f, 5, 4, 5, 1);
    }

    @Test
    public void should_CorrectlyCountSqr_WhenDenumeratorShouldHaveSqr_AndNumeratorNot() throws IncorrectFractionException{
        Fraction f = new Fraction(25, 57);
        f = f.sqrFraction(f);
        checkFraction(f, 5, 57, 57, 1);
    }


}
