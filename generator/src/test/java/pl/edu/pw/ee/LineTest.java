package pl.edu.pw.ee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;


public class LineTest extends LineTestCommon
{

    @Test
    public void shouldProperlyAssignPoints_WhenXOfFirtstIsGreater() throws SamePointsException, IncorrectFractionException{
        Point p1 = new Point(1,2);
        Point p2 = new Point(new Fraction(1,2), 3);
        this.comparePointsOfLine(p1, p2, p2, p1);
    }

    @Test
    public void shouldProperlyAssignPoints_WhenXOfFirtstIsLower() throws SamePointsException, IncorrectFractionException{
        Point p1 = new Point(1,2);
        Point p2 = new Point(2, 3);
        this.comparePointsOfLine(p1, p2, p1, p2);
    }

    @Test
    public void should_ProperlyAssignPoints_WhenXOfFirtstAndSecondAreTheSame() throws SamePointsException, IncorrectFractionException{
        Point p1 = new Point(1,2);
        Point p2 = new Point(1, 3);
        this.comparePointsOfLine(p1, p2, p1, p2);
    }

    @Test
    public void should_ReturnProperlyFunc_WhenYAndBShouldBeZero() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 5);
        this.checkFuncCorrectness(p1, p2, 0, -1, 0);
    }

    @Test
    public void should_ReturnProperlyFunc_WhenAAndBShouldBeZero() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkFuncCorrectness(new Point(0, 0), new Point(5,0), 1, 0, 0);
    }

    @Test
    public void should_ReturnProperlyFunc_WhenBShouldBeZero() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkFuncCorrectness(new Point(0,0), new Point(5,5), 1, 1, 0);
    }

    @Test
    public void should_ProperlyCountCenter_WhenPointsAreNotTheSame() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l = new Line(new Point(3,4), new Point(6,2));
        Point center = l.getCenter();
        assertEquals(new Point(new Fraction(9,2),3), center);;
    }

    @Test
    public void should_ProperlyCountCenter_WhenThereIsCoordinateZeroInPoints() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l = new Line(new Point(0,0), new Point(7, new Fraction(7, 2)));
        Point center = l.getCenter();
        assertEquals(new Point(new Fraction(7, 2), new Fraction(7, 4)), center);
    }

    //TODO
    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenPointsAreTheSame() throws SamePointsException, IncorrectFractionException{
        Line l = new Line(new Point(1,2), new Point(1,2));
    }

    @Test
    public void checkPerpendicularity_should_ReturnTrue_WhenLinesArePerpendicularityAndAreNormalPoints() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkPerpendicularity(new Point(1,1), new Point(5,5), new Point(-6, 6), new Point(7, -7), true);
    }

    @Test
    public void checkPerpendicularity_should_ReturnFalse_WhenLinesAreNotPerpendicularityAndAreNormalPoints() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkPerpendicularity(new Point(1,1), new Point(5,5), new Point(-6, 6), new Point(7, -9), false);
    }

    @Test
    public void checkPerpendicularity_should_ReturnTrue_WhenLinesArePerpendicularityAndLinesAreParallelToAxises() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkPerpendicularity(new Point(1,1), new Point(5, 1), new Point(2,2), new Point(2, 3), true);
    }

    @Test
    public void checkPerpendicularity_should_ReturnTrue_WhenLinesArePerpendicularityAndLinesLayOnAxises() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkPerpendicularity(new Point(-5,0), new Point(11, 0), new Point(0,3), new Point(0, -5), true);
    }

    @Test
    public void getSymmetrical_should_returnProperly_WhenLineIsNormal() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkSymmetrical(new Line(new Point(5, 8), new Point(8, 10)), new Fraction(1, 1), new Fraction(-3, 2), new Fraction(75,4));
    }
    
    @Test
    public void getSymmetrical_should_returnProperly_WhenLineIsParallelToYAxis() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkSymmetrical(new Line(new Point(0,0), new Point(0, 9)), new Fraction(1, 1), new Fraction(0, 1), new Fraction(9, 2));
    }

    @Test
    public void getSymmetrical_should_returnProperly_WhenLineIsParallelToXAxis() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkSymmetrical(new Line(new Point(-3, 5), new Point(5, 5)), 0, -1, 1);
    }

    @Test
    public void getSymmetrical_should_returnProperly_WhenLineLaysOnXAxis() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkSymmetrical(new Line(new Point(-1, 0), new Point(6, 0)), new Fraction(0,1), new Fraction(-1,1), new Fraction(5,2));
    }

    @Test
    public void getSymmetrical_should_returnProperly_WhenLineLaysOnYAxis() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        this.checkSymmetrical(new Line(new Point(0, 11), new Point(0, -8)), new Fraction(1,1), new Fraction(0,1), new Fraction(3,2));
    }

    @Test
    public void should_ReturnLengthProperly_WhenPointsAreNormal() throws SamePointsException, IncorrectFractionException{
        this.checkLength(new Line(new Point(-3, 6), new Point(5, 9)), new Fraction(1, 1, 73,1));
    }

    @Test
    public void should_ReturnLengthProperly_WhenOnePointIsZeroZero() throws SamePointsException, IncorrectFractionException{
        this.checkLength(new Line(new Point(0,0), new Point(-5, -13)), new Fraction(1, 1, 194,1));
    }

    @Test
    public void should_ReturnLengthProperly_WhenItShouldBeTheSmallestPossible() throws SamePointsException, IncorrectFractionException{
        this.checkLength(new Line(new Point(0,0), new Point(0,new Fraction(1, 100))), new Fraction(1,100));
    }

    // @Test
    // public void should_ReturnVectorCorrectly_WhenLineIsNormal() throws SamePointsException{
    //     this.checkMathVector(new Line(new Point(5,3), new Point(7,-6)), new MathVector(2, -9));
    // }

    // @Test
    // public void should_ReturnVectorCorrectly_WhenOnePointIsZeroZero() throws SamePointsException{
    //     this.checkMathVector(new Line(new Point(0,0), new Point(3,5)), new MathVector(3,5));
    // }

    // @Test
    // public void should_ReturnVectorsCorrectly_WhenLinesLayOnAxises() throws SamePointsException{
    //     this.checkMathVector(new Line(new Point(-1,0), new Point(5,0)), new MathVector(6,0));
    //     this.checkMathVector(new Line(new Point(0,-7), new Point(0,8)), new MathVector(0,15));
    // }

    @Test
    public void should_CorrectlyCreateParrarelLine() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l;
        Line l2;
        for(int i = 0; i < 10000; i++){
            l = new Line();
            l2 = l.createParallelLine();
            // System.out.println(l.getP1() + " " + l.getP2() + " " + l2.getP1() + " " + l2.getP2());
            // if(!l.getFunc().getA().equals(l2.getFunc().getA())){
            //     // System.out.println(i);
            //     // System.out.println(l.getFunc());
            //     // System.out.println(l2.getFunc());
            //     // System.out.printf("f1 : (%f, %f) (%f, %f)\nf2 : (%f, %f) (%f, %f)\n", l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY(), l2.getP1().getX(), l2.getP1().getY(), l2.getP2().getX(), l2.getP2().getY());
            // }

            // System.out.println(l.getFunc().toString() + "   " + l2.getFunc().toString());
            assertTrue(l.checkParallelism(l2));
        }
    }

    @Test
    public void should_CorrectlyCreatePerpendicularityLines() throws IncorrectFractionException, IllegalMathOperation, SamePointsException{
        Line l, l2;
        for(int i = 0; i < 10000; i++){
            l = new Line();
            l2 = l.createPerpendicularityLine(l.getP1());
            assertTrue(l.checkPerpendicularity(l2));
        }
    }

    @Test
    public void should_CorrectlyCountTangent_WhenLinesAreNormal() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l1 = new Line(new Point(3, -2), new Point(2, 5));
        Line l2 = new Line(new Point(-3, -3), new Point(5, 4));
        FractionAggregation expTan = new FractionAggregation(new Fraction(63, 41));
        FractionAggregation actualTan = l1.getTangentOfAcuteAngleWithSecondLine(l2);
        assertEquals(expTan, actualTan);
    }

    @Test
    public void should_CountTanReturnZero_WhenLinesAreParrarel() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l1 = new Line(new Point(1, 1), new Point(3, 3));
        Line l2 = new Line(new Point(-5, -5), new Point(2, 2));
        FractionAggregation expTan = new FractionAggregation(new Fraction(0, 1));
        FractionAggregation actualTan = l1.getTangentOfAcuteAngleWithSecondLine(l2);
        assertEquals(expTan, actualTan);
    }

    //COś tu jest źle
    @Test(expected = IllegalMathOperation.class)
    public void should_ThrowExceptionWhileCountingTangent_WhenLinesArePerdpendicular() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Line l1 = new Line(new Point(1, 1), new Point(5, 5));
        Line l2 = new Line(new Point(3, 3), new Point(8, -2));
        FractionAggregation tan = l1.getTangentOfAcuteAngleWithSecondLine(l2);
    }
    // @Test
    // public void ttt() throws SamePointsException{
    //     Line l = new Line(new Point(0, 3), new Point(0, 0));
    //     Line l2 = l.createParallelLine();
    //     System.out.println(l.getFunc());
    //     System.out.println(l2.getFunc());
    //     assertTrue(l.checkParallelism(l2));
    // }

    // @Test
    // public void tt() throws SamePointsException{
    //     Line l = new Line(new Point(-9,-12), new Point(3,7));
    //     Line l2 = l.createParallelLine();
    //     System.out.println(l.getFunc());
    //     System.out.println(l2.getFunc());
    // }

    // @Test
    // public void parrarelDontWork() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
    //     Line l = new Line(new Point(new Fraction(1,1), new Fraction(9,2)), new Point(new Fraction(4,1), new Fraction(21,2)));
    //     Line l2 = l.createParallelLine();
    //     System.out.println(l2.getP1().toString());
    //     System.out.println(l2.getP2().toString());
    // }

    // @Test
    // public void ttt() throws IncorrectFractionException, SamePointsException, IllegalMathOperation{
    //     Line l = new Line(new Point(new Fraction(-12, 1), new Fraction(-23, 2)), new Point(new Fraction(-10, 1), new Fraction(5, 1)));
    //     System.out.println(l.getP1() + " " + l.getP2());
    //     Line l2 = l.createParallelLine();
    //     System.out.println();
    //     System.out.println(l.getP1() + " " + l.getP2());
    //     System.out.println(l2.getP1() + " " + l2.getP2());
    // }

    // @Test
    // public void testttttt() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
    //     Line[] tab = new Line[10];
    //     for(int i = 0; i < 10; i++){
    //         tab[i] = new Line();
    //         System.out.println(tab[i].getP1().toString() + " " + tab[i].getP2().toString());
    //     }

    //     System.out.println();

    //     for(int i = 0; i < 10; i++){
    //         Line l = tab[i].createParallelLine();
    //         System.out.println(tab[i].getP1().toString() + " " + tab[i].getP2().toString());
    //     }
    // }

    // @Test
    // public void t() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
    //     Line l = new Line(new Point(new Fraction(7, 2), new Fraction(8, 1)), new Point(new Fraction(7, 2), new Fraction(-12, 1)));
    //     System.out.println(l.getFunc().toString());
    //     Line l2 = l.createParallelLine();
    //     System.out.println(l2.getFunc().toString());
    //     System.out.println(l.getFunc().toString());
    // }

    // @Test
    // public void ewrw() throws IncorrectFractionException{
    //     FractionAggregation f1 = new FractionAggregation(new Fraction(21, 2));
    //     FractionAggregation f2 = new FractionAggregation(new Fraction(5, 1));
    //     FractionAggregation out = FractionAggregation.subFA(f1, f2);
    //     System.out.println(out.toString());
    // }
}
