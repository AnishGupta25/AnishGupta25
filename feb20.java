import java.util.*;
public class feb20 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int ans = 0, cur = 0;
        for(int[] interval : intervals){
            if(cur < interval[1]){
                ans++;
                cur = interval[1];
            }
        }
        return ans;
    }
}
