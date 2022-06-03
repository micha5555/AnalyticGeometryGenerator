package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;

public class CircleTest {

    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowException_WhenRadiusIsZero() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(4, 2, 0);
    }
    
    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowException_WhenRadiusIsNegative() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(4, 2, -3);
    }

    @Test
    public void should_CorrectlyCountArea_WithNormalRadius() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(5, 3, 6);
        assertEquals(new FractionAggregation(new Fraction(2826, 25)), c.getArea());
    }

    @Test
    public void should_CorrectlyCountArea_WithVerySmallRadius() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(new Fraction(5,1), new Fraction(3,1), new Fraction(1, 1000));
        assertEquals(new FractionAggregation(new Fraction(157, 50000000)), c.getArea());
    }

    @Test
    public void should_CorrectlyCountArea_WithVeryBigRadius() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(new Fraction(5,1), new Fraction(3,1), new Fraction(1000, 1));
        assertEquals(new FractionAggregation(new Fraction(3140000, 1)), c.getArea());
    }

    @Test
    public void should_ToStringReturnCorrectly() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(-5, 3, 1);
        System.out.println(c.toString());
    }

    @Test
    public void should_EqualsReturnTrue_WhenBothCirclesAreTheSame() throws IllegalMathOperation, IncorrectFractionException{
        Circle c1 = new Circle(5, 3, 1);
        Circle c2 = new Circle(5, 3, 1);
        assertTrue(c1.equals(c2));
    }

    @Test
    public void should_CorrectlyCreateSquareInCircle() throws IllegalMathOperation, IncorrectFractionException{
        Circle c = new Circle(3, -2, 9);
        Square s = c.createSquareInCircle();
        Point actualA = s.getA();
        Point actualB = s.getB();
        ArrayList<Fraction> expectedAXList = new ArrayList<>();
        ArrayList<Fraction> expectedBXList = new ArrayList<>();
        ArrayList<Fraction> expectedAYList = new ArrayList<>();
        ArrayList<Fraction> expectedBYList = new ArrayList<>();
        expectedAXList.add(new Fraction(3, 1));
        expectedAXList.add(new Fraction(-9, 2, 2, 1));
        expectedAYList.add(new Fraction(-2, 1));
        expectedAYList.add(new Fraction(9, 2, 2, 1));
        Point expectedA = new Point(new FractionAggregation(expectedAXList), new FractionAggregation(expectedAYList));
        expectedBXList.add(new Fraction(3,1));
        expectedBXList.add(new Fraction(9, 2, 2, 1));
        expectedBYList.add(new Fraction(-2, 1));
        expectedBYList.add(new Fraction(-9, 2, 2, 1));
        Point expectedB = new Point(new FractionAggregation(expectedBXList), new FractionAggregation(expectedBYList));
        assertEquals(expectedA, actualA);
        assertEquals(expectedB, actualB);
    }

    @Test
    public void should_CorrectlyCreateSquareOnCircle() throws IncorrectFractionException, IllegalMathOperation{
        Circle c = new Circle(5,6,4);
        Square s = c.createSquareOnCircle();
        Point actualA = s.getA();
        Point actualB = s.getB();
        Point expectedA = new Point(1, 10);
        Point expectedB = new Point(9, 2);
        assertEquals(expectedA, actualA);
        assertEquals(expectedB, actualB);
    }

    // @Test
    // public void tttt() throws IllegalMathOperation, IncorrectFractionException, SamePointsException{
    //     Square s = new Square();
    //     System.out.println(s.getA());
    //     System.out.println(s.getB());
    //     System.out.println(s.getArea());
    //     System.out.println(s.getPerimeter());
    //     System.out.println(s.getSideLen());
    //     Circle c = s.createCircleOnSquare();
    //     System.out.println(c.toString());
    //     Line l = new Line();
    //     System.out.println(l.getFunc().toString());
    //     Fraction x = new Fraction(100, 13, 2, 3);
    //     System.out.println(x);
    //     FractionAggregation f = new FractionAggregation();
    //     f.addFraction(x);
    //     f.addFraction(new Fraction(3, 5));
    //     f.addFraction(new Fraction(1, 2));
    //     System.out.println(f.toString());
    // }
}
