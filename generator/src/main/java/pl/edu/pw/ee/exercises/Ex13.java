package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//13.Punkt A i B są przeciwległymi wierzchołkami kwadratu. Oblicz pozostałe wierzchołki
public class Ex13 implements Exercise{
    
    private Square square;
    private Point[] out = new Point[2];
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        out[0] = square.getC();
        out[1] = square.getD();
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Znajdź pozostałe wierzchołki";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        square = CommonAssinging.squareAssign(list);
        bodyOfExercies += " kwadrat o przeciwległych wierzchołkach A " + square.getA();
        bodyOfExercies += ", B " + square.getB();
    }
}
