package pl.edu.pw.ee;

import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class Fraction {
    private int numerator; //licznik
    private int denominator; //mianownik

    public Fraction(int numerator, int denominator) throws IncorrectFractionException{
        if(denominator == 0){
            throw new IncorrectFractionException("Denominator of fraction cannot be zero!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        if(numerator < 0 && denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else if(numerator > 0 && denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        this.reduce();
    }

    public static Fraction addFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        if(f1.denominator != f2.denominator){
            Fraction[] tmp = makeCommonDenominator(f1, f2);
            f1 = tmp[0];
            f2 = tmp[1];
        }
        return new Fraction(f1.numerator + f2.numerator, f1.denominator);
    }

    public static Fraction subFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        if(f1.denominator != f2.denominator){
            Fraction[] tmp = makeCommonDenominator(f1, f2);
            f1 = tmp[0];
            f2 = tmp[1];
        }
        return new Fraction(f1.numerator - f2.numerator, f1.denominator);
    }

    public static Fraction multiplyFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        return new Fraction(f1.numerator * f2.numerator, f1.denominator * f2.denominator);
    }

    public static Fraction divFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        return new Fraction(f1.numerator * f2.denominator, f1.denominator * f2.numerator);
    }

    public void reduce(){
        for(int i = numerator < denominator ? numerator : denominator; i >= 2; i--){
            if(numerator % i == 0 && denominator % i == 0){
                numerator /= i;
                denominator /= i;
                i = numerator < denominator ? numerator : denominator;
            }
        }
    }

    public static Fraction[] makeCommonDenominator(Fraction f1, Fraction f2){
        int denominatorOfF1 = f1.denominator;
        int denominatorOfF2 = f2.denominator;
        f1.numerator *= denominatorOfF2;
        f1.denominator *= denominatorOfF2;
        f2.numerator *= denominatorOfF1;
        f2.denominator *= denominatorOfF1;
        return new Fraction[]{f1, f2};
    }

    @Override
    public String toString(){
        return String.format("(%d/%d)", numerator, denominator);
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Fraction)){
            return false;
        }
        Fraction p = (Fraction) o;
        return this.numerator == p.numerator && this.denominator == p.denominator;
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }
}
