package pl.edu.pw.ee;

import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class Func {
    private Fraction y = new Fraction(1,1);
    private Fraction a;
    private Fraction b;
    public Func(Fraction y, Fraction a, Fraction b) throws IncorrectFractionException{
        this.y = y;
        if(y.getNumerator() == 0){
            this.a = new Fraction(-a.getNumerator(), a.getDenominator());
        }
        else{
            this.a = a;
        }
        this.b = b;
    }

    public Fraction[] getFunc(){
        return new Fraction[]{y, a, b};
    }

    public Fraction getY(){
        return y;
    }

    public Fraction getA(){
        return a;
    }

    public Fraction getB(){
        return b;
    }

    @Override
    public String toString(){
        return String.format("%sy=%sx+%s", y.toString(), a.toString(), b.toString());
    }
    
}
