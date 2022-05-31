package pl.edu.pw.ee;

import java.util.ArrayList;

import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class Func {
    private FractionAggregation y = new FractionAggregation(new Fraction(1,1));
    private FractionAggregation a;
    private FractionAggregation b;
    public Func(Fraction y, Fraction a, Fraction b) throws IncorrectFractionException{
        this(new FractionAggregation(y), new FractionAggregation(a), new FractionAggregation(b));
    }

    public Func(FractionAggregation y, FractionAggregation a, FractionAggregation b) throws IncorrectFractionException{
        this.y = y;
        if(y.getSize() == 1 && y.getFraction(0).getNumerator() == 0){
            this.a = new FractionAggregation(new Fraction(-a.getFraction(0).getNumerator(), a.getFraction(0).getDenominator()));
        }
        else{
            this.a = a;
        }
        this.b = b;
    }

    public FractionAggregation[] getFunc(){
        ArrayList<Fraction> tmp1 = new ArrayList<>();
        tmp1.addAll(y.getList());
        ArrayList<Fraction> tmp2 = new ArrayList<>();
        tmp2.addAll(a.getList());
        ArrayList<Fraction> tmp3 = new ArrayList<>();
        tmp3.addAll(b.getList());
        return new FractionAggregation[]{new FractionAggregation(tmp1), new FractionAggregation(tmp2), new FractionAggregation(tmp3)};
    }

    public FractionAggregation getY(){
        ArrayList<Fraction> tmp = new ArrayList<>();
        tmp.addAll(y.getList());
        return new FractionAggregation(tmp);
    }

    public FractionAggregation getA(){
        ArrayList<Fraction> tmp = new ArrayList<>();
        tmp.addAll(a.getList());
        return new FractionAggregation(tmp);
    }

    public FractionAggregation getB(){
        ArrayList<Fraction> tmp = new ArrayList<>();
        tmp.addAll(b.getList());
        return new FractionAggregation(tmp);
    }

    @Override
    public String toString(){
        return String.format("%sy=%sx+%s", y.toString(), a.toString(), b.toString());
    }
    
}
