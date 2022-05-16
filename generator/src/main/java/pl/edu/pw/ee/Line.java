package pl.edu.pw.ee;

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
        if(first.getX() <= second.getX()){
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
        double a;
        double b = 0;
        double y = 1;
        if(Double.compare(p1.getX(), p2.getX()) == 0){
            a = 1;
            b = p1.getX();
            y = 0;
        }
        else if(Double.compare(p1.getY(), p2.getY()) == 0){
            a = 0;
            b = p1.getY();
            y = 1;
        }
        else{
            a = (Common.rnd(p2.getY() - p1.getY()))/Common.rnd((p2.getX() - p1.getX()));
            double[] firstEquation = {p1.getY(), p1.getX(), 1};
            double[] secondEquation = {p2.getY(), p2.getX(), 1};
            double tmpA = Common.rnd((firstEquation[0] - firstEquation[2])/firstEquation[1]);
            double[] tmpEquation = {secondEquation[0], secondEquation[1]*tmpA+1};
            b = tmpEquation[0]/tmpEquation[1];
        }
        return new Func(Common.rnd(y),Common.rnd(a),Common.rnd(b));
    }

    public double getLength(){
        double output = Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
        return Common.rnd(output);
    }

    public Point getCenter(){
        return new Point(Common.rnd((p1.getX()+p2.getX())/2), Common.rnd((p1.getY() + p2.getY())/2));
    }

    public MathVector getVector(){
        return new MathVector(p2.getX() - p1.getX(), p2.getY() - p2.getY());
    }

    //TODO przemyśleć
    public boolean checkPerpendicularity(Line second){
        Func tmpThis = this.getFunc();
        Func tmpSecond = second.getFunc();
        if((Double.compare(tmpThis.getY(), 0) == 0 && Double.compare(tmpSecond.getA(), 0) == 0) || (Double.compare(tmpThis.getA(), 0) == 0 && Double.compare(tmpSecond.getY(), 0) == 0)){
            return true;
        }
        return (this.getFunc().getA()*second.getFunc().getA() == -1);
    }

    //TODO: poprawic jakby y=0
    public Func getSymmetrical(){
        double y = 1; //popr
        double secondA = 1;
        Point center = this.getCenter();
        Func func = this.getFunc();
        Func sym;
        if(Double.compare(func.getA(), 0) != 0 && Double.compare(func.getY(), 0) != 0){
            secondA = Common.rnd(-1/func.getA());
            sym = new Func(Common.rnd(y), Common.rnd(secondA), countB(center, secondA));
        }
        else if(Double.compare(func.getY(), 0) == 0){
            y = 1;
            secondA = 0;
            sym = new Func(y, secondA, center.getY());
        }
        else{
            y = 0;
            sym = new Func(y, secondA, center.getX());
        }
        return sym;
    }

    //point-punkt przez który przechodzi prosta; aP- współczynnika a
    private static double countB(Point point, double aP){
        double aa = (aP*point.getX());
        double tt =Common.rnd(aa);
        double output = point.getY()-tt;
        return Common.rnd(output);
    }

    //TODO: delete
    public void showFunc(){
        Func tmp = this.getFunc();
        //System.out.println(tmp);
    }
}
