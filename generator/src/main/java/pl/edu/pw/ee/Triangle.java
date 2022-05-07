package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Figure;

public class Triangle implements Figure{
    private Point a, b, c;
    private Line sideAB, sideBC, sideAC;

    public Triangle(){
        a = new Point();
        b = new Point();
        c = new Point();
        assignSides();
    }

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
        assignSides();
    }

    @Override
    public double getPerimeter() {
        return sideAB.getLength() + sideBC.getLength() + sideAC.getLength();
    }

    @Override
    public double getArea() {
        return (Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY())*(c.getX() - a.getX())))/2;
    }

    public Point getCenter(){
        return new Point((a.getX() + b.getX() + c.getX())/3, (a.getY() + b.getY() + c.getY())/3);
    }

    public double getHeight(Point p){
        Line tmp;
        if(p.equals(a)){
            tmp = sideBC;
        }else if(p.equals(b)){
            tmp = sideAC;
        }else{
            tmp = sideAB;
        }
        return 2*getArea()/tmp.getLength();
    }

    public Line getSideAB(){
        return sideAB;
    }

    public Line getSideBC(){
        return sideBC;
    }

    public Line fetSideAC(){
        return sideAC;
    }

    private void assignSides(){
        sideAB = new Line(a, b);
        sideBC = new Line(b, c);
        sideAC = new Line(a, c);
    }
}
