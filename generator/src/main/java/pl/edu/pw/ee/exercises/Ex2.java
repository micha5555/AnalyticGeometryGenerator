package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Line;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//2.Dane są 2 proste. Sprawdź czy są prostopadłe
public class Ex2 implements Exercise{

    private boolean out;
    private Line line1, line2;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        try {
            out = line1.checkPerpendicularity(line2);
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies +". Sprawdź, czy proste są prostopadłe";
    }

    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Line[] lines = CommonAssinging.twoLines(list);
        line1 = lines[0];
        line2 = lines[1];
        try {
            bodyOfExercies += " prosta " + line1.getFunc();
            bodyOfExercies += ", prosta " + line2.getFunc();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
    }
    
}
