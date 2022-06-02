package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Figure;

public class Square implements Figure{

    Point a, b;
    
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

	@Override
	public FractionAggregation getPerimeter() throws IncorrectFractionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FractionAggregation getArea() throws IncorrectFractionException, IllegalMathOperation {
		// TODO Auto-generated method stub
		return null;
	}

    private void checkSquare(Point a, Point b) throws IllegalMathOperation{
        try {
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
    
    //TODO: make copy
    public Point getA(){
        return a;
    }

    public Point getB(){
        return b;
    }
}
