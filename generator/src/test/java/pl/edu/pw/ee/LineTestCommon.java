package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.SamePointsException;

public abstract class LineTestCommon {
    
    public void comparePointsOfLine(Point p1, Point p2, Point p1expected, Point p2expected) throws SamePointsException{
        Line l = new Line(p1, p2);
        assertEquals(p1expected, l.getP1());
        assertEquals(p2expected, l.getP2());
    }

    public void checkFuncCorrectness(Point p1, Point p2, double yExpected, double aExpected, double bExpected) throws SamePointsException{
        Line l = new Line(p1, p2);
        Func func = l.getFunc();
        assertTrue(Double.compare(func.getY(), yExpected) == 0);
        assertTrue(Double.compare(func.getA(), aExpected) == 0);
        assertTrue(Double.compare(func.getB(), bExpected) == 0);
    }

    public void checkPerpendicularity(Point a1, Point a2, Point b1, Point b2, boolean tf) throws SamePointsException{
        Line l1 = new Line(a1, a2);
        Line l2 = new Line(b1, b2);
        assertEquals(tf, l1.checkPerpendicularity(l2));
    }

    public void checkSymmetrical(Line l, double yExpected, double aExpected, double bExpected){
        Func sym = l.getSymmetrical();
        System.out.println(sym);
        assertTrue(Double.compare(sym.getY(), yExpected) == 0);
        assertTrue(Double.compare(sym.getA(), aExpected) == 0);
        assertTrue(Double.compare(sym.getB(), bExpected) == 0);
    }

    public void checkLength(Line l, double expectedLen){
        assertTrue(Double.compare(l.getLength(), expectedLen) == 0);
    }

    public void checkMathVector(Line l, MathVector expectedVector){

    }
}
