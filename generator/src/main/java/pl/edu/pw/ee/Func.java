package pl.edu.pw.ee;

public class Func {
    private double y = 1;
    private double a;
    private double b;
    public Func(double y, double a, double b){
        this.y = y;
        if(Double.compare(y, 0) == 0){
            this.a = -a;
        }
        else{
            this.a = a;
        }
        this.b = b;
    }

    public double[] getFunc(){
        return new double[]{y, a, b};
    }

    public double getY(){
        return y;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    @Override
    public String toString(){
        return String.format("%.2fy=%.2fx+%.2f", y, a, b);
    }
    
}
