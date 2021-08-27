import java.util.*;
public class day54 {
    public int minSteps(int n) {
        if(n == 1) return 0;
        if(n == 2) return 2;
        int dp[] = new int[n+1];
        dp[2] = 2;
       
        for(int i = 3; i <= n; i++){
             int j = i / 2;
            while(j >= 1){
                if(i % j == 0){
                    dp[i] = Math.min(i , dp[j] + i/j);
                    break;
                }
                j--;
            }
        }
        return dp[n];
    }

    public int minSteps2(int n) {
        if(n == 1) return 0;
        if(n == 2) return 2;
        
        int ans = 0;
        int d = 2;
        while(n > 1){
            while(n %  d== 0){
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length == 1) return barcodes;
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i = 0; i < barcodes.length; i++){
            map.put(barcodes[i], map.getOrDefault(barcodes[i] , 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1 , n2) -> map.get(n2) - map.get(n1));
        
        for(int key : map.keySet()){
            pq.add(key);
        }
        Arrays.fill(barcodes , 0);
        int idx = 0;
        
        while(!pq.isEmpty()){
            if(idx == barcodes.length) break;
            
            int key = pq.poll();
            
            if(idx == 0 || barcodes[idx - 1] != key){
                barcodes[idx] = key;
                if(map.get(key) > 1){
                    map.put(key , map.get(key) - 1);
                    pq.add(key);
                } 
            }
            
            else{
                int key2 = pq.poll();
                barcodes[idx] = key2;
                if(map.get(key2) > 1){
                    map.put(key2 , map.get(key2) - 1);
                     pq.add(key2);
                } 
                pq.add(key);
            }
            idx++;
        }
        return barcodes;
    }
}
