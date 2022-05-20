package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;

public class Line {
    private Point p1, p2;
    public Line(){
        Point first = new Point();
        Point second;
        do{
            second = new Point();
        }while(second.equals(first));
        assignPoints(first, second);
    }
    public Line(Point p1, Point p2) throws SamePointsException{
        if(p1.equals(p2)){
            throw new SamePointsException("Points are the same!");
        }
        assignPoints(p1, p2);
    }

    private void assignPoints(Point first, Point second){
        if(first.getX().compareTo(second.getX()) <= 0 ){
            this.p1 = first;
            this.p2 = second;
        }
        else{
            this.p1 = second;
            this.p2 = first;
        }
    }
    
    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public Func getFunc(){
    //     Fraction a;
    //     Fraction b = new Fraction(0, 1);
    //     Fraction y = new Fraction(1, 1);
    //     if(p1.getX().compareTo(p2.getX()) == 0){
    //         a = new Fraction(1, 1);
    //         b = p1.getX();
    //         y = new Fraction(0, 1);
    //     }
    //     else if(p1.getY().compareTo(p2.getY()) == 0){
    //         a = new Fraction(0, 1);
    //         b = p1.getY();
    //         y = new Fraction(1, 1);
    //     }
    //     else{
    //         a = Fraction.divFractions(Fraction.subFractions(p2.getY(), p2.getY()), Fraction.subFractions(p2.getX(), p1.getX()));
    //         // double[] firstEquation = {p1.getY(), p1.getX(), 1};
    //         // double[] secondEquation = {p2.getY(), p2.getX(), 1};
    //         // double tmpA = Common.rnd((firstEquation[0] - firstEquation[2])/firstEquation[1]);
    //         // double[] tmpEquation = {secondEquation[0], secondEquation[1]*tmpA+1};
    //         b = Fraction.subFractions(p1.getY(), Fraction.multiplyFractions(a, p1.getX()));
    //     }
    //     return new Func(y, a, b);
    //TODO: usunać
        return null;
    }

    // public double getLength(){
    //     double output = Math.sqrt(Math.pow(Fraction.subFractions(p2.getX(), p1.getX()), 2) + Math.pow(Fraction.subFractions(p2.getY(), p1.getY()), 2));
    //     return Common.rnd(output);
    // }

    public Point getCenter() throws IncorrectFractionException, IllegalMathOperation{
        return new Point(Fraction.divFractions(Fraction.addFractions(p1.getX(), p2.getX()), new Fraction(2, 1)), Fraction.divFractions(Fraction.addFractions(p1.getY(), p2.getY()), new Fraction(2, 1)));
    }

    public MathVector getVector(){
        try {
            return new MathVector(Fraction.subFractions(p2.getX(), p1.getX()), Fraction.subFractions(p2.getY(), p1.getY()));
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO przemyśleć
    public boolean checkPerpendicularity(Line second){
        Func tmpThis = this.getFunc();
        Func tmpSecond = second.getFunc();
        try {
            if((tmpThis.getY().compareTo(new Fraction(0, 1)) == 0 && tmpSecond.getA().compareTo(new Fraction(0, 1)) == 0) || (tmpThis.getA().compareTo(new Fraction(0, 1)) == 0 && tmpSecond.getY().compareTo(new Fraction(0, 1)) == 0)){
                return true;
            }
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        try {
            return Fraction.multiplyFractions(this.getFunc().getA(), second.getFunc().getA()).equals(new Fraction(-1, 1));
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkParallelism(Line second){
        return this.getFunc().getA().compareTo(second.getFunc().getA()) == 0;
    }

    //TODO: poprawic jakby y=0
    public Func getSymmetrical() throws IncorrectFractionException, IllegalMathOperation{
        Fraction y = new Fraction(1, 1); //popr
        Fraction secondA = new Fraction(1, 1);
        Point center = this.getCenter();
        Func func = this.getFunc();
        Func sym;
        if(func.getA().compareTo(new Fraction(0, 1)) != 0 && func.getY().compareTo(new Fraction(0, 1)) != 0){
            secondA = Fraction.divFractions(new Fraction(-1, 1), func.getA());
            sym = new Func(y, secondA, countB(center, secondA));
        }
        else if(func.getY().compareTo(new Fraction(0, 1)) == 0){
            y = new Fraction(1, 1);
            secondA = new Fraction(0, 1);
            sym = new Func(y, secondA, center.getY());
        }
        else{
            y = new Fraction(0, 1);
            sym = new Func(y, secondA, center.getX());
        }
        return sym;
    }

    //TODO: nie działa
    public Line createParallelLine() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Random rand = new Random();
        Fraction primP1x = p1.getX();
        Fraction primP1y = p1.getY();
        Fraction primP2x = p2.getX();
        Fraction primP2y = p2.getY();

        Fraction p1Y = new Fraction(0,0);
        Fraction p2Y = new Fraction(0,0);
        Fraction p2X = new Fraction(0,0);

        if(this.getFunc().getY().compareTo(new Fraction(0, 1)) == 0){
            do{
                p2X = new Fraction((rand.nextInt(48) - 24), 2);
            }while(p2X.compareTo(primP2x) == 0);
            return new Line(new Point(p2X, new Fraction(-12, 1)), new Point(p2X, new Fraction(12, 1)));
        }
        else if(this.getFunc().getA().compareTo(new Fraction(0,1)) == 0){
            do{
                p2Y = new Fraction((rand.nextInt(48) - 24), 2);
            }while(p2Y.compareTo(primP2y) == 0);
            return new Line(new Point(new Fraction(-12,1), p2Y), new Point(new Fraction(12,1), p2Y));
        }

        do{
            p1Y = new Fraction((rand.nextInt(24) - 12), 2); // <-6; 6>
        }while(p1Y.compareTo(primP1y) == 0);

        Fraction diff = Fraction.subFractions(primP1y, p1Y);
        // if(primP2y - diff > 12){
        //     Func tmp = this.getFunc();
        //     p2Y = 11.5;
        //     p2X = Common.rnd((p2Y - tmp.getB())/tmp.getA());
        // }
        // else if(primP2y - diff < -12){
        //     Func tmp = this.getFunc();
        //     p2Y = -11.5;
        //     p2X = Common.rnd((p2Y - tmp.getB())/tmp.getA());
        // }
        // else{
            p2Y = Fraction.subFractions(primP2y, diff);
            p2X = primP2x;
        Line out = new Line(new Point(primP1x, p1Y), new Point(p2X, p2Y));
        Func tmp = out.getFunc();
        // }
        if(p2Y.compareTo(new Fraction(12,1)) >= 0){
            p2Y = new Fraction(23, 12);
            p2X = Fraction.divFractions(Fraction.subFractions(p2Y, tmp.getB()),tmp.getA());
        }
        else if(p2Y.compareTo(new Fraction(-12, 1)) <= -0){
            p2Y = new Fraction(-23, 12);
            p2X = Fraction.divFractions(Fraction.subFractions(p2Y, tmp.getB()), tmp.getA());
        }
        return new Line(new Point(primP1x, p1Y), new Point(p2X, p2Y));
    }

    //point-punkt przez który przechodzi prosta; aP- współczynnika a
    private static Fraction countB(Point point, Fraction aP){
        try {
            Fraction aa = Fraction.multiplyFractions(aP, point.getX());
            return Fraction.subFractions(point.getY(), aa);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO: delete
    public void showFunc(){
        Func tmp = this.getFunc();
        //System.out.println(tmp);
    }
}
