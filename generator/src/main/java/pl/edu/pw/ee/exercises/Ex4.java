package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.FractionAggregation;
import pl.edu.pw.ee.elements.Line;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//4.Dane są 2 proste. Oblicz tangens między nimi
//TODO zwrócić uwagę na typ zwracany "-" - String
public class Ex4 implements Exercise{

    private Line line1, line2;
    private FractionAggregation out;
    private String bodyOfExercies;

    @Override
    public Object getSolution() {
        try {
            out = line1.getTangentOfAcuteAngleWithSecondLine(line2);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        } catch (IllegalMathOperation e) {
            return "-";
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Oblicz tangens między prostymi";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        bodyOfExercies = "Dane : ";
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
