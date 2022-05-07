package pl.edu.pw.ee;

public class Line {
    private Point p1, p2;
    public Line(){
        assignPoints(new Point(), new Point());
    }
    public Line(Point p1, Point p2){
        assignPoints(p1, p2);
    }

    private void assignPoints(Point first, Point second){
        if(first.getX() < second.getX()){
            this.p1 = first;
            this.p2 = second;
        }
        else{
            this.p1 = second;
            this.p2 = first;
        }
    }
    
    public String getP1(){
        return p1.toString();
    }

    public String getP2(){
        return p2.toString();
    }

    public double[] getFunc(){
        double a;
        double b = 0;
        double y = 1;
        if(Double.compare(p1.getX(), p2.getX()) == 0){
            a = 1;
            b = p1.getX();
            y = 0;
        }
        else{
            a = (p2.getY() - p1.getY())/(p2.getX() - p1.getX());
            double[] firstEquation = {p1.getY(), p1.getX(), 1};
            double[] secondEquation = {p2.getY(), p2.getX(), 1};
            double tmpA = (firstEquation[0] - firstEquation[2])/firstEquation[1];
            double[] tmpEquation = {secondEquation[0], secondEquation[1]*tmpA+1};
            b = tmpEquation[0]/tmpEquation[1];
        }
        return new double[]{y,a,b};
    }

    public double getLength(){
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
    }

    public Point getCenter(){
        return new Point((p1.getX()+p2.getX())/2, (p1.getY() + p2.getY())/2);
    }

    //TODO przemyśleć
    public boolean checkPerpendicularity(Line second){
        double[] tmpThis = this.getFunc();
        double[] tmpSecond = second.getFunc();
        if((Double.compare(tmpThis[0], 0) == 0 && Double.compare(tmpSecond[1], 0) == 0) || (Double.compare(tmpThis[1], 0) == 0 && Double.compare(tmpSecond[0], 0) == 0)){
            return true;
        }
        return (this.getFunc()[1]*second.getFunc()[1] == -1);
    }

    //TODO: delete
    public void showFunc(){
        double[] tmp = this.getFunc();
        System.out.printf("y:%f a:%f b:%f\n", tmp[0], tmp[1], tmp[2]);
    }
}
