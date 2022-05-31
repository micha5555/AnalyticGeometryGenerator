package pl.edu.pw.ee;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class Fraction implements Comparable<Fraction>{
    private int numerator; //licznik
    private int denominator; //mianownik
    private int numeratorSqr = 1; //liczba pod pierwiastkiem przy liczniku
    private int denominatorSqr = 1; //liczba pd pierwiastkiem przy mianowniku

    public Fraction(int numerator, int denominator) throws IncorrectFractionException{
        assignNumeratorDenominator(numerator, denominator);
        this.reduce();
    }

    public Fraction(int numerator, int denominator, int numSqr, int denSqr) throws IncorrectFractionException{
        assignNumeratorDenominator(numerator, denominator);
        this.numeratorSqr = numSqr;
        this.denominatorSqr = denSqr;
        this.reduce();
    }

    private void assignNumeratorDenominator(int n, int d) throws IncorrectFractionException{
        if(d == 0){
            throw new IncorrectFractionException("Denominator of fraction cannot be zero!");
        }
        this.numerator = n;
        this.denominator = d;
        if(n < 0 && d < 0){
            this.numerator = -n;
            this.denominator = -d;
        }
        else if(n > 0 && d < 0){
            this.numerator = -n;
            this.denominator = -d;
        }
    }

    //TODO Nie dodawać/odejmować, gdy różne pierwiastki
    //dwaa ułamki bo pierwiastki mogą byc różne?
    public static Fraction addFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        if(f1.denominator != f2.denominator){
            Fraction[] tmp = makeCommonDenominator(f1, f2);
            return new Fraction(tmp[0].numerator + tmp[1].numerator, tmp[0].denominator, tmp[0].numeratorSqr, tmp[0].denominatorSqr);
        }
        return new Fraction(f1.numerator + f2.numerator, f1.denominator, f1.numeratorSqr, f1.denominatorSqr);
    }

    //dwa ułamki bo pierwiastki mogą być różne?
    public static Fraction subFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        if(f1.denominator != f2.denominator){
            Fraction[] tmp = makeCommonDenominator(f1, f2);
            return new Fraction(tmp[0].numerator - tmp[1].numerator, tmp[0].denominator, tmp[0].numeratorSqr, tmp[0].denominatorSqr);
        }
        return new Fraction(f1.numerator - f2.numerator, f1.denominator, f1.numeratorSqr, f1.denominatorSqr);
    }

    public static Fraction multiplyFractions(Fraction f1, Fraction f2) throws IncorrectFractionException{
        return new Fraction(f1.numerator * f2.numerator, f1.denominator * f2.denominator, f1.numeratorSqr * f2.numeratorSqr, f1.denominatorSqr *f2.denominatorSqr);
    }

    public static Fraction divFractions(Fraction f1, Fraction f2) throws IncorrectFractionException, IllegalMathOperation{
        if(f2.numerator == 0){
            throw new IllegalMathOperation("Dividing by zero!");
        }
        return new Fraction(f1.numerator * f2.denominator, f1.denominator * f2.numerator, f1.numeratorSqr * f2.denominatorSqr, f1.denominatorSqr * f2.numeratorSqr);
    }

    //TODO
    //Aktualnie dziala dla punktow wejciowych bez pierwiastkow
    public static Fraction sqrFraction(Fraction f) throws IncorrectFractionException{
        Fraction tmp = new Fraction(1, 1, f.numerator, f.denominator);
        tmp.reduce();
        return tmp;
    }

    public static Fraction powFraction(Fraction f) throws IncorrectFractionException{
        f = new Fraction(f.numeratorSqr * f.numeratorSqr * f.numerator * f.numerator, f.denominatorSqr * f.denominatorSqr * f.denominator * f.denominator);
        return f;
    }

    public void reduce(){
        if(numerator == 0){
            denominator = 1;
            numeratorSqr = 1;
            denominatorSqr = 1;
            return;
        }
        if((denominatorSqr == numeratorSqr) && denominatorSqr > 1){
            numeratorSqr = 1;
            denominatorSqr = 1;
        }
        if(denominatorSqr > 1){
            numeratorSqr *= denominatorSqr;
            denominator *= denominatorSqr;
            denominatorSqr = 1;
        }
        if(numeratorSqr > 3){
            int max = numeratorSqr;
            for(int i = max; i > 3; i--){
                if(numeratorSqr % i == 0){
                    int tmp = (int)Math.sqrt(i);
                    if(tmp * tmp == i){
                        numerator *= tmp;
                        numeratorSqr /= (tmp * tmp);
                    }
                }
            }
        }
        int i = numerator < denominator ? numerator : denominator;
        for(i = Math.abs(i); i >= 2; i--){
            if(numerator % i == 0 && denominator % i == 0){
                numerator /= i;
                denominator /= i;
                i = numerator < denominator ? numerator : denominator;
            }
        }
    }

    public static Fraction[] makeCommonDenominator(Fraction f1, Fraction f2) throws IncorrectFractionException {
        Fraction[] out = new Fraction[2];
        Fraction f1Copy = new Fraction(f1.numerator, f1.denominator, f1.numeratorSqr, f1.denominatorSqr);
        Fraction f2Copy = new Fraction(f2.numerator, f2.denominator, f2.numeratorSqr, f2.denominatorSqr);
        int denominatorOfF1 = f1Copy.denominator;
        int denominatorOfF2 = f2Copy.denominator;
        f1Copy.numerator *= denominatorOfF2;
        f1Copy.denominator *= denominatorOfF2;
        f2Copy.numerator *= denominatorOfF1;
        f2Copy.denominator *= denominatorOfF1;
        out[0] = f1Copy;
        out[1] = f2Copy;
        return out;
    }

    @Override
    public String toString(){
        String num = "" + numerator;
        String den = "" + denominator;
        if(numeratorSqr > 1){
            num += "√" + numeratorSqr;
        }
        if(denominatorSqr > 1){
            den += "√" + denominatorSqr;
        }
        return String.format("%s/%s", num, den);
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
        return this.numerator == p.numerator && this.denominator == p.denominator && this.numeratorSqr == p.numeratorSqr && this.denominatorSqr == p.denominatorSqr;
    }

    
    @Override
    public int compareTo(Fraction o) {
        if(this.denominator != o.denominator){
            int currDenom = this.denominator;
            int currSecondDenom = o.denominator;
            this.denominator *= currSecondDenom;
            this.numerator *= currSecondDenom;
            o.denominator *= currDenom;
            o.numerator *= currDenom;
        }
        int out = Integer.compare(this.numerator, o.numerator);
        this.reduce();
        o.reduce();
        return out;
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public int getNumeratorSqr(){
        return numeratorSqr;
    }

    public int getDenominatorSqr(){
        return denominatorSqr;
    }
}
