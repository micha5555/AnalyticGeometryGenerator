package pl.edu.pw.ee;

import java.util.Random;

public class MathVector {
    private double xx, yy;

    public MathVector(){
        Random rand = new Random();
        xx = rand.nextInt(10 + 10) - 10;
        yy = rand.nextInt(10 + 10) - 10;
    }

    public MathVector(double xx, double yy){
        this.xx = xx;
        this.yy = yy;
    }
}
