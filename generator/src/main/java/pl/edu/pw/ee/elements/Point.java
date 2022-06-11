package pl.edu.pw.ee.elements;

import java.util.ArrayList;
import java.util.Random;

import pl.edu.pw.ee.Fraction;
import pl.edu.pw.ee.FractionAggregation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;

public class Point implements Element{
    private FractionAggregation x, y;
    public Point(){
        Random rand = new Random();
        try {
            x = new FractionAggregation(new Fraction(rand.nextInt(48) - 24, 2));
            y = new FractionAggregation(new Fraction(rand.nextInt(48) - 24, 2));
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
    }

    public Point(Fraction x, Fraction y){
        this(new FractionAggregation(x), new FractionAggregation(y));
    }

    public Point(FractionAggregation x, FractionAggregation y){
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y) throws IncorrectFractionException{
        this.x = new FractionAggregation(new Fraction(x, 1));
        this.y = new FractionAggregation(new Fraction(y, 1));
    }

    public Point(Fraction x, int y) throws IncorrectFractionException{
        this(x, new Fraction(y, 1));
    }

    public Point(int x, Fraction y) throws IncorrectFractionException{
        this(new Fraction(x, 1), y);
    }


    @Override
    public String toString(){
        return String.format("x=%s y=%s", x.toString(), y.toString());
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Point)){
            return false;
        }
        Point p = (Point) o;
        return (x.equals(p.x) && y.equals(p.y));
    }

    public FractionAggregation getX(){
        ArrayList<Fraction> tmp = new ArrayList<>();
        tmp.addAll(x.getList());
        return new FractionAggregation(tmp);
    }

    public FractionAggregation getY(){
        ArrayList<Fraction> tmp = new ArrayList<>();
        tmp.addAll(y.getList());
        return new FractionAggregation(tmp);
    }

}
