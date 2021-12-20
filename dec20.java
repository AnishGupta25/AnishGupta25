import java.util.*;
public class dec20 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList();
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < arr.length; i++){
            int dif = arr[i] - arr[i-1];
            if(dif < min){
                ans.clear();
                ans.add(Arrays.asList(arr[i-1] , arr[i]));
                min = dif;
            }
            else if(dif == min) ans.add(Arrays.asList(arr[i-1] , arr[i]));
        }
        return ans;
    }
}
