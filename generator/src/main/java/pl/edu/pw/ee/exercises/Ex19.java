package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Circle;
import pl.edu.pw.ee.FractionAggregation;
import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.Triangle;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

//19.Dany jest trójkąt o punktach A B C, kwadrat o punktach przeciwległych A B oraz okrąg o równaniu xx. Co ma największy obwód?
public class Ex19 implements Exercise{

    private Triangle triangle;
    private Square square;
    private Circle circle;
    
    @Override
    public Object getSolution() {
        FractionAggregation trianglePerimeter = null;
        FractionAggregation squarePerimeter = null;
        FractionAggregation circlePerimeter = null;
        try {
            trianglePerimeter = triangle.getPerimeter();
            squarePerimeter = square.getPerimeter();
            circlePerimeter = circle.getPerimeter();
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        String out = "";
        if(trianglePerimeter.compareTo(squarePerimeter) == 1){
            out = "trójkąt";
            if(trianglePerimeter.compareTo(circlePerimeter) == -1){
                out = "okrąg";
            }
        }
        else{
            out = "kwadrat";
            if(squarePerimeter.compareTo(circlePerimeter) == -1){
                out = "okrąg";
            }
        }
        return out;
    }

    @Override
    public String whatToDo() {
        return "Który obiekt ma największy obwód?";
    }
    
    @Override
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException {
        Element[] el = CommonAssinging.triangleSquareCircle(list);
        triangle = (Triangle)el[0];
        square = (Square)el[1];
        circle = (Circle)el[2];
    }
}
