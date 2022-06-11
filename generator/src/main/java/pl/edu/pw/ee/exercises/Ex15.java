package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Fraction;
import pl.edu.pw.ee.FractionAggregation;
import pl.edu.pw.ee.elements.Circle;
import pl.edu.pw.ee.elements.Line;
import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//15.Dane 2 okręgi. Obliczyć odległość między środkami
public class Ex15 implements Exercise{

    private Circle circle1, circle2;
    private FractionAggregation length;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        Point s1 = circle1.getCenter();
        Point s2 = circle2.getCenter();
        Fraction tmp;
        try {
            Line s1s2 = new Line(s1, s2);
            tmp = s1s2.getLength();
            length = new FractionAggregation(tmp);
        } catch (SamePointsException e) {
            try {
                length = new FractionAggregation(new Fraction(0, 1));
            } catch (IncorrectFractionException e1) {
                e1.printStackTrace();
            }
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        return length;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Oblicz odległość między środkami tych okręgów";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Circle[] circles = CommonAssinging.twoCircles(list);
        circle1 = circles[0];
        circle2 = circles[1];
        bodyOfExercies += " okrąg " + circle1.toString();
        bodyOfExercies += ", okrąg " + circle2.toString();
    }
}
