package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//5.Dany jest trójkąt. Oblicz środek ciężkości
public class Ex5 implements Exercise{

    private Triangle triangle;
    private Point out;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        try {
            out = triangle.getCenter();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Oblicz środek ciężkości trójkąta";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        triangle = CommonAssinging.triangleAssign(list);
        bodyOfExercies += " trójkąt o wierzchołkach A " + triangle.getA();
        bodyOfExercies += " B " + triangle.getB();
        bodyOfExercies += " C " + triangle.getC(); 
    }
}
