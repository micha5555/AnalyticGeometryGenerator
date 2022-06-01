package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.Arrays;

import pl.edu.pw.ee.exceptions.IllegalMathOperation;
import pl.edu.pw.ee.exceptions.IncorrectFractionException;

public class FractionAggregation {
    private ArrayList<Fraction> fractions = new ArrayList<>();

    public FractionAggregation(){

    }

    public FractionAggregation(ArrayList<Fraction> fractions){
        for(Fraction fraction : fractions){
            fraction.reduce();
        }
        try {
            this.fractions = addInternally(fractions);
        } catch (IncorrectFractionException e) {
            e.printStackTrace();
        }
        deleteZeroIfNeeded();
    }

    public FractionAggregation(Fraction fraction){
        fraction.reduce();
        this.fractions.add(fraction);
    }

    public static FractionAggregation addFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException{
        ArrayList<Fraction> f1CopyList = new ArrayList<>();
        ArrayList<Fraction> f2CopyList = new ArrayList<>();
        f1CopyList.addAll(f1.getList());
        f2CopyList.addAll(f2.getList());
        FractionAggregation f1Copy = new FractionAggregation(f1CopyList);
        FractionAggregation f2Copy = new FractionAggregation(f2CopyList);
        ArrayList<Fraction> result = new ArrayList<>();
        for(int i = 0; i < f1Copy.getSize(); i++){
            Fraction tmp = f1Copy.getFraction(i);
            for(int j = 0; j < f2Copy.getSize(); j++){
                if(f2Copy.getFraction(j).getNumeratorSqr() == tmp.getNumeratorSqr()){
                    tmp = Fraction.addFractions(tmp, f2Copy.getFraction(j));
                    f2Copy.removeFraction(j);
                    j--;
                }
            }
            tmp.reduce();
            result.add(tmp);
        }
        for(int i = 0; i < f2Copy.getSize(); i++){
            f2Copy.getFraction(i).reduce();
            result.add(f2Copy.getFraction(i));
        }
        return new FractionAggregation(result);
    }

    public static FractionAggregation addFA(Fraction f1, Fraction f2) throws IncorrectFractionException{
        return FractionAggregation.addFA(new FractionAggregation(f1), new FractionAggregation(f2));
    }

    public static FractionAggregation addFA(Fraction f1, FractionAggregation f2) throws IncorrectFractionException{
        return FractionAggregation.addFA(new FractionAggregation(f1), f2);
    }

    public static FractionAggregation addFA(FractionAggregation f1, Fraction f2) throws IncorrectFractionException{
        return FractionAggregation.addFA(f1, new FractionAggregation(f2));
    }

    public static FractionAggregation subFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException{
        ArrayList<Fraction> f1CopyList = new ArrayList<>();
        ArrayList<Fraction> f2CopyList = new ArrayList<>();
        f1CopyList.addAll(f1.getList());
        f2CopyList.addAll(f2.getList());
        FractionAggregation f1Copy = new FractionAggregation(f1CopyList);
        FractionAggregation f2Copy = new FractionAggregation(f2CopyList);
        ArrayList<Fraction> result = new ArrayList<>();
        for(int i = 0; i < f1Copy.getSize(); i++){
            Fraction tmp = f1Copy.getFraction(i);
            for(int j = 0; j < f2Copy.getSize(); j++){
                if(f2Copy.getFraction(j).getNumeratorSqr() == tmp.getNumeratorSqr()){
                    //TU WYWALA!
                    tmp = Fraction.subFractions(tmp, f2Copy.getFraction(j));
                    f2Copy.removeFraction(j);
                    j--;
                }
            }
            tmp.reduce();
            result.add(tmp);
        }
        return new FractionAggregation(result);
    }

    public static FractionAggregation subFA(Fraction f1, Fraction f2) throws IncorrectFractionException{
        return FractionAggregation.subFA(new FractionAggregation(f1), new FractionAggregation(f2));
    }

    public static FractionAggregation subFA(Fraction f1, FractionAggregation f2) throws IncorrectFractionException{
        return FractionAggregation.subFA(new FractionAggregation(f1), f2);
    }

    public static FractionAggregation subFA(FractionAggregation f1, Fraction f2) throws IncorrectFractionException{
        return FractionAggregation.subFA(f1, new FractionAggregation(f2));
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

    public static FractionAggregation multiplyFA(Fraction f1, Fraction f2) throws IncorrectFractionException{
        return FractionAggregation.multiplyFA(new FractionAggregation(f1), new FractionAggregation(f2));
    }

    public static FractionAggregation multiplyFA(Fraction f1, FractionAggregation f2) throws IncorrectFractionException{
        return FractionAggregation.multiplyFA(new FractionAggregation(f1), f2);
    }

    public static FractionAggregation multiplyFA(FractionAggregation f1, Fraction f2) throws IncorrectFractionException{
        return FractionAggregation.multiplyFA(f1, new FractionAggregation(f2));
    }

    //Actually works if denominator have two numbers. I think that`s enough
    public static FractionAggregation divideFA(FractionAggregation f1, FractionAggregation f2) throws IncorrectFractionException, IllegalMathOperation{
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
            Fraction toAdd = Fraction.divFractions(f1.getFraction(i), f2.getFraction(0));
            toAdd.reduce();
            tmp.add(toAdd);
            
        }
        FractionAggregation out = new FractionAggregation(addInternally(tmp));
        return out;
    }

    public static FractionAggregation divideFA(Fraction f1, Fraction f2) throws IncorrectFractionException, IllegalMathOperation{
        return FractionAggregation.divideFA(new FractionAggregation(f1), new FractionAggregation(f2));
    }

    public static FractionAggregation divideFA(Fraction f1, FractionAggregation f2) throws IncorrectFractionException, IllegalMathOperation{
        return FractionAggregation.divideFA(new FractionAggregation(f1), f2);
    }

    public static FractionAggregation divideFA(FractionAggregation f1, Fraction f2) throws IncorrectFractionException, IllegalMathOperation{
        return FractionAggregation.divideFA(f1, new FractionAggregation(f2));
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

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof FractionAggregation)){
            return false;
        }
        FractionAggregation p = (FractionAggregation) o;
        int size1 = this.fractions.size();
        int size2 = p.fractions.size();
        if(size1 != size2){
            return false;
        }
        int cnt = 0;
        for(int i = 0; i < size1; i++){
            for(int j = 0; j < size1; j++){
                if(this.fractions.get(i).equals(p.fractions.get(j))){
                    cnt ++;
                    break;
                }
            }
        }
        return cnt == size1;
    }

    public int compareTo(FractionAggregation tocmp){
        double firstSum = 0;
        double tocmpSum = 0;
        Fraction tmp;
        for(int i = 0; i < this.getSize(); i++){
            tmp = this.getFraction(i);
            firstSum += (tmp.getNumerator() * Math.sqrt(tmp.getNumeratorSqr())) / (tmp.getDenominator() * Math.sqrt(tmp.getDenominatorSqr()));
        }
        for(int i = 0; i < tocmp.getSize(); i++){
            tmp = tocmp.getFraction(i);
            tocmpSum += (tmp.getNumerator() * Math.sqrt(tmp.getNumeratorSqr())) / (tmp.getDenominator() * Math.sqrt(tmp.getDenominatorSqr()));
        }
        return Double.compare(firstSum, tocmpSum);
    }

    public int getSize(){
        return fractions.size();
    }

    public Fraction getFraction(int index){
        Fraction toCopy = fractions.get(index);
        try {
            return new Fraction(toCopy.getNumerator(), toCopy.getDenominator(), toCopy.getNumeratorSqr(), toCopy.getDenominatorSqr());
        } catch (IncorrectFractionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void removeFraction(int index){
        fractions.remove(index);
    }

    public void addFraction(Fraction f){
        fractions.add(f);
    }

    public void clear(){
        fractions = new ArrayList<>();
    }

    public ArrayList<Fraction> getList(){
        return fractions;
    }

    public void abs() throws IncorrectFractionException{
        ArrayList<Fraction> tmp = new ArrayList<>();
        for(int i = 0; i < this.getSize(); i++){
            Fraction actual = this.getFraction(i);
            if(actual.getNumerator() >= 0){
                tmp.add(actual);
            }
            else{
                Fraction absFract = new Fraction(-actual.getNumerator(), actual.getDenominator(), actual.getNumeratorSqr(), actual.getDenominatorSqr());
                tmp.add(absFract);
            }
        }
        this.fractions = tmp;
    }
}
