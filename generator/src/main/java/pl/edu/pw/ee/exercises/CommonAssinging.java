package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.elements.Point;
import pl.edu.pw.ee.elements.Square;
import pl.edu.pw.ee.elements.Triangle;
import pl.edu.pw.ee.elements.Circle;
import pl.edu.pw.ee.elements.Line;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.services.Element;

public class CommonAssinging {

    public static Triangle triangleAssign(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 1 || !(list.get(0) instanceof Triangle)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return (Triangle)list.get(0);
    }

    public static Square squareAssign(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 1 || !(list.get(0) instanceof Square)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return (Square)list.get(0);
    }

    public static Point[] twoPoints(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2 || !(list.get(0) instanceof Point) || !(list.get(1) instanceof Point)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Point[] p = new Point[2];
        p[0] = (Point)list.get(0);
        p[1] = (Point)list.get(1);
        return p;
    }

    public static Circle[] twoCircles(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2 || !(list.get(0) instanceof Circle) || !(list.get(1) instanceof Circle)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Circle[] c = new Circle[2];
        c[0] = (Circle)list.get(0);
        c[1] = (Circle)list.get(1);
        return c;
    }

    public static Line[] twoLines(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2 || !(list.get(0) instanceof Line) || !(list.get(1) instanceof Line)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Line[] l = new Line[2];
        l[0] = (Line)list.get(0);
        l[1] = (Line)list.get(1);
        return l;
    }

    public static Line oneLine(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 1 || !(list.get(0) instanceof Line)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return (Line)list.get(0);
    }

    //0-square, 1-point
    public static Element[] squareAndPoint(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Element[] out = new Element[2];
        out[0] = list.get(0);
        out[1] = list.get(1);
        if(out[0] instanceof Square && out[1] instanceof Point){
            
        }
        else if(out[0] instanceof Point && out[1] instanceof Square){
            Element tmp = out[0];
            out[0] = out[1];
            out[1] = tmp;
        }
        else{
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return out;
    }

    //0-triangle, 1-point
    public static Element[] triangleAndPoint(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Element[] out = new Element[2];
        out[0] = list.get(0);
        out[1] = list.get(1);
        if(out[0] instanceof Triangle && out[1] instanceof Point){
            
        }
        else if(out[0] instanceof Point && out[1] instanceof Triangle){
            Element tmp = out[0];
            out[0] = out[1];
            out[1] = tmp;
        }
        else{
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return out;
    }

    public static Element[] triangleSquareCircle(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 3){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        boolean triangleInList = false;
        boolean squareInList = false;
        boolean circleleInList = false;
        Element[] out = new Element[3];
        for(int i = 0; i < 3; i++){
            if(list.get(i) instanceof Triangle){
                triangleInList = true;
                out[0] = list.get(i);
            }
            else if(list.get(i) instanceof Square){
                squareInList = true;
                out[1] = list.get(i);
            }
            else if(list.get(i) instanceof Circle){
                circleleInList = true;
                out[2] = list.get(i);
            }
        }
        if(!(triangleInList && squareInList && circleleInList)){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return out;
    }

    public static Element[] triangleLine(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Element[] out = new Element[2];
        out[0] = list.get(0);
        out[1] = list.get(1);
        if(out[0] instanceof Triangle && out[1] instanceof Line){
            
        }
        else if(out[0] instanceof Line && out[1] instanceof Triangle){
            Element tmp = out[0];
            out[0] = out[1];
            out[1] = tmp;
        }
        else{
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return out;
    }

    public static Element[] squareTriangle(ArrayList<Element> list) throws IllegalElementsForThisExerciseException{
        if(list.size() != 2){
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        Element[] out = new Element[2];
        out[0] = list.get(0);
        out[1] = list.get(1);
        if(out[0] instanceof Square && out[1] instanceof Triangle){
            
        }
        else if(out[0] instanceof Triangle && out[1] instanceof Square){
            Element tmp = out[0];
            out[0] = out[1];
            out[1] = tmp;
        }
        else{
            throw new IllegalElementsForThisExerciseException("Incorrect input!");
        }
        return out;
    }
}
