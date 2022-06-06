package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Circle;
import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.exceptions.SamePointsException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//8.Dany jest kwadrat. Wyznacz równanie okręgu opisanego na tym kwadracie
public class Ex8 implements Exercise{
    
    private Square square;
    private Circle out;
    
    @Override
    public Object getSolution() {
        try {
            out = square.createCircleOnSquare();
        } catch (IncorrectFractionException | IllegalMathOperation | SamePointsException e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return "Wyznacz równanie okręgu opisanego na tym kwadracie";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        CommonAssinging.squareAssign(list);
    }
}
