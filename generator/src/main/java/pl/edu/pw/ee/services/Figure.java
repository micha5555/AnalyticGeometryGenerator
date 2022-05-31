package pl.edu.pw.ee.services;

import pl.edu.pw.ee.FractionAggregation;
import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public interface Figure {
    public FractionAggregation getPerimeter() throws IncorrectFractionException;
    public FractionAggregation getArea() throws IncorrectFractionException, IllegalMathOperation;
}
