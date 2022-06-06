package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//12.Dany jest trójkąt, podane 2 wierzchołki i równania prostych przechodzącej przez 2 wierzchołki, oblicz współrzędne 3 wierzchołka
public class Ex12 implements Exercise{

    private Triangle triangle;
    private Point out;
    
    @Override
    public Object getSolution() {
        out = triangle.getC();
        return out;
    }

    @Override
    public String whatToDo() {
        return "Oblicz współrzędne trzeciego wierzchołka";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        triangle = CommonAssinging.triangleAssign(list);
    }
}
