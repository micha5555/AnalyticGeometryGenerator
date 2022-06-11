package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Line;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//14.Punkt S to środek prostej, punkt A to początek prostej. Oblicz współrzędne punktu B
public class Ex14 implements Exercise{

    private Line line;
    private Point out;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        out = line.getP2();
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Oblicz współrzędne punktu B";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        line = CommonAssinging.oneLine(list);
        try {
            bodyOfExercies += "środek prostej S " + line.getCenter();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        bodyOfExercies += ", początek prostej A " + line.getP1();

    }
}
