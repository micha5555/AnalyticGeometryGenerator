package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class Point {
    private Fraction x, y;
    public Point(){
        Random rand = new Random();
        try {
            x = new Fraction(rand.nextInt(48) - 24, 2);
            y = new Fraction(rand.nextInt(48) - 24, 2);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
    }

    public Point(Fraction x, Fraction y){
        this.x = x;
        this.y = y;
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

    public Fraction getX(){
        return x;
    }

    public Fraction getY(){
        return y;
    }

}
