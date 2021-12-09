import java.util.*;
public class dec9 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> qu = new ArrayDeque<>();
        
        qu.add(start);
        
        while(!qu.isEmpty()){
            int idx = qu.poll();
            
            if(arr[idx] == 0) return true;
            
            int r = idx + arr[idx];
            int l = idx - arr[idx];
            
            arr[idx] = -1;
            
            if(r < arr.length && arr[r] != -1) qu.add(r);
            if(l >= 0 && arr[l] != -1) qu.add(l);
        }
        return false;
    }
}
