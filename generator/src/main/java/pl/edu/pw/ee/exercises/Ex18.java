package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Circle;
import pl.edu.pw.ee.FractionAggregation;
import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//18.Dany jest trójkąt o punktach A B C, kwadrat o punktach przeciwległych A B oraz okrąg o równaniu xx. Co ma największe pole?
public class Ex18 implements Exercise{

    private Triangle triangle;
    private Square square;
    private Circle circle;
    private String bodyOfExercies = "Dane :";

    @Override
    public Object getSolution() {
        FractionAggregation triangleArea = null;
        FractionAggregation squareArea = null;
        FractionAggregation circleArea = null;
        try {
            triangleArea = triangle.getArea();
            squareArea = square.getArea();
            circleArea = circle.getArea();
        } catch (IncorrectFractionException | IllegalMathOperation e) {
            e.printStackTrace();
        }
        String out = "";
        if(triangleArea.compareTo(squareArea) == 1){
            out = "trójkąt";
            if(triangleArea.compareTo(circleArea) == -1){
                out = "okrąg";
            }
        }
        else{
            out = "kwadrat";
            if(squareArea.compareTo(circleArea) == -1){
                out = "okrąg";
            }
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return bodyOfExercies + ". Który obiekt ma największe pole?";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Element[] el = CommonAssinging.triangleSquareCircle(list);
        triangle = (Triangle)el[0];
        square = (Square)el[1];
        circle = (Circle)el[2];
        bodyOfExercies += " trójkąt o wierzchołkach A " + triangle.getA();
        bodyOfExercies += ", B " + triangle.getB();
        bodyOfExercies += ", C " + triangle.getC();
        bodyOfExercies += "; kwadrat o przeciwległych wierzchołkach A " + square.getA();
        bodyOfExercies += ", B " + square.getB();
        bodyOfExercies += "; okrąg " + circle.toString();
    }
}
