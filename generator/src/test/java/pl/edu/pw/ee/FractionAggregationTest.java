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

    @Test
    public void should_AbsReturnProperly_WhenThereIsOnlyOneFraction() throws IncorrectFractionException{
        FractionAggregation f = new FractionAggregation(new Fraction(-2, 3, 3, 1));
        f.abs();
        assertTrue(f.equals(new FractionAggregation(new Fraction(2, 3, 3, 1))));
        f.abs();
        assertTrue(f.equals(new FractionAggregation(new Fraction(2, 3, 3, 1))));
    }

    @Test
    public void should_AbsReturnProperly_WhenThereIsTwoFractions_AndBothAreNegative() throws IncorrectFractionException{
        ArrayList<Fraction> fl = new ArrayList<>();
        fl.add(new Fraction(-3, 4, 2, 1));
        fl.add(new Fraction(-5, 2, 3, 1));
        FractionAggregation f = new FractionAggregation(fl);
        f.abs();
        ArrayList<Fraction> fl2 = new ArrayList<>();
        fl2.add(new Fraction(5,2,3,1));
        fl2.add(new Fraction(3,4,2,1));
        FractionAggregation shouldBe = new FractionAggregation(fl2);
        assertTrue(f.equals(shouldBe));
        f.abs();
        assertTrue(f.equals(shouldBe));
    }

    @Test
    public void should_AbsReturnProperly_WhenThereIsTwoFractions_AndOneIsNegative() throws IncorrectFractionException{
        ArrayList<Fraction> fl = new ArrayList<>();
        fl.add(new Fraction(3, 4, 2, 1));
        fl.add(new Fraction(-5, 2, 3, 1));
        FractionAggregation f = new FractionAggregation(fl);
        f.abs();
        ArrayList<Fraction> fl2 = new ArrayList<>();
        fl2.add(new Fraction(5,2,3,1));
        fl2.add(new Fraction(3,4,2,1));
        FractionAggregation shouldBe = new FractionAggregation(fl2);
        assertTrue(f.equals(shouldBe));
        f.abs();
        assertTrue(f.equals(shouldBe));
    }

    @Test
    public void should_AbsReturnProperly_WhenThereIsTwoFractions_AndBothArePositive() throws IncorrectFractionException{
        ArrayList<Fraction> fl = new ArrayList<>();
        fl.add(new Fraction(3, 4, 2, 1));
        fl.add(new Fraction(5, 2, 3, 1));
        FractionAggregation f = new FractionAggregation(fl);
        f.abs();
        ArrayList<Fraction> fl2 = new ArrayList<>();
        fl2.add(new Fraction(5,2,3,1));
        fl2.add(new Fraction(3,4,2,1));
        FractionAggregation shouldBe = new FractionAggregation(fl2);
        assertTrue(f.equals(shouldBe));
        f.abs();
        assertTrue(f.equals(shouldBe));
    }

    @Test
    public void should_CompareToReturn1_WhenFirstIsBigger_AndBothHavOneFraction() throws IncorrectFractionException{
        Fraction f1 = new Fraction(5, 2, 2, 1);
        Fraction f2 = new Fraction(5, 2, 1, 1);
        Fraction f3 = new Fraction(-5, 2, 3, 1);
        FractionAggregation fa1 = new FractionAggregation(f1);
        FractionAggregation fa2 = new FractionAggregation(f2);
        FractionAggregation fa3 = new FractionAggregation(f3);
        assertTrue(fa1.compareTo(fa2) == 1);
        assertTrue(fa1.compareTo(fa3) == 1);
    }   

    @Test
    public void should_CompareToReturnMinus1_WhenFirstIsSmaller_AndBothHavOneFraction() throws IncorrectFractionException{
            Fraction f1 = new Fraction(5, 2, 2, 1);
            Fraction f2 = new Fraction(5, 2, 1, 1);
            Fraction f3 = new Fraction(-5, 2, 3, 1);
            FractionAggregation fa1 = new FractionAggregation(f1);
            FractionAggregation fa2 = new FractionAggregation(f2);
            FractionAggregation fa3 = new FractionAggregation(f3);
            assertTrue(fa2.compareTo(fa1) == -1);
            assertTrue(fa3.compareTo(fa1) == -1);
    }

    @Test
    public void should_CompareToReturnZero_WhenBothAreTheSame_AndHaveOneFraction() throws IncorrectFractionException{
        Fraction f1 = new Fraction(5,4,3,1);
        Fraction f2 = new Fraction(5,4,3,1);
        FractionAggregation fa1 = new FractionAggregation(f1);
        FractionAggregation fa2 = new FractionAggregation(f2);
        assertTrue(fa1.compareTo(fa2) == 0);
    }

    @Test
    public void should_CompareToReturnCorrectly_WhenBothHaveTwoElems() throws IncorrectFractionException{
        Fraction f1 = new Fraction(3,4,3,1);
        Fraction f2 = new Fraction(1,2);
        Fraction f3 = new Fraction(3,4);
        Fraction f4 = new Fraction(1,2,7,1);
        FractionAggregation fa1 = new FractionAggregation();
        FractionAggregation fa2 = new FractionAggregation();
        fa1.addFraction(f1);
        fa1.addFraction(f2);
        fa2.addFraction(f3);
        fa2.addFraction(f4);
        assertTrue(fa1.compareTo(fa2) == -1);
        fa1.clear();
        fa2.clear();
        fa1.addFraction(f2);
        fa1.addFraction(f3);
        fa2.addFraction(f1);
        fa2.addFraction(f4);
        assertTrue(fa2.compareTo(fa1) == 1);
        fa1.clear();
        fa2.clear();
        fa1.addFraction(f1);
        fa1.addFraction(f2);
        fa2.addFraction(f1);
        fa2.addFraction(f2);
        assertTrue(fa1.compareTo(fa2) == 0);
    }

    @Test
    public void should_CompareToReturnCorrectly_WhenOneHasOneFractions_AndSecondHasTwoFractions() throws IncorrectFractionException{
        Fraction f1 = new Fraction(1,2, 2, 1);
        Fraction f2 = new Fraction(3,4);
        Fraction f3 = new Fraction(1,4);
        FractionAggregation fa1 = new FractionAggregation(f1);
        fa1.addFraction(f3);
        FractionAggregation fa2 = new FractionAggregation(f2);
        assertTrue(fa1.compareTo(fa2) == 1);
    }
}
