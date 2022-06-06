package pl.edu.pw.ee.exercises;

import java.util.ArrayList;

import pl.edu.pw.ee.Circle;
import pl.edu.pw.ee.Line;
import pl.edu.pw.ee.Point;
import pl.edu.pw.ee.Square;
import pl.edu.pw.ee.Triangle;
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
}
