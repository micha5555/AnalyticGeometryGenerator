package pl.edu.pw.ee;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Figure;

public class Triangle implements Figure{
    private Point a, b, c;
    private Line sideAB, sideBC, sideAC;

    public Triangle() throws SamePointsException{
        a = new Point();
        b = new Point();
        c = new Point();
        do{
            b = new Point();
        }while(a.equals(b));
        do{
            c = new Point();
        }while(a.equals(c) || b.equals(c));
        assignSides();
    }

    public Triangle(Point a, Point b, Point c) throws SamePointsException{
        this.a = a;
        this.b = b;
        this.c = c;
        if(a.equals(b) || a.equals(c) || b.equals(c)){
            throw new SamePointsException("Some points in triangle are the same!");
        }
        assignSides();
    }

    @Override
    public FractionAggregation getPerimeter() throws IncorrectFractionException {
        FractionAggregation perimeter = new FractionAggregation(new Fraction(0, 1));
        perimeter = FractionAggregation.addFA(sideAB.getLength(), sideBC.getLength());
        perimeter = FractionAggregation.addFA(perimeter, sideAC.getLength());
        return perimeter;
    }

    @Override
    public FractionAggregation getArea() throws IncorrectFractionException, IllegalMathOperation {
        FractionAggregation xbxa = FractionAggregation.subFA(b.getX(), a.getX());
        FractionAggregation ycya = FractionAggregation.subFA(c.getY(), a.getY());
        FractionAggregation ybya = FractionAggregation.subFA(b.getY(), a.getY());
        FractionAggregation xcxa = FractionAggregation.subFA(c.getX(), a.getX());

        FractionAggregation xbxaycya = FractionAggregation.multiplyFA(xbxa, ycya);
        FractionAggregation ybyaxcxa = FractionAggregation.multiplyFA(ybya, xcxa);

        FractionAggregation sub = FractionAggregation.subFA(xbxaycya, ybyaxcxa);
        sub.abs();
        sub = FractionAggregation.divideFA(sub, new FractionAggregation(new Fraction(2, 1)));
        return sub;
    }

    public Point getCenter() throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation x = FractionAggregation.addFA(a.getX(), b.getX());
        x = FractionAggregation.addFA(x, c.getX());
        x = FractionAggregation.divideFA(x, new Fraction(3, 1));

        FractionAggregation y = FractionAggregation.addFA(a.getY(), b.getY());
        y = FractionAggregation.addFA(y, c.getY());
        y = FractionAggregation.divideFA(y, new Fraction(3, 1));
        return new Point(x, y);
    }

    public FractionAggregation getHeight(Point p) throws IllegalMathOperation, IncorrectFractionException{
        Line tmp;
        if(p.equals(a)){
            tmp = sideBC;
        }else if(p.equals(b)){
            tmp = sideAC;
        }else if(p.equals(c)){
            tmp = sideAB;
        }
        else{
            throw new IllegalMathOperation("Point must be one of the apec of triangle!");
        }
        return FractionAggregation.divideFA(FractionAggregation.multiplyFA(getArea(), new FractionAggregation(new Fraction(2, 1))), tmp.getLength());
    }

    public Line getSideAB(){
        return sideAB;
    }

    public Line getSideBC(){
        return sideBC;
    }

    public Line getSideAC(){
        return sideAC;
    }

    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }

    public Point getC(){
        return c;
    }
    private void assignSides() throws SamePointsException{
        sideAB = new Line(a, b);
        sideBC = new Line(b, c);
        sideAC = new Line(a, c);
    }
}
