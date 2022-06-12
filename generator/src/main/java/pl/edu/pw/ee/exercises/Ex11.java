package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.elements.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//11.Wyznacz równane zawierające symetralną prostej 2 wierzchołków w danym trójkącie
public class Ex11 implements Exercise{

    private Triangle triangle;
    private Func out;
    private String bodyOfExercies;

    @Override
    public Object getSolution() {
        try {
            out = triangle.getSideAB().getSymmetrical();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Wyznacz równanie zawierające symetralną prostej między wierzchołkami A i B";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        bodyOfExercies = "Dane : ";
        triangle = CommonAssinging.triangleAssign(list);
        bodyOfExercies += " trójkąt o wierzchołkach A " + triangle.getA();
        bodyOfExercies += ", B " + triangle.getB();
        bodyOfExercies += ", C " + triangle.getC();
    }
}
