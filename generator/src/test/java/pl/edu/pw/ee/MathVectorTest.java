package pl.edu.pw.ee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathVectorTest {
    
    @Test
    public void should_CorrectlyAddVectors(){
        MathVector v1 = new MathVector(0, 5);
        MathVector v2 = new MathVector(3, -1);
        assertEquals(new MathVector(3, 4), MathVector.addVectors(v1, v2));
    }

    @Test
    public void should_CorrectlySubstractVectors(){
        MathVector v1 = new MathVector(9, -5);
        MathVector v2 = new MathVector(-3, -9);
        assertEquals(new MathVector(12, 4), MathVector.subtractionVectors(v1, v2));
        assertEquals(new MathVector(-12, -4), MathVector.subtractionVectors(v2, v1));
    }
}
