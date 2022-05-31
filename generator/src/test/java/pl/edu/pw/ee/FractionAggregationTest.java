package pl.edu.pw.ee;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class FractionAggregationTest extends FractionTestCommon{

    @Test
    public void should_CombineFractions_WhenTheyHaventGotSqrs_AndThereAreThreeFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(5, 3));
        list.add(new Fraction(2, 5));
        list.add(new Fraction(-6, 7));
        FractionAggregation f = new FractionAggregation(list);
        assertTrue(f.getSize() == 1);
        checkFraction(f.getFraction(0), 127, 105, 1, 1);
    }

    @Test
    public void should_CombineFractions_WhenOneHasSqr_AndThereAreThreeFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(3, 4));
        list.add(new Fraction(5, 6, 3, 1));
        list.add(new Fraction(-6, 7));
        FractionAggregation f = new FractionAggregation(list);
        assertTrue(f.getSize() == 2);
        checkFraction(f.getFraction(0), -3, 28, 1, 1);
        checkFraction(f.getFraction(1), 5, 6, 3, 1);
    }

    @Test
    public void should_CombineFractions_WhenEveryFractionHaveSameSqr_AndThereAreThreeFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(3, 4, 3, 1));
        list.add(new Fraction(5, 6, 3, 1));
        list.add(new Fraction(-6, 4, 3, 1));
        FractionAggregation f = new FractionAggregation(list);
        assertTrue(f.getSize() == 1);
        checkFraction(f.getFraction(0), 1, 12, 3, 1);
    }

    @Test
    public void should_CombineFractions_WhenTheyHaventGotSqrs_AndThereAreTwoFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(5, 3));
        list.add(new Fraction(-6, 7));
        FractionAggregation f = new FractionAggregation(list);
        assertTrue(f.getSize() == 1);
        checkFraction(f.getFraction(0), 17, 21, 1, 1);
    }

    @Test
    public void should_CombineFractions_WhenOneHasSqr_AndThereAreTwoFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(5, 6, 3, 1));
        list.add(new Fraction(-6, 7));
        FractionAggregation f = new FractionAggregation(list);
        assertTrue(f.getSize() == 2);
        checkFraction(f.getFraction(0), 5, 6, 3, 1);
        checkFraction(f.getFraction(1), -6, 7, 1, 1);
    }

    @Test
    public void should_NotDeleteZero_WhenThereIsOnlyZeroInAggregation() throws IncorrectFractionException{
        FractionAggregation f = new FractionAggregation(new Fraction(0, 1));
        assertTrue(f.getSize() == 1);
        checkFraction(f.getFraction(0), 0, 1, 1, 1);
    }

    @Test
    public void should_DeleteZero_WhenThereIsSomethingElseThanZeroInAggregation() throws IncorrectFractionException{
        ArrayList<Fraction> list = new ArrayList<>();
        list.add(new Fraction(0, 1));
        list.add(new Fraction(5, 3,3,1));
        FractionAggregation f = new FractionAggregation(list);
        assertTrue(f.getSize() == 1);
        checkFraction(f.getFraction(0), 5, 3, 3, 1);
    }

    @Test
    public void should_CorrectlyAddAggregations_WhenInBothThereAreNoSqrs_AndBothHaveOneFraction() throws IncorrectFractionException{
        FractionAggregation f1 = new FractionAggregation(new Fraction(5, 6));
        FractionAggregation f2 = new FractionAggregation(new Fraction(7, 8));
        FractionAggregation result = FractionAggregation.addFA(f1, f2);
        assertTrue(result.getSize() == 1);
        checkFraction(result.getFraction(0), 41, 24, 1, 1);
    }

    @Test
    public void should_CorrectlyAddAggregations_WhenInBothThereIsSameSqr_AndBothHaveOneFraction() throws IncorrectFractionException{
        FractionAggregation f1 = new FractionAggregation(new Fraction(3, 4,3,1));
        FractionAggregation f2 = new FractionAggregation(new Fraction(-1,2,3,1));
        FractionAggregation result = FractionAggregation.addFA(f1, f2);
        assertTrue(result.getSize() == 1);
        checkFraction(result.getFraction(0), 1,4,3,1);
    }

    @Test
    public void should_CorrectlyAddAggregations_WhenInBothThereAreDifferentSqrs_AndBothHaveOneFraction() throws IncorrectFractionException{
        FractionAggregation f1 = new FractionAggregation(new Fraction(3, 4,2,1));
        FractionAggregation f2 = new FractionAggregation(new Fraction(-1,2,3,1));
        FractionAggregation result = FractionAggregation.addFA(f1, f2);
        assertTrue(result.getSize() == 2);
        checkFraction(result.getFraction(0), 3, 4, 2, 1);
        checkFraction(result.getFraction(1), -1, 2, 3, 1);
    }

    @Test
    public void should_CorrectlyAddAggregations_WhenInBothThereAreDifferentSqrs_AndBothHaveTwoFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 3, 2, 1));
        list1.add(new Fraction(7, 8, 3,1));
        list2.add(new Fraction(3, 4, 5, 1));
        list2.add(new Fraction(10, 11, 6, 1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        FractionAggregation result = FractionAggregation.addFA(f1, f2);
        assertTrue(result.getSize() == 4);
        checkFraction(result.getFraction(0), 5, 3, 2, 1);
        checkFraction(result.getFraction(1), 7, 8, 3, 1);
        checkFraction(result.getFraction(2), 3, 4, 5, 1);
        checkFraction(result.getFraction(3), 10, 11, 6, 1);
    }
    
    @Test
    public void should_CorrectlyAddAggregations_WhenHaveCommonSqr_AndBothHaveTwoFractions() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 3, 2, 1));
        list1.add(new Fraction(7, 8, 3,1));
        list2.add(new Fraction(3, 4, 5, 1));
        list2.add(new Fraction(-10, 11, 3, 1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        FractionAggregation result = FractionAggregation.addFA(f1, f2);
        assertTrue(result.getSize() == 3);
        checkFraction(result.getFraction(0), 5, 3, 2, 1);
        checkFraction(result.getFraction(1), -3, 88, 3, 1);
        checkFraction(result.getFraction(2), 3, 4, 5, 1);
    }

    @Test
    public void should_EqualsReturnTrue_WhenAggregatinosAreTheSame_AndHaveOnlyOneElem() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 3, 3,1));
        list2.add(new Fraction(5,3,3,1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void should_EqualsReturnFalse_WhenAggregatinosArentTheSame_AndHaveOnlyOneElem() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 3, 3,1));
        list2.add(new Fraction(5,3,2,1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        assertTrue(!f1.equals(f2));
    }

    @Test
    public void should_EqualsReturnFalse_WhenAggregationsHaveDifferentSizes() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 3, 3,1));
        list2.add(new Fraction(5,3,2,1));
        list2.add(new Fraction(4, 1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        assertTrue(!f1.equals(f2));
    }

    @Test
    public void should_EqualsReturnTrue_WhenAggregationsAreTheSame_AndHaveTwoElems() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 3, 3,1));
        list1.add(new Fraction(4, 1));
        list2.add(new Fraction(4, 1));
        list2.add(new Fraction(5,3,3,1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void should_EqualsReturnFalse_WhenAggregationsAreNotTheSame_AndHaveTwoElems() throws IncorrectFractionException{
        ArrayList<Fraction> list1 = new ArrayList<>();
        ArrayList<Fraction> list2 = new ArrayList<>();
        list1.add(new Fraction(5, 2, 3,1));
        list1.add(new Fraction(4, 1));
        list2.add(new Fraction(4, 1));
        list2.add(new Fraction(5,3,3,1));
        FractionAggregation f1 = new FractionAggregation(list1);
        FractionAggregation f2 = new FractionAggregation(list2);
        assertTrue(!f1.equals(f2));
    }
}
