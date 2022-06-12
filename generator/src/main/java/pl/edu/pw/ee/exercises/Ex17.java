package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Line;
import pl.edu.pw.ee.elements.Triangle;
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
    private String bodyOfExercies;

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
        return bodyOfExercies + ". Wyznacz równanie prostej przechodzącej przez punkt X i przez środek prostej AB";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        bodyOfExercies = "Dane : ";
        Element[] el = CommonAssinging.triangleAndPoint(list);
        triangle = (Triangle)el[0];
        pointX = (Point)el[1];
        bodyOfExercies += " trójkąt o wierzchołkach A " + triangle.getA();
        bodyOfExercies += ", B " + triangle.getB();
        bodyOfExercies += ", C " + triangle.getC();
        bodyOfExercies += ", oraz punkt X " + pointX.toString();
    }
}
