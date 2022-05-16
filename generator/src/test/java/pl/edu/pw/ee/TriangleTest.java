package pl.edu.pw.ee;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.SamePointsException;

public class TriangleTest extends TriangleTestCommon{

    @Test
    public void should_ReturnCenterProperly_WhenTriangleIsNormal() throws SamePointsException{
        this.checkCenter(new Triangle(new Point(1,2), new Point(3,5), new Point(6,9)), new Point(3.33,5.33));
    }

    @Test
    public void should_ReturnCenterProperly_WhenSidesOfTraingleAreOnAxises() throws SamePointsException{
        this.checkCenter(new Triangle(new Point(0,0), new Point(0,5), new Point(7,0)), new Point(2.33, 1.67));
    }

    @Test
    public void should_ReturnCenterProperly_WhenCenterShouldBeInPointZeroZero() throws SamePointsException{
        this.checkCenter(new Triangle(new Point(9,8), new Point(10, 1), new Point(-19,-9)), new Point(0,0));
    }

    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenAAndBAreTheSame() throws SamePointsException{
        Triangle t = new Triangle(new Point(1, 5), new Point(1, 5), new Point(3, 3));
    }
    
    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenAAndCAreTheSame() throws SamePointsException{
        Triangle t = new Triangle(new Point(1, 5), new Point(3,8), new Point(1,5));
    }

    @Test(expected = SamePointsException.class)
    public void should_ThrowException_WhenBAndCAreTheSame() throws SamePointsException{
        Triangle t = new Triangle(new Point(1, 5), new Point(3,3), new Point(3, 3));
    }

    @Test
    public void should_CorrectlyReturnPerimeter_WhenPointsAreNormal() throws SamePointsException{
        Triangle t = new Triangle(new Point(5, 8), new Point(1, -5), new Point(-7, -11));
        this.checkPerimeter(t, 46.07);
    }

    @Test
    public void should_CorrectlyReturnPerimeter_WhenSidesAreOnAxises() throws SamePointsException{
        Triangle t = new Triangle(new Point(0,0), new Point(0,8), new Point(11,0));
        this.checkPerimeter(t, 32.6);
    }

    @Test
    public void should_CorrectlyReturnPerimeter_WhenPointsAreSmallAsPossible() throws SamePointsException{
        Triangle t = new Triangle(new Point(0.01, 0.01), new Point(-0.01,-0.01), new Point(0.01,-0.01));
        this.checkPerimeter(t, 0.07);
    }

    @Test
    public void should_CorrectlyReturnArea_WhenPointsAreNormal() throws SamePointsException{
        Triangle t = new Triangle(new Point(-1, 5), new Point(8,6), new Point(-3,-4));
        this.checkArea(t, 39.5);
    }

    @Test
    public void should_CorrectlyReturnArea_WhenSidesLayOnAxises() throws SamePointsException{
        Triangle t = new Triangle(new Point(0,0), new Point(0,6), new Point(4,0));
        this.checkArea(t, 12);
    }

    @Test
    public void should_CorrectlyReturnHeights_WhenPointsAreNormal() throws SamePointsException{
        Triangle t = new Triangle(new Point(-3, 2), new Point(5,5), new Point(-3,-1));
        this.checkHeights(t, 2.4, 8, 2.81);
    }

    @Test
    public void should_CorrectlyReturnHeights_WhenSidesLayOnAxises() throws SamePointsException{
        Triangle t = new Triangle(new Point(0,0), new Point(5,0), new Point(0,10));
        this.checkHeights(t, 4.47, 5, 10);
    }

    @Test
    public void should_CorrectlyReturnHeights_WhenPointsAreTheSmallest() throws SamePointsException{
        Triangle t = new Triangle(new Point(0,0.01), new Point(0.01,0), new Point(0,0));
        this.checkHeights(t, 0.01, 0.01, 0.01);  
    }
}
