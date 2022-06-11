package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Fraction;
import pl.edu.pw.ee.Line;
import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//1.Dane są punkty a, b. Wyznacz odległość między nimi
public class Ex1 implements Exercise{
    //TODO zwrócić uwagę, żeby punkty nie były takie same
    private Point a, b;
    private Fraction out;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        Line connected = null;
        try {
            connected = new Line(a, b);
        } catch (SamePointsException e) {
            e.printStackTrace();
        }
        try {
            out = connected.getLength();
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies += ".Oblicz odległość między punktami";
    }

    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Point[] points = CommonAssinging.twoPoints(list);
        a = points[0];
        b = points[1];
        try {
            out = new Fraction(0, 1);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        bodyOfExercies += " punkt A " + a;
        bodyOfExercies += ", punkt B " + b;
    }
}
