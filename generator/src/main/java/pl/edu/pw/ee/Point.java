package pl.edu.pw.ee;

import java.util.Random;

public class Point {
    private double x, y;
    public Point(){
        Random rand = new Random();
        x = (rand.nextInt(20+20) - 20)/2;
        y = (rand.nextInt(20+20) - 20)/2;
    }

    public Point(double x, double y){
        this.x = Common.rnd(x);
        this.y = Common.rnd(y);
    }

    @Override
    public String toString(){
        return String.format("x=%.2f y=%.2f", x, y);
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
        return (Double.compare(x, p.x) == 0) && (Double.compare(y, p.y) == 0);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

}
