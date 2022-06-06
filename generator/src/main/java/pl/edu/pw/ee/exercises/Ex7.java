package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//7.Dane są 3 punkty, obliczyć współrzędne 4 punktu, tak aby utworzyły one kwadrat
public class Ex7 implements Exercise{

    private Square square;
    private Point out;
    
    @Override
    public Object getSolution() {
        out = square.getD();
        return out;
    }

    @Override
    public String whatToDo() {
        return "Oblicz współrzędne czwartego punktu";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        square = CommonAssinging.squareAssign(list);
        
    }
}
