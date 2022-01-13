import java.util.*;
public class jan13 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a , b) -> Integer.compare(a[1],b[1]));
        
        int arrows = 1;
        int dia = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > dia){
                arrows += 1;
                dia = points[i][1];
            }
        }
        return arrows;
    }

    public String complexNumberMultiply(String num1, String num2) {
        String eq1[] = num1.split("\\+|i");
        String eq2[] = num2.split("\\+|i");
        
        int a = Integer.parseInt(eq1[0]);
        int b = Integer.parseInt(eq1[1]);
        
        int c = Integer.parseInt(eq2[0]);
        int d = Integer.parseInt(eq2[1]);
        
        return (a * c - b * d) + "+" + (a * d + b * c) + "i";
    }
}
