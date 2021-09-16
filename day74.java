import java.util.*;
public class day74 {
    public List<Integer> spiralOrder(int[][] mat) {
        int rmin = 0, cmin = 0, rmax = mat.length - 1, cmax = mat[0].length - 1;
        int count = 0 , tw = mat.length *  mat[0].length;
        List<Integer> ans = new ArrayList<>();
        while(count < tw){
            for(int i = rmin , j = cmin; j <= cmax && count < tw; j++){
                ans.add(mat[i][j]);
                count++;
            }
            for(int i = rmin + 1 , j = cmax; i <= rmax && count < tw; i++){
                ans.add(mat[i][j]);
                count++;
            }
            for(int i = rmax , j = cmax - 1; j >= cmin && count < tw; j--){
                ans.add(mat[i][j]);
                count++;
            }
            for(int i = rmax - 1 , j = cmin; i > rmin && count < tw; i--){
                ans.add(mat[i][j]);
                count++;
            }
            rmin++;
            cmin++;
            rmax--;
            cmax--;
        }
        return ans;
    }
}
