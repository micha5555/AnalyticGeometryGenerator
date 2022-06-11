package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//12.Dany jest trójkąt, podane 2 wierzchołki i równania prostych przechodzącej przez 2 wierzchołki, oblicz współrzędne 3 wierzchołka
public class Ex12 implements Exercise{

    private Triangle triangle;
    private Point out;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        out = triangle.getC();
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Oblicz współrzędne trzeciego wierzchołka";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        triangle = CommonAssinging.triangleAssign(list);
        Func ac = null;
        Func bc = null;
        try {
            ac = triangle.getSideAC().getFunc();
            bc = triangle.getSideBC().getFunc();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        bodyOfExercies += " trójkąt o wierzchołku A " + triangle.getA();
        bodyOfExercies += " i wierzchołku B " + triangle.getB();
        bodyOfExercies += ". Znane są też proste przechodzące przez punkty A C " + ac.toString();
        bodyOfExercies += ", B C " + bc.toString();
    }
}
