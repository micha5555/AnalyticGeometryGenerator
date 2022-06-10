package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;
//21.Dany jest kwadrat i trójkąt. Czy którykolwiek wierzchołek trójkąta zawiera się w kwadracie?
public class Ex21 implements Exercise{

    private Square square;
    private Triangle triangle;

    @Override
    public Object getSolution() {
        return square.checkIfPointInSquare(triangle.getA()) || square.checkIfPointInSquare(triangle.getB()) || square.checkIfPointInSquare(triangle.getC());
    }

    @Override
    public String whatToDo() {
        return "Czy którykolwiek wierzchołek trójkąta zawiera się w kwadracie?";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Element[] el = CommonAssinging.squareTriangle(list);
        square = (Square)el[0];
        triangle = (Triangle)el[1];
    }
}