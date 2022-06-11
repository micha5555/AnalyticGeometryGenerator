package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.elements.Square;
import pl.edu.pw.ee.elements.Circle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//9.Dany jest kwadrat. Wyznacz równanie okręgu wpisanego w ten kwadrat
public class Ex9 implements Exercise{

    private Square square;
    private Circle out;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        try {
            out = square.createCircleInSquare();
        } catch (IncorrectFractionException | IllegalMathOperation | SamePointsException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Wyznacz równanie okręgu wpisanego w ten kwadrat";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        square = CommonAssinging.squareAssign(list);
        bodyOfExercies += " kwadrat o przeciwległych bokach A " + square.getA();
        bodyOfExercies += ", B " + square.getB();
    }
}
