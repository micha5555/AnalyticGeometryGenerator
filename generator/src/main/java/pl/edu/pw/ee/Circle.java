package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Figure;

public class Circle implements Figure{

    FractionAggregation a, b, r, r2;
    private static FractionAggregation PI;


	public Circle() throws IncorrectFractionException{
        Random rand = new Random();
        int aa = rand.nextInt(10) - 5;
        int bb = rand.nextInt(10) - 5;
        int rr;
        do{
            rr = rand.nextInt(14) - 7;
        }while(rr == 0);
        a = new FractionAggregation(new Fraction(aa, 1));
        b = new FractionAggregation(new Fraction(bb, 1));
        r = new FractionAggregation(new Fraction(rr, 1));
        r2 = FractionAggregation.multiplyFA(r, r);
        PI = new FractionAggregation(new Fraction(314, 100));
    }

    public Circle(int a, int b, int r) throws IllegalMathOperation, IncorrectFractionException{
        this(new Fraction(a, 1), new Fraction(b, 1), new Fraction(r, 1));
    }

    public Circle(Fraction a, Fraction b, Fraction r) throws IllegalMathOperation, IncorrectFractionException{
        this(new FractionAggregation(a), new FractionAggregation(b), new FractionAggregation(r));
    }

    public Circle(FractionAggregation a, FractionAggregation b, FractionAggregation r) throws IllegalMathOperation, IncorrectFractionException{
        if(r.compareTo(new FractionAggregation(new Fraction(0, 1))) < 1){
            throw new IllegalMathOperation("Radius cannot be negative or equals to zero!");
        }
        this.a = a;
        this.b = b;
        this.r = r;
        r2 = FractionAggregation.multiplyFA(r, r);
        PI = new FractionAggregation(new Fraction(314, 100));
    }

    public Point getCenter(){
        return new Point(a, b);
    }

	@Override
	public FractionAggregation getPerimeter() throws IncorrectFractionException {
		return FractionAggregation.multiplyFA(FractionAggregation.multiplyFA(new FractionAggregation(new Fraction(2, 1)), PI), r);
	}

	@Override
	public FractionAggregation getArea() throws IncorrectFractionException, IllegalMathOperation {
		return FractionAggregation.multiplyFA(PI, r2);
	}

    @Override
    public String toString(){
        FractionAggregation zero = new FractionAggregation();
		try {
			zero = new FractionAggregation(new Fraction(0, 1));
		} catch (IncorrectFractionException e) {
			e.printStackTrace();
		}
        String out = "(x";
        if(a.compareTo(zero) == 0){
            ;
        }
        else{
            out += "-" + a;
        }
        out += ")^2+(y";
        if(b.compareTo(zero) == 0){
            ;
        }
        else{
            out += "-" + b;
        }
        out += ")^2=" + r2;
        return out;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Circle)){
            return false;
        }
        Circle p = (Circle) o;
        return (a.equals(p.a) && b.equals(p.b) && r.equals(p.r));
    }
    
}
