package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;

//TODO: Dodać skracanie do najprostszej formy
public class MathVector implements Element{
    private Fraction xx, yy;

    public MathVector(){
        Random rand = new Random();
        try {
            xx = new Fraction(rand.nextInt(10 + 10) - 10, 1);
            yy = new Fraction(rand.nextInt(10 + 10) - 10, 1);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
    }

    public MathVector(Fraction xx, Fraction yy){
        this.xx = xx;
        this.yy = yy;
    }
    
    public static MathVector addVectors(MathVector v1, MathVector v2){
        try {
            return new MathVector(Fraction.addFractions(v1.xx, v2.xx), Fraction.addFractions(v1.yy, v2.yy));
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MathVector subtractionVectors(MathVector v1, MathVector v2){
        try {
            return new MathVector(Fraction.subFractions(v1.xx, v2.xx), Fraction.addFractions(v1.yy, v2.yy));
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof MathVector)){
            return false;
        }
        MathVector p = (MathVector) o;
        return (xx.compareTo(p.xx) == 0) && (yy.compareTo(p.yy) == 0);
    }
}
