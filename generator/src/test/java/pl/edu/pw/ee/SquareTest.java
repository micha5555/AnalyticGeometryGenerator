package pl.edu.pw.ee;

import org.junit.Test;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class SquareTest {
    @Test
    public void ttt() throws IllegalMathOperation, IncorrectFractionException{
        Square s = new Square();
        System.out.println(s.getA());
        System.out.println(s.getB());
    }
}
