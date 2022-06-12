package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.elements.Line;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//10.Wyznacz równanie symetralnej do podanego odcinka
public class Ex10 implements Exercise{

    private Line line;
    private Func out;
    private String bodyOfExercies;

    @Override
    public Object getSolution() {
        try {
            out =  line.getSymmetrical();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Wyznacz równanie symetralnej do tej prostej";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        bodyOfExercies ="Dane : ";
        line = CommonAssinging.oneLine(list);
        bodyOfExercies += " odcinek o końcach A " + line.getP1();
        bodyOfExercies += " i B " + line.getP2();
    }
}
