package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Square;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//16.Dany jest kwadrat. Sprawdź czy punkt xy zawiera się w kwadracie
public class Ex16 implements Exercise{

    private Square square;
    private Point point;
    private boolean out;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        out = square.checkIfPointInSquare(point);
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Sprawdź czy punkt zawiera się w kwadracie";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Element[] el;
        el = CommonAssinging.squareAndPoint(list);
        square = (Square)el[0];
        point = (Point)el[1];
        bodyOfExercies += " kwadrat o przeciwległych wierzchołkach A " + square.getA();
        bodyOfExercies += ", B " + square.getB();
        bodyOfExercies += " i punkt " + point.toString();
    }
}
