package pl.edu.pw.ee.services;

import java.util.ArrayList;

import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;

public interface Exercise {
    public Object getSolution();
    public String whatToDo();
    public void insertElements(ArrayList<Element> list) throws IllegalElementsForThisExerciseException;
}
