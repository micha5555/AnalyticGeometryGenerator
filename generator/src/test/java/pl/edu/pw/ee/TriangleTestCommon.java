package pl.edu.pw.ee;

import static org.junit.Assert.assertTrue;

import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Triangle;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public abstract class TriangleTestCommon {
    
    public void checkCenter(Triangle t, Point expectedCentre) throws IncorrectFractionException, IllegalMathOperation{
        Point actualCentre = t.getCenter();
        assertTrue(expectedCentre.equals(actualCentre));
    }

    public void checkPerimeter(Triangle t, FractionAggregation expectedPerimeter) throws IncorrectFractionException{
        FractionAggregation actualPerimeter = t.getPerimeter();
        assertTrue(actualPerimeter.equals(expectedPerimeter));
    }

    public void checkArea(Triangle t, FractionAggregation expectedArea) throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation actualArea = t.getArea();
        assertTrue(actualArea.equals(expectedArea));
    }

    public void checkHeights(Triangle t, FractionAggregation hAExpected, FractionAggregation hBExpected, FractionAggregation hCExpected) throws IllegalMathOperation, IncorrectFractionException{
        FractionAggregation actualA = t.getHeight(t.getA());
        FractionAggregation actualB = t.getHeight(t.getB());
        FractionAggregation actualC = t.getHeight(t.getC());
        assertTrue(actualA.equals(hAExpected));
        assertTrue(actualB.equals(hBExpected));
        assertTrue(actualC.equals(hCExpected));
    }
}
