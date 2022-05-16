package pl.edu.pw.ee;

import java.io.NotActiveException;

import pl.edu.pw.ee.exceptions.NotIsoscelesTriangle;
import pl.edu.pw.ee.exceptions.SamePointsException;

//TODO define exception
public class IsoscelesTriangle extends Triangle{
    public IsoscelesTriangle(Point a, Point b, Point c) throws NotIsoscelesTriangle, SamePointsException{
        super(a, b, c);
        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line ac = new Line(a, c);
        if(!((Double.compare(ab.getLength(), bc.getLength()) == 0) || (Double.compare(bc.getLength(), ac.getLength()) == 0) || (Double.compare(ab.getLength(), ac.getLength()) == 0))){
            throw new NotIsoscelesTriangle("Triangle is not isosceles!");
        }
    }
}
