package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

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

}
