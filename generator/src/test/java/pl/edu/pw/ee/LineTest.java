package pl.edu.pw.ee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.SamePointsException;


public class LineTest extends LineTestCommon
{

    // @Test
    // public void shouldProperlyAssignPoints_WhenXOfFirtstIsGreater() throws SamePointsException{
    //     Point p1 = new Point(1,2);
    //     Point p2 = new Point(0.5, 3);
    //     this.comparePointsOfLine(p1, p2, p2, p1);
    // }

    // @Test
    // public void shouldProperlyAssignPoints_WhenXOfFirtstIsLower() throws SamePointsException{
    //     Point p1 = new Point(1,2);
    //     Point p2 = new Point(2, 3);
    //     this.comparePointsOfLine(p1, p2, p1, p2);
    // }

    // @Test
    // public void should_ProperlyAssignPoints_WhenXOfFirtstAndSecondAreTheSame() throws SamePointsException{
    //     Point p1 = new Point(1,2);
    //     Point p2 = new Point(1, 3);
    //     this.comparePointsOfLine(p1, p2, p1, p2);
    // }

    // @Test
    // public void should_ReturnProperlyFunc_WhenYAndBShouldBeZero() throws SamePointsException{
    //     Point p1 = new Point(0, 0);
    //     Point p2 = new Point(0, 5);
    //     this.checkFuncCorrectness(p1, p2, 0, -1, 0);
    // }

    // @Test
    // public void should_ReturnProperlyFunc_WhenAAndBShouldBeZero() throws SamePointsException{
    //     this.checkFuncCorrectness(new Point(0, 0), new Point(5,0), 1, 0, 0);
    // }

    // @Test
    // public void should_ReturnProperlyFunc_WhenBShouldBeZero() throws SamePointsException{
    //     this.checkFuncCorrectness(new Point(0,0), new Point(5,5), 1, 1, 0);
    // }

    // @Test
    // public void should_ProperlyCountCenter_WhenPointsAreNotTheSame() throws SamePointsException{
    //     Line l = new Line(new Point(3,4), new Point(6,2));
    //     Point center = l.getCenter();
    //     assertEquals(new Point(4.5,3), center);;
    // }

    // @Test
    // public void should_ProperlyCountCenter_WhenThereIsCoordinateZeroInPoints() throws SamePointsException{
    //     Line l = new Line(new Point(0,0), new Point(7, 3.5));
    //     Point center = l.getCenter();
    //     assertEquals(new Point(3.5, 1.75), center);
    // }

    // //TODO
    // @Test(expected = SamePointsException.class)
    // public void should_ThrowException_WhenPointsAreTheSame() throws SamePointsException{
    //     Line l = new Line(new Point(1,2), new Point(1,2));
    // }

    // @Test
    // public void checkPerpendicularity_should_ReturnTrue_WhenLinesArePerpendicularityAndAreNormalPoints() throws SamePointsException{
    //     this.checkPerpendicularity(new Point(1,1), new Point(5,5), new Point(-6, 6), new Point(7, -7), true);
    // }

    // @Test
    // public void checkPerpendicularity_should_ReturnFalse_WhenLinesAreNotPerpendicularityAndAreNormalPoints() throws SamePointsException{
    //     this.checkPerpendicularity(new Point(1,1), new Point(5,5), new Point(-6, 6), new Point(7, -9), false);
    // }

    // @Test
    // public void checkPerpendicularity_should_ReturnTrue_WhenLinesArePerpendicularityAndLinesAreParallelToAxises() throws SamePointsException{
    //     this.checkPerpendicularity(new Point(1,1), new Point(5, 1), new Point(2,2), new Point(2, 3), true);
    // }

    // @Test
    // public void checkPerpendicularity_should_ReturnTrue_WhenLinesArePerpendicularityAndLinesLayOnAxises() throws SamePointsException{
    //     this.checkPerpendicularity(new Point(-5,0), new Point(11, 0), new Point(0,3), new Point(0, -5), true);
    // }

    // @Test
    // public void getSymmetrical_should_returnProperly_WhenLineIsNormal() throws SamePointsException{
    //     this.checkSymmetrical(new Line(new Point(5, 8), new Point(8, 10)), 1, -1.49, 18.69);
    // }
    
    // @Test
    // public void getSymmetrical_should_returnProperly_WhenLineIsParallelToYAxis() throws SamePointsException{
    //     this.checkSymmetrical(new Line(new Point(0,0), new Point(0, 9)), 1, 0, 4.5);
    // }

    // @Test
    // public void getSymmetrical_should_returnProperly_WhenLineIsParallelToXAxis() throws SamePointsException{
    //     this.checkSymmetrical(new Line(new Point(-3, 5), new Point(5, 5)), 0, -1, 1);
    // }

    // @Test
    // public void getSymmetrical_should_returnProperly_WhenLineLaysOnXAxis() throws SamePointsException{
    //     this.checkSymmetrical(new Line(new Point(-1, 0), new Point(6, 0)), 0, -1, 2.5);
    // }

    // @Test
    // public void getSymmetrical_should_returnProperly_WhenLineLaysOnYAxis() throws SamePointsException{
    //     this.checkSymmetrical(new Line(new Point(0, 11), new Point(0, -8)), 1, 0, 1.5);
    // }

    // @Test
    // public void should_ReturnLengthProperly_WhenPointsAreNormal() throws SamePointsException{
    //     this.checkLength(new Line(new Point(-3, 6), new Point(5, 9)), 8.54);
    // }

    // @Test
    // public void should_ReturnLengthProperly_WhenOnePointIsZeroZero() throws SamePointsException{
    //     this.checkLength(new Line(new Point(0,0), new Point(-5, -13)), 13.93);
    // }

    // @Test
    // public void should_ReturnLengthProperly_WhenItShouldBeTheSmallestPossible() throws SamePointsException{
    //     this.checkLength(new Line(new Point(0,0), new Point(0,0.01)), 0.01);
    // }

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

    // @Test
    // public void should_CorrectlyCreateParrarelLine() throws SamePointsException{
    //     Line l;
    //     Line l2;
    //     Func lf;
    //     Func lf2;
    //     for(int i = 0; i < 100000; i++){
    //         l = new Line();
    //         l2 = l.createParallelLine();
    //         if(Double.compare(l.getFunc().getA(), l2.getFunc().getA()) != 0){
    //             System.out.println(i);
    //             System.out.println(l.getFunc());
    //             System.out.println(l2.getFunc());
    //             System.out.printf("f1 : (%f, %f) (%f, %f)\nf2 : (%f, %f) (%f, %f)\n", l.getP1().getX(), l.getP1().getY(), l.getP2().getX(), l.getP2().getY(), l2.getP1().getX(), l2.getP1().getY(), l2.getP2().getX(), l2.getP2().getY());
    //         }
    //         assertTrue(l.checkParallelism(l2));
    //     }
    // }
    // // @Test
    // // public void ttt() throws SamePointsException{
    // //     Line l = new Line(new Point(0, 3), new Point(0, 0));
    // //     Line l2 = l.createParallelLine();
    // //     System.out.println(l.getFunc());
    // //     System.out.println(l2.getFunc());
    // //     assertTrue(l.checkParallelism(l2));
    // // }

    // @Test
    // public void tt() throws SamePointsException{
    //     Line l = new Line(new Point(-9,-12), new Point(3,7));
    //     Line l2 = l.createParallelLine();
    //     System.out.println(l.getFunc());
    //     System.out.println(l2.getFunc());
    // }
}
