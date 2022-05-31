package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;

public abstract class LineTestCommon {
    
    public void comparePointsOfLine(Point p1, Point p2, Point p1expected, Point p2expected) throws SamePointsException{
        Line l = new Line(p1, p2);
        assertEquals(p1expected, l.getP1());
        assertEquals(p2expected, l.getP2());
    }

    public void checkFuncCorrectness(Point p1, Point p2, int yExpected, int aExpected, int bExpected) throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        checkFuncCorrectness(p1, p2, new Fraction(yExpected, 1), new Fraction(aExpected, 1), new Fraction(bExpected, 1));
    }

    public void checkFuncCorrectness(Point p1, Point p2, Fraction yExpected, Fraction aExpected, Fraction bExpected) throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        checkFuncCorrectness(p1, p2, new FractionAggregation(yExpected), new FractionAggregation(aExpected), new FractionAggregation(bExpected));
    }

    public void checkFuncCorrectness(Point p1, Point p2, FractionAggregation yExpected, FractionAggregation aExpected, FractionAggregation bExpected) throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l = new Line(p1, p2);
        Func func = l.getFunc();
        assertTrue(func.getY().equals(yExpected));
        assertTrue(func.getA().equals(aExpected));
        assertTrue(func.getB().equals(bExpected));
    }

    public void checkPerpendicularity(Point a1, Point a2, Point b1, Point b2, boolean tf) throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l1 = new Line(a1, a2);
        Line l2 = new Line(b1, b2);
        assertEquals(tf, l1.checkPerpendicularity(l2));
    }

    public void checkSymmetrical(Line l, int yExpected, int aExpected, int bExpected) throws IncorrectFractionException, IllegalMathOperation{
        checkSymmetrical(l, new Fraction(yExpected,1), new Fraction(aExpected,1), new Fraction(bExpected,1));
    }

    public void checkSymmetrical(Line l, Fraction yExpected, Fraction aExpected, Fraction bExpected) throws IncorrectFractionException, IllegalMathOperation{
        checkSymmetrical(l, new FractionAggregation(yExpected), new FractionAggregation(aExpected), new FractionAggregation(bExpected));
    }

    public void checkSymmetrical(Line l, FractionAggregation yExpected, FractionAggregation aExpected, FractionAggregation bExpected) throws IncorrectFractionException, IllegalMathOperation{
        Func sym = l.getSymmetrical();
        System.out.println(sym);
        assertTrue(sym.getY().equals(yExpected));
        assertTrue(sym.getA().equals(aExpected));
        assertTrue(sym.getB().equals(bExpected));
    }

    public void checkLength(Line l, Fraction expectedLen) throws IncorrectFractionException{
        assertTrue(l.getLength().equals(expectedLen));
    }

    public void checkMathVector(Line l, MathVector expectedVector){

    }
}
