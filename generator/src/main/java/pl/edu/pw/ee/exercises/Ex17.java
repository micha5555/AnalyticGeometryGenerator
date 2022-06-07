package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.Line;
import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;
//17.Dany jest trójkąt o punktach A B C. Wyznacz równanie prostej przechodzącej przez punkt X i przez środek prostej AB.
public class Ex17 implements Exercise{
//TODO zwrócić uwagę, żeby X i centerAB nie były takie same
    private Triangle triangle;
    private Point pointX;
    private Func out;
    
    @Override
    public Object getSolution() {
        Line ab = triangle.getSideAB();
        Point centerAB;
        Line throughXAndCenterAb = null;
        try {
            centerAB = ab.getCenter();
            throughXAndCenterAb = new Line(centerAB, pointX);
            out = throughXAndCenterAb.getFunc();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        } catch (SamePointsException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return "Wyznacz równanie prostej przechodzącej przez punkt X i przez środek prostej AB";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Element[] el = CommonAssinging.triangleAndPoint(list);
        triangle = (Triangle)el[0];
        pointX = (Point)el[1];
    }
}
