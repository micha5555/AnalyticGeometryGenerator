package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.Line;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//10.Wyznacz równanie symetralnej do podanego odcinka
public class Ex10 implements Exercise{

    private Line line;
    private Func out;
    
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
        return "Wyznacz równanie symetralnej do odcinka";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        line = CommonAssinging.oneLine(list);
    }
}
