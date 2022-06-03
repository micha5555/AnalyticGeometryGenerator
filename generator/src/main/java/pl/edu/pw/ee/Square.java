package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Figure;

public class Square implements Figure{

    private Point a, b;
    
    public Square() throws IllegalMathOperation, IncorrectFractionException{
        Random rand = new Random();
        Point one = new Point(rand.nextInt(8) - 8, rand.nextInt(8));
        int side;
        do{
            side = rand.nextInt(8);
        }while(side == 0);
        FractionAggregation sideFrac = new FractionAggregation(new Fraction(side, 1));
        a = one;
        b = new Point(FractionAggregation.addFA(one.getX(), sideFrac), FractionAggregation.addFA(one.getY(), sideFrac));
    }

    public Square(Point a, Point b) throws IllegalMathOperation{
        if(a.equals(b)){
            throw new IllegalMathOperation("Points cannot be the same");
        }
        checkSquare(a, b);
        this.a = a;
        this.b = b;
    }

    public Circle createCircleOnSquare() throws IncorrectFractionException, IllegalMathOperation, SamePointsException{
        Point center = getCenter();
        return new Circle(center.getX(), center.getY(), FractionAggregation.divideFA(getDiagonalLen(), new Fraction(2,1)));
    }

    public Circle createCircleInSquare() throws IncorrectFractionException, IllegalMathOperation, SamePointsException{
        Point center = getCenter();
        return new Circle(center.getX(), center.getY(), FractionAggregation.divideFA(getSideLen(), new FractionAggregation(new Fraction(2, 1))));
    }

    public FractionAggregation getDiagonalLen() throws SamePointsException, IncorrectFractionException{
        Line diagonal = new Line(a, b);
        FractionAggregation out = new FractionAggregation(diagonal.getLength());
        return out;
    }

    public FractionAggregation getSideLen() throws IncorrectFractionException, IllegalMathOperation, SamePointsException{
        return FractionAggregation.divideFA(getDiagonalLen(), new Fraction(1, 1, 2, 1));
    }

    public boolean checkIfPointInSquare(Point p){
        boolean xOk = false;
        boolean yOk = false;
        if(a.getX().compareTo(b.getX()) == 1){
            xOk = (p.getX().compareTo(a.getX()) < 1) && (p.getX().compareTo(b.getX()) > -1);
        }
        else{
            xOk = (p.getX().compareTo(b.getX()) < 1) && (p.getX().compareTo(a.getX()) > -1);
        }
        if(a.getY().compareTo(b.getY()) == 1){
            yOk = (p.getY().compareTo(a.getY()) < 1) && (p.getY().compareTo(b.getY()) > -1);
        }
        else{
            yOk = (p.getY().compareTo(b.getY()) < 1) && (p.getY().compareTo(a.getY()) > -1);
        }
        return xOk && yOk;
    }

	@Override
	public FractionAggregation getPerimeter() throws IncorrectFractionException {
        FractionAggregation sideLen = null;
        try {
            sideLen = FractionAggregation.divideFA(getDiagonalLen(), new Fraction(1, 1, 2, 1));
        } catch (SamePointsException e) {
            e.printStackTrace();
        } catch (IllegalMathOperation e) {
            e.printStackTrace();
        }
		return FractionAggregation.multiplyFA(sideLen, new FractionAggregation(new Fraction(4, 1)));
	}

	@Override
	public FractionAggregation getArea() throws IncorrectFractionException, IllegalMathOperation {
        FractionAggregation diagonalPow = null;
        try {
            diagonalPow = FractionAggregation.multiplyFA(getDiagonalLen(), getDiagonalLen());
        } catch (SamePointsException e) {
            e.printStackTrace();
        }
		return FractionAggregation.divideFA(diagonalPow, new FractionAggregation(new Fraction(2, 1)));
	}

    private void checkSquare(Point a, Point b) throws IllegalMathOperation{
        try {
            if(a.getX().equals(b.getX()) || a.getY().equals(b.getY())){
                throw new IllegalMathOperation("This is not square!");
            }
			FractionAggregation oneSide = FractionAggregation.subFA(a.getX(), b.getX());
            oneSide.abs();
            FractionAggregation secondSide = FractionAggregation.subFA(a.getY(), b.getY());
            secondSide.abs();
            if(!oneSide.equals(secondSide)){
                throw new IllegalMathOperation("This is not square!");
            }
		} catch (IncorrectFractionException e) {
			e.printStackTrace();
		}
    }

    private Point getCenter() throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation centerX = FractionAggregation.divideFA(FractionAggregation.addFA(a.getX(), b.getX()), new FractionAggregation(new Fraction(2, 1)));
        FractionAggregation centerY = FractionAggregation.divideFA(FractionAggregation.addFA(a.getY(), b.getY()), new FractionAggregation(new Fraction(2, 1)));
        return new Point(centerX, centerY);
    }
    
    //TODO: make copy
    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }
}
