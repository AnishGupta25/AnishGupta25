import java.util.*;
public class dec24 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> Integer.compare(a[0] , b[0]));
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        for(int[] temp : intervals){
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < temp[0]) ans.add(temp);
            else ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1] , temp[1]);
            
        }
         return ans.toArray(new int[ans.size()][]);
    }
}
