package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Func;
import pl.edu.pw.ee.Line;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//20.Dany jest trójkąt i prosta. Czy funkcja prostej jest taka sama jak funkcja wyznaczona z któregoś bok trójkąta?
public class Ex20 implements Exercise{

    private Triangle triangle;
    private Line line;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        try {
            Func lineFunc = line.getFunc();
            Func triangleABFunc = triangle.getSideAB().getFunc();
            Func triangleBCFunc = triangle.getSideBC().getFunc();
            Func triangleACFunc = triangle.getSideAC().getFunc();
            if(lineFunc.equals(triangleABFunc) || lineFunc.equals(triangleBCFunc) || lineFunc.equals(triangleACFunc)){
                return true;
            }
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Czy funkcja prostej jest taka sama jak funkcja wyznaczona z któregoś boku trójkąta?";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Element[] el = CommonAssinging.triangleLine(list);
        triangle = (Triangle)el[0];
        line = (Line)el[1];
        bodyOfExercies += " trójkąt o wierzchołkach A " + triangle.getA();
        bodyOfExercies += ", B " + triangle.getB();
        bodyOfExercies += ", C " + triangle.getC();
        try {
            bodyOfExercies += "; prosta " + line.getFunc();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
    }
}
