package pl.edu.pw.ee;

public class Common {
    
    public static double rnd(double d){
        double tmpD = d * 100;
        tmpD = (double)Math.round(tmpD*10)/10;
        String tmpStr = String.valueOf(tmpD);
        int indexOfDot = tmpStr.indexOf('.');
        // Jeśli 2 miejsce po przecinku to 5, to dodaj 1, bo byłproblem przy zaokrąglaniu liczb ujemnych
        if(d < 0 && tmpStr.charAt(indexOfDot + 1) == '5'){
            tmpD -= 0.1;
        }
        return (double)Math.round(tmpD)/100;
    }
    
}
