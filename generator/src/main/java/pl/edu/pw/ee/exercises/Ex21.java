package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.elements.Square;
import pl.edu.pw.ee.elements.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;
//21.Dany jest kwadrat i trójkąt. Czy którykolwiek wierzchołek trójkąta zawiera się w kwadracie?
public class Ex21 implements Exercise{

    private Square square;
    private Triangle triangle;
    private String bodyOfExercies;

    @Override
    public Object getSolution() {
        return square.checkIfPointInSquare(triangle.getA()) || square.checkIfPointInSquare(triangle.getB()) || square.checkIfPointInSquare(triangle.getC());
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Czy którykolwiek wierzchołek trójkąta zawiera się w kwadracie?";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        bodyOfExercies = "Dane : ";
        Element[] el = CommonAssinging.squareTriangle(list);
        square = (Square)el[0];
        triangle = (Triangle)el[1];
        bodyOfExercies += " kwadrat o przeciwległych wierzchołkach A " + square.getA();
        bodyOfExercies += ", B " + square.getB();
        bodyOfExercies += "; trójkąt o wierzchołkach A " + triangle.getA();
        bodyOfExercies += ", B " + triangle.getB();
        bodyOfExercies += ", C " + triangle.getC();
    }
}
