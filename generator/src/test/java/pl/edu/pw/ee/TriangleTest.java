package pl.edu.pw.ee;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;

public class TriangleTest extends TriangleTestCommon{

    @Test
    public void should_ReturnCenterProperly_WhenTriangleIsNormal() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkCenter(new Triangle(new Point(1,2), new Point(new Fraction(3, 5), new Fraction(1, 2)), new Point(new Fraction(8,9), new Fraction(1, 3))), new Point(new Fraction(112, 135), new Fraction(17, 18)));
    }

    @Test
    public void should_ReturnCenterProperly_WhenSidesOfTraingleAreOnAxises() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkCenter(new Triangle(new Point(0,0), new Point(0,5), new Point(7,0)), new Point(new Fraction(7, 3), new Fraction(5,3)));
    }

    @Test
    public void should_ReturnCenterProperly_WhenCenterShouldBeInPointZeroZero() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkCenter(new Triangle(new Point(9,8), new Point(10, 1), new Point(-19,-9)), new Point(0,0));
    }

    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenAAndBAreTheSame() throws SamePointsException, IncorrectFractionException{
        Triangle t = new Triangle(new Point(1, 5), new Point(1, 5), new Point(3, 3));
    }
    
    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenAAndCAreTheSame() throws SamePointsException, IncorrectFractionException{
        Triangle t = new Triangle(new Point(1, 5), new Point(3,8), new Point(1,5));
    }

    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenBAndCAreTheSame() throws SamePointsException, IncorrectFractionException{
        Triangle t = new Triangle(new Point(1, 5), new Point(3,3), new Point(3, 3));
    }

    @Test
    public void should_CorrectlyReturnPerimeter_WhenPointsAreNormal() throws SamePointsException, IncorrectFractionException{
        Triangle t = new Triangle(new Point(5, 8), new Point(1, -5), new Point(-7, -11));
        FractionAggregation f = new FractionAggregation();
        f.addFraction(new Fraction(10,1));
        f.addFraction(new Fraction(1,1,185,1));
        f.addFraction(new Fraction(1, 1, 505, 1));
        this.checkPerimeter(t, f);
    }

    @Test
    public void should_CorrectlyReturnPerimeter_WhenSidesAreOnAxises() throws SamePointsException, IncorrectFractionException{
        Triangle t = new Triangle(new Point(0,0), new Point(0,8), new Point(11,0));
        FractionAggregation f = new FractionAggregation(new Fraction(19,1));
        f.addFraction(new Fraction(1, 1, 185, 1));
        this.checkPerimeter(t, f);
    }

    @Test
    public void should_CorrectlyReturnPerimeter_WhenPointsAreVerySmall() throws SamePointsException, IncorrectFractionException{
        Fraction neg = new Fraction(-1, 10000);
        Fraction pos = new Fraction(1, 10000);
        Triangle t = new Triangle(new Point(pos, pos), new Point(neg, neg), new Point(pos,neg));
        FractionAggregation exp = new FractionAggregation(new Fraction(1, 2500));
        exp.addFraction(new Fraction(1, 5000, 2, 1));
        this.checkPerimeter(t, exp);
    }

    @Test
    public void should_CorrectlyReturnArea_WhenPointsAreNormal() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Triangle t = new Triangle(new Point(-1, 5), new Point(8,6), new Point(-3,4));
        FractionAggregation exp = new FractionAggregation(new Fraction(7, 2));
        this.checkArea(t, exp);
    }

    @Test
    public void should_CorrectlyReturnArea_WhenSidesLayOnAxises() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Triangle t = new Triangle(new Point(0,0), new Point(0,6), new Point(4,0));
        FractionAggregation exp = new FractionAggregation(new Fraction(12, 1));
        this.checkArea(t, exp);
    }

    @Test
    public void should_CorrectlyReturnHeights_WhenPointsAreNormal() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Triangle t = new Triangle(new Point(-3, 2), new Point(5,5), new Point(-3,-1));
        FractionAggregation hAExpected = new FractionAggregation(new Fraction(12, 5));
        FractionAggregation hBExpected = new FractionAggregation(new Fraction(8, 1));
        FractionAggregation hCExpected = new FractionAggregation(new Fraction(24, 73, 73, 1));
        System.out.println(t.getSideAB().getLength().toString());
        this.checkHeights(t, hAExpected, hBExpected, hCExpected);
    }

    @Test
    public void should_CorrectlyReturnHeights_WhenSidesLayOnAxises() throws SamePointsException, IllegalMathOperation, IncorrectFractionException{
        Triangle t = new Triangle(new Point(0,0), new Point(5,0), new Point(0,10));
        FractionAggregation hAExpected = new FractionAggregation(new Fraction(2, 1, 5, 1));
        FractionAggregation hBExpected = new FractionAggregation(new Fraction(5, 1));
        FractionAggregation hCExpected = new FractionAggregation(new Fraction(10, 1));
        this.checkHeights(t, hAExpected, hBExpected, hCExpected);
    }
}
