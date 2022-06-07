package pl.edu.pw.ee;

import java.util.Random;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Element;

public class Line implements Element{
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

    public Func getFunc() throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation a;
        FractionAggregation b = new FractionAggregation(new Fraction(0, 1));
        FractionAggregation y = new FractionAggregation(new Fraction(1, 1));
        if(p1.getX().compareTo(p2.getX()) == 0){
            //a = new FractionAggregation(1, 1);
            a = new FractionAggregation(new Fraction(1, 1));
            b = p1.getX();
            y = new FractionAggregation(new Fraction(0, 1));
        }
        else if(p1.getY().compareTo(p2.getY()) == 0){
            a = new FractionAggregation(new Fraction(0, 1));
            b = p1.getY();
            y = new FractionAggregation(new Fraction(1, 1));
        }
        else{
            //TU ROZWALA PUNKT  
            a = FractionAggregation.divideFA(FractionAggregation.subFA(p2.getY(), p1.getY()), FractionAggregation.subFA(p2.getX(), p1.getX()));
            // double[] firstEquation = {p1.getY(), p1.getX(), 1};
            // double[] secondEquation = {p2.getY(), p2.getX(), 1};
            // double tmpA = Common.rnd((firstEquation[0] - firstEquation[2])/firstEquation[1]);
            // double[] tmpEquation = {secondEquation[0], secondEquation[1]*tmpA+1};
            b = FractionAggregation.subFA(p1.getY(), FractionAggregation.multiplyFA(a, p1.getX()));
        }
        return new Func(y, a, b);
    //TODO: usunać
        // return null;
    }

    public Fraction getLength() throws IncorrectFractionException{
        Fraction first = Fraction.subFractions(p2.getX().getFraction(0), p1.getX().getFraction(0));
        Fraction second = Fraction.subFractions(p2.getY().getFraction(0), p1.getY().getFraction(0));
        first = Fraction.powFraction(first);
        second = Fraction.powFraction(second);
        Fraction sum = Fraction.addFractions(first, second);
        Fraction output = Fraction.sqrFraction(sum);
        return output;
    }

    public Point getCenter() throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation newX = FractionAggregation.divideFA(FractionAggregation.addFA(p1.getX(), p2.getX()), new FractionAggregation(new Fraction(2, 1)));
        FractionAggregation newY = FractionAggregation.divideFA(FractionAggregation.addFA(p1.getY(), p2.getY()), new FractionAggregation(new Fraction(2, 1)));
        return new Point(newX, newY);
    }
    // public MathVector getVector(){
    //     try {
    //         return new MathVector(FractionAggregation.subFA(p2.getX(), p1.getX()), FractionAggregation.subFA(p2.getY(), p1.getY()));
    //     } catch (IncorrectFractionException e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    //TODO przemyśleć
    public boolean checkPerpendicularity(Line second) throws IncorrectFractionException, IllegalMathOperation{
        Func tmpThis = this.getFunc();
        Func tmpSecond = second.getFunc();
        try {
            if((tmpThis.getY().equals(new FractionAggregation(new Fraction(0, 1))) && tmpSecond.getA().equals(new FractionAggregation(new Fraction(0, 1)))) || (tmpThis.getA().equals(new FractionAggregation(new Fraction(0, 1))) && tmpSecond.getY().equals(new FractionAggregation(new Fraction(0, 1))))){
                return true;
            }
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        try {
            return FractionAggregation.multiplyFA(this.getFunc().getA(), second.getFunc().getA()).equals(new FractionAggregation(new Fraction(-1, 1)));
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkParallelism(Line second) throws IncorrectFractionException, IllegalMathOperation{
        return this.getFunc().getA().equals(second.getFunc().getA());
    }

    //TODO: poprawic jakby y=0
    public Func getSymmetrical() throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation y = new FractionAggregation(new Fraction(1, 1)); //popr
        FractionAggregation secondA = new FractionAggregation(new Fraction(1, 1));
        Point center = this.getCenter();
        Func func = this.getFunc();
        Func sym;
        if(!func.getA().equals(new FractionAggregation(new Fraction(0, 1)))&& !func.getY().equals(new FractionAggregation(new Fraction(0, 1)))){
            secondA = FractionAggregation.divideFA(new Fraction(-1, 1), func.getA());
            sym = new Func(y, secondA, countB(center, secondA));
        }
        else if(func.getY().equals(new FractionAggregation(new Fraction(0, 1)))){
            y = new FractionAggregation(new Fraction(1, 1));
            secondA = new FractionAggregation(new Fraction(0, 1));
            sym = new Func(y, secondA, center.getY());
        }
        else{
            y = new FractionAggregation(new Fraction(0, 1));
            sym = new Func(y, secondA, center.getX());
        }
        return sym;
    }

    public Line createPerpendicularityLine(Point contained) throws IncorrectFractionException, IllegalMathOperation, SamePointsException{
        Func currFunc = this.getFunc();
        FractionAggregation zero = new FractionAggregation(new Fraction(0, 1));
        FractionAggregation y, a, b;
        Line out;

        if(currFunc.getA().equals(zero)){
            return new Line(new Point(contained.getX(), new FractionAggregation(new Fraction(-12, 1))), new Point(contained.getX(), new FractionAggregation(new Fraction(12, 1))));
        }
        else if(currFunc.getY().equals(zero)){
            return new Line(new Point(new FractionAggregation(new Fraction(-12, 1)), contained.getY()), new Point(new FractionAggregation(new Fraction(12, 1)), contained.getY()));
        }
        else{
            y = new FractionAggregation(new Fraction(1, 1));
            a = FractionAggregation.divideFA(new Fraction(-1, 1), currFunc.getA());
            b = FractionAggregation.subFA(contained.getY(), FractionAggregation.multiplyFA(a, contained.getX()));
            Point p1 = createPointToPerpendicularityLine(contained, new Func(y, a, b));
            out = new Line(p1, contained);
        }
        return out;
    }

    private static Point createPointToPerpendicularityLine(Point contained, Func f) throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation n12 = new FractionAggregation(new Fraction(12, 1));
        FractionAggregation nm12 = new FractionAggregation(new Fraction(-12, 1));
        FractionAggregation w1 = FractionAggregation.divideFA(FractionAggregation.subFA(n12, f.getB()), f.getA());
        FractionAggregation w2 = FractionAggregation.divideFA(FractionAggregation.subFA(nm12, f.getB()), f.getA());
        if(w1.compareTo(n12) < 1 && w1.compareTo(nm12) > 1 && !w1.equals(contained.getX())){
            return new Point(w1, n12);
        }
        else if(w2.compareTo(n12) < 1 && w2.compareTo(nm12) > 1 && !w2.equals(contained.getX())){
            return new Point(w2, nm12);
        }
        w1 = FractionAggregation.addFA(FractionAggregation.multiplyFA(f.getA(), nm12), f.getB());
        if(!w1.equals(contained.getY())){
            return new Point(nm12, w1);
        }
        w1 = FractionAggregation.addFA(FractionAggregation.multiplyFA(f.getA(), n12), f.getB());
        return new Point(n12, w1);
    }

    public Line createParallelLine() throws SamePointsException, IncorrectFractionException, IllegalMathOperation{
        Random rand = new Random();
        FractionAggregation primP1x = p1.getX();
        FractionAggregation primP1y = p1.getY();
        FractionAggregation primP2x = p2.getX();
        FractionAggregation primP2y = p2.getY();

        FractionAggregation p1Y = new FractionAggregation(new Fraction(0,1));
        FractionAggregation p2Y = new FractionAggregation(new Fraction(0,1));
        FractionAggregation p2X = new FractionAggregation(new Fraction(0,1));

        //TUTAJ ROZWALA PUNKTY
        if(this.getFunc().getY().equals(new FractionAggregation(new Fraction(0, 1)))){
            do{
                p2X = new FractionAggregation(new Fraction((rand.nextInt(48) - 24), 2));
            }while(p2X.equals(primP2x));
            return new Line(new Point(p2X, new FractionAggregation(new Fraction(-12, 1))), new Point(p2X, new FractionAggregation(new Fraction(12, 1))));
        }
        else if(this.getFunc().getA().equals(new FractionAggregation(new Fraction(0,1)))){
            do{
                p2Y = new FractionAggregation(new Fraction((rand.nextInt(48) - 24), 2));
            }while(p2Y.equals(primP2y));
            return new Line(new Point(new FractionAggregation(new Fraction(-12,1)), p2Y), new Point(new FractionAggregation(new Fraction(12,1)), p2Y));
        }

        do{
            p1Y = new FractionAggregation(new Fraction((rand.nextInt(24) - 12), 2)); // <-6; 6>
        }while(p1Y.equals(primP1y));

        FractionAggregation diff = FractionAggregation.subFA(primP1y, p1Y);
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
            p2Y = FractionAggregation.subFA(primP2y, diff);
            p2X = primP2x;
        Line out = new Line(new Point(primP1x, p1Y), new Point(p2X, p2Y));
        Func tmp = out.getFunc();
        // }
        if(p2Y.compareTo(new FractionAggregation(new Fraction(12,1))) >= 0){
            p2Y = new FractionAggregation(new Fraction(23, 12));
            p2X = FractionAggregation.divideFA(FractionAggregation.subFA(p2Y, tmp.getB()),tmp.getA());
        }
        else if(p2Y.compareTo(new FractionAggregation(new Fraction(-12, 1))) <= -0){
            p2Y = new FractionAggregation(new Fraction(-23, 12));
            p2X = FractionAggregation.divideFA(FractionAggregation.subFA(p2Y, tmp.getB()), tmp.getA());
        }
        return new Line(new Point(primP1x, p1Y), new Point(p2X, p2Y));
    }

    //point-punkt przez który przechodzi prosta; aP- współczynnika a
    private static FractionAggregation countB(Point point, FractionAggregation aP){
        try {
            FractionAggregation aa = FractionAggregation.multiplyFA(aP, point.getX());
            return FractionAggregation.subFA(point.getY(), aa);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FractionAggregation getTangentOfAcuteAngleWithSecondLine(Line l) throws IncorrectFractionException, IllegalMathOperation{
        Func funcThis = this.getFunc();
        Func funcSecond = l.getFunc();
        FractionAggregation aMultiply = FractionAggregation.multiplyFA(funcThis.getA(), funcSecond.getA());
        if(aMultiply.equals(new FractionAggregation(new Fraction(-1, 1)))){
            throw new IllegalMathOperation("Tangent of 90 degres doesn`t exist");
        }
        FractionAggregation aDiff = FractionAggregation.subFA(funcThis.getA(), funcSecond.getA());
        FractionAggregation denominator = FractionAggregation.addFA(new FractionAggregation(new Fraction(1, 1)), aMultiply);
        FractionAggregation out = FractionAggregation.divideFA(aDiff, denominator);
        out.abs();
        return out;
    }

    //TODO: delete
    public void showFunc() throws IncorrectFractionException, IllegalMathOperation{
        Func tmp = this.getFunc();
        System.out.println(tmp);
    }
}
