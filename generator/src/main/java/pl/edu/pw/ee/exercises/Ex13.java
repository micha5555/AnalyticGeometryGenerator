package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Square;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//13.Punkt A i B są przeciwległymi wierzchołkami kwadratu. Oblicz pozostałe wierzchołki
public class Ex13 implements Exercise{
    
    private Square square;
    private Point[] out = new Point[2];
    private String bodyOfExercies;

    @Override
    public Object getSolution() {
        out[0] = square.getC();
        out[1] = square.getD();
        String outString = out[0].toString() + "    " + out[1].toString();
        return outString;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Znajdź pozostałe wierzchołki";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        bodyOfExercies = "Dane : ";
        square = CommonAssinging.squareAssign(list);
        bodyOfExercies += " kwadrat o przeciwległych wierzchołkach A " + square.getA();
        bodyOfExercies += ", B " + square.getB();
    }
}
