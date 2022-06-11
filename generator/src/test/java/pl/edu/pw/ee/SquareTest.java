package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pw.ee.elements.Circle;
import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Square;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;

public class SquareTest {

    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowsException_WhenSidesAreNotTheSame() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(-3, 2), new Point(9, -5));
    }

    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowsException_WhenBothXAreTheSame() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(5, 6), new Point(5, -4));
    }

    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowsException_WhenBothYAreTheSame() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(5, -4), new Point(8, -4));
    }

    @Test
    public void should_CorrectlyCountPerimeter_AndArea() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(4, -1), new Point(-6, 9));
        assertEquals(new FractionAggregation(new Fraction(40, 1)), s.getPerimeter());
        assertEquals(new FractionAggregation(new Fraction(100, 1)), s.getArea());
    }

    @Test
    public void should_CorrectlyCreateCircleOnSquare() throws IllegalMathOperation, IncorrectFractionException, SamePointsException{
        Square s = new Square(new Point(-3, -3), new Point(5, 5));
        Circle c = s.createCircleOnSquare();
        assertEquals(new FractionAggregation(new Fraction(1, 1)), c.getCenter().getX());
        assertEquals(new FractionAggregation(new Fraction(1, 1)), c.getCenter().getY());
        assertEquals(new FractionAggregation(new Fraction(4, 1, 2, 1)), c.getRadius());
    }

    @Test
    public void should_CorrectlyCreateCircleInSquare() throws IncorrectFractionException, IllegalMathOperation, SamePointsException{
        Square s = new Square(new Point(-2, -3), new Point(2, -7));
        Circle c = s.createCircleInSquare();
        assertEquals(new FractionAggregation(new Fraction(0, 1)), c.getCenter().getX());
        assertEquals(new FractionAggregation(new Fraction(-5, 1)), c.getCenter().getY());
        assertEquals(new FractionAggregation(new Fraction(2, 1)), c.getRadius());
    }

    @Test
    public void should_ReturnTrue_WhenPointIsInSquare() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(-3, -3), new Point(4, 4));
        assertTrue(s.checkIfPointInSquare(new Point(1, 2)));
    }

    @Test
    public void should_ReturnTrue_WhenPointIsOnSideOfSquare() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(-3, -3), new Point(4, 4));
        assertTrue(s.checkIfPointInSquare(new Point(-3, 2)));
    }

    @Test
    public void should_ReturnTrue_WhenPointIsInTheCornerOfSquare() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(-3, -3), new Point(4, 4));
        assertTrue(s.checkIfPointInSquare(new Point(-3, 4)));
    }

    @Test
    public void should_ReturnFalse_WhenPointIsOutOfSquare() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square(new Point(0, 0), new Point(5, 5));
        assertTrue(!s.checkIfPointInSquare(new Point(-1, 4)));
    }

    @Test
    public void should_CorrectlyCreateRandomSquare() throws IllegalMathOperation, IncorrectFractionException{
        Square s = null;
        FractionAggregation twelve = new FractionAggregation(new Fraction(12, 1));
        FractionAggregation mTwelve = new FractionAggregation(new Fraction(-12, 1));
        for(int i = 0; i < 1000; i++){
            s = new Square();
            assertTrue(s.getA().getX().compareTo(twelve) < 1);
            assertTrue(s.getA().getX().compareTo(mTwelve) > -1);
            assertTrue(s.getA().getY().compareTo(twelve) < 1);
            assertTrue(s.getA().getY().compareTo(mTwelve) > -1);
        }
    }
}
