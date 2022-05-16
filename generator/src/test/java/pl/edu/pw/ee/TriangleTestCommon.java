package pl.edu.pw.ee;

import static org.junit.Assert.assertTrue;

public abstract class TriangleTestCommon {
    
    public void checkCenter(Triangle t, Point expectedCentre){
        Point actualCentre = t.getCenter();
        assertTrue(expectedCentre.equals(actualCentre));
    }

    public void checkPerimeter(Triangle t, double expectedPerimeter){
        double actualPerimeter = t.getPerimeter();
        assertTrue(Double.compare(actualPerimeter, expectedPerimeter) == 0);
    }

    public void checkArea(Triangle t, double expectedArea){
        double actualArea = t.getArea();
        assertTrue(Double.compare(actualArea, expectedArea) == 0);
    }

    public void checkHeights(Triangle t, double hAExpected, double hBExpected, double hCExpected){
        double actualA = t.getHeight(t.getA());
        double actualB = t.getHeight(t.getB());
        double actualC = t.getHeight(t.getC());
        assertTrue(Double.compare(actualA, hAExpected) == 0);
        assertTrue(Double.compare(actualB, hBExpected) == 0);
        assertTrue(Double.compare(actualC, hCExpected) == 0);
    }
}
