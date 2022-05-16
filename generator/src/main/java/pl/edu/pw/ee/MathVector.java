package pl.edu.pw.ee;

import java.util.Random;

//TODO: Dodać skracanie do najprostszej formy
public class MathVector {
    private double xx, yy;

    public MathVector(){
        Random rand = new Random();
        xx = rand.nextInt(10 + 10) - 10;
        yy = rand.nextInt(10 + 10) - 10;
    }

    public MathVector(double xx, double yy){
        this.xx = Common.rnd(xx);
        this.yy = Common.rnd(yy);
    }
    
    public static MathVector addVectors(MathVector v1, MathVector v2){
        return new MathVector(v1.xx + v2.xx, v1.yy + v2.yy);
    }

    public static MathVector subtractionVectors(MathVector v1, MathVector v2){
        return new MathVector(v1.xx - v2.xx, v1.yy - v2.yy);
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
        return (Double.compare(xx, p.xx) == 0) && (Double.compare(yy, p.yy) == 0);
    }
}
