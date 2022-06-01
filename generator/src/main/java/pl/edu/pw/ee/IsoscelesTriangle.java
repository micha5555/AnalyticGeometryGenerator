package pl.edu.pw.ee;


import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.NotIsoscelesTriangle;
import pl.edu.pw.ee.exceptions.SamePointsException;

//TODO define exception; do sth with try catch
public class IsoscelesTriangle extends Triangle{
    public IsoscelesTriangle(Point a, Point b, Point c) throws NotIsoscelesTriangle, SamePointsException{
        super(a, b, c);
        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line ac = new Line(a, c);
        try {
            if(ab.getLength().equals(bc.getLength()) || bc.getLength().equals(ac.getLength()) || ab.getLength().equals(ac.getLength())){
                ;
            }else{
                throw new NotIsoscelesTriangle("Triangle is not isosceles!");
            }
        } catch (IncorrectFractionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
