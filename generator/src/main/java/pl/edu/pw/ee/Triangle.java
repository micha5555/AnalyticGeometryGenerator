package pl.edu.pw.ee;

import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Figure;

public class Triangle implements Figure{
    private Point a, b, c;
    private Line sideAB, sideBC, sideAC;

    // public Triangle() throws SamePointsException{
    //     a = new Point();
    //     b = new Point();
    //     c = new Point();
    //     do{
    //         b = new Point();
    //     }while(a.equals(b));
    //     do{
    //         c = new Point();
    //     }while(a.equals(c) || b.equals(c));
    //     assignSides();
    // }

    // public Triangle(Point a, Point b, Point c) throws SamePointsException{
    //     this.a = a;
    //     this.b = b;
    //     this.c = c;
    //     if(a.equals(b) || a.equals(c) || b.equals(c)){
    //         throw new SamePointsException("Some points in traingle are the same!");
    //     }
    //     assignSides();
    // }

    @Override
    public double getPerimeter() {
        return /*sideAB.getLength() + sideBC.getLength() + sideAC.getLength()*/0;
    }

    @Override
    public double getArea() {
        return /*(Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY())*(c.getX() - a.getX())))/2*/0;
    }

    // public Point getCenter(){
    //     return new Point(Common.rnd((a.getX() + b.getX() + c.getX())/3), Common.rnd((a.getY() + b.getY() + c.getY())/3));
    // }

    // public double getHeight(Point p){
    //     Line tmp;
    //     if(p.equals(a)){
    //         tmp = sideBC;
    //     }else if(p.equals(b)){
    //         tmp = sideAC;
    //     }else{
    //         tmp = sideAB;
    //     }
    //     return Common.rnd(2*getArea()/tmp.getLength());
    // }

    // public Line getSideAB(){
    //     return sideAB;
    // }

    // public Line getSideBC(){
    //     return sideBC;
    // }

    // public Line fetSideAC(){
    //     return sideAC;
    // }

    // public Point getA(){
    //     return a;
    // }

    // public Point getB(){
    //     return b;
    // }

    // public Point getC(){
    //     return c;
    // }
    // private void assignSides() throws SamePointsException{
    //     sideAB = new Line(a, b);
    //     sideBC = new Line(b, c);
    //     sideAC = new Line(a, c);
    // }
}
