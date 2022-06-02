package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

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
    public void should_EqualsREturnTrue_WhenBothCirclesAreTheSame() throws IllegalMathOperation, IncorrectFractionException{
        Circle c1 = new Circle(5, 3, 1);
        Circle c2 = new Circle(5, 3, 1);
        assertTrue(c1.equals(c2));
    }
}
