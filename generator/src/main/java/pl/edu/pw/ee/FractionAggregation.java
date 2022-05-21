package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.Arrays;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class FractionAggregation {
    private ArrayList<Fraction> fractions = new ArrayList<>();

    public FractionAggregation(ArrayList<Fraction> fractions){
        try {
            this.fractions = addInternally(fractions);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        deleteZeroIfNeeded();
    }

    public FractionAggregation(Fraction fraction){
        this.fractions.add(fraction);
    }

    public static FractionAggregation addFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException{
        ArrayList<Fraction> result = new ArrayList<>();
        for(int i = 0; i < f1.getSize(); i++){
            Fraction tmp = f1.getFraction(i);
            for(int j = 0; j < f2.getSize(); j++){
                if(f2.getFraction(j).getNumeratorSqr() == tmp.getNumeratorSqr()){
                    tmp = Fraction.addFractions(tmp, f2.getFraction(j));
                    f2.removeFraction(j);
                    j--;
                }
            }
            result.add(tmp);
        }
        for(int i = 0; i < f2.getSize(); i++){
            result.add(f2.getFraction(i));
        }
        return new FractionAggregation(result);
    }

    public static FractionAggregation subFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException{
        ArrayList<Fraction> result = new ArrayList<>();
        for(int i = 0; i < f1.getSize(); i++){
            Fraction tmp = f1.getFraction(i);
            for(int j = 0; j < f2.getSize(); j++){
                if(f2.getFraction(j).getNumeratorSqr() == tmp.getNumeratorSqr()){
                    tmp = Fraction.subFractions(tmp, f2.getFraction(j));
                    f2.removeFraction(j);
                    j--;
                }
            }
            result.add(tmp);
        }
        return new FractionAggregation(result);
    }

    public static FractionAggregation multiplyFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException{
        ArrayList<Fraction> multiplied = new ArrayList<>();
        for(int i = 0; i < f1.getSize(); i++){
            for(int j = 0; j < f2.getSize(); j++){
                multiplied.add(Fraction.multiplyFractions(f1.getFraction(i), f2.getFraction(j)));
            }
        }
        return new FractionAggregation(addInternally(multiplied));
    }

    //Actually works if denominator have two numbers. I think that`s enough
    public static FractionAggregation divideFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException, IllegalMathOperation{
        FractionAggregation result = null;
        if(f2.getSize() > 2){
            throw new IllegalArgumentException("App actually doesn`t support dividing by 3 numbers");
        }
        if(f2.getSize() == 2){
            FractionAggregation oppositeDenumerator = new FractionAggregation((ArrayList<Fraction>) Arrays.asList(f2.getFraction(0), new Fraction(-f2.getFraction(1).getNumerator(), f2.getFraction(1).getDenominator())));
            f1 = FractionAggregation.multiplyFA(f1, oppositeDenumerator);
            f2 = FractionAggregation.multiplyFA(f2, oppositeDenumerator);
        }
        f2 = new FractionAggregation(addInternally(f2.getList()));
        f1 = new FractionAggregation(addInternally(f1.getList()));
        ArrayList<Fraction> tmp = new ArrayList<>();
        for(int i = 0; i < f1.getSize(); i++){
            tmp.add(Fraction.divFractions(f1.getFraction(i), f2.getFraction(0)));
        }
        f2 = new FractionAggregation(addInternally(f2.getList()));
        return f2;
    }

    private void deleteZeroIfNeeded(){
        if(fractions.size() > 1){
            try {
                Fraction tmp = new Fraction(0, 1);
                for(int i = 0; i < fractions.size(); i++){
                    if(fractions.get(i).equals(tmp)){
                        fractions.remove(i);
                    }
                }
            } catch (IncorrectFractionException e) {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<Fraction> addInternally(ArrayList<Fraction> toAdd) throws IncorrectFractionException{
        ArrayList<Fraction> result = new ArrayList<>();
        while(toAdd.size() > 0){
            Fraction tmp = toAdd.get(0);
            for(int i = 1; i < toAdd.size(); i++){
                if(tmp.getNumeratorSqr() == toAdd.get(i).getNumeratorSqr()){
                    tmp = Fraction.addFractions(tmp, toAdd.get(i));
                    toAdd.remove(i);
                    i--;
                }
            }
            result.add(tmp);
            toAdd.remove(0);
        }
        return result;
    }

    @Override
    public String toString(){
        String out = "(";
        // if(fractions.get(0).getNumerator() < 0){
        //     out += "-";
        // }
        out += fractions.get(0).toString();

        for(int i = 1; i < fractions.size(); i++){
            Fraction f = fractions.get(i);
            if(f.getNumerator() >= 0 ){
                out += " + ";
            }

            out += f.toString();
        }
        out += ")";
        return out;
    }

    public int getSize(){
        return fractions.size();
    }

    public Fraction getFraction(int index){
        return fractions.get(index);
    }

    public void removeFraction(int index){
        fractions.remove(index);
    }

    public ArrayList<Fraction> getList(){
        return fractions;
    }
}
