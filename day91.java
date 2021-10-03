import java.util.*;
public class day91 {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(adj , vis , i)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean[] vis , int src){
        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(src , -1));
        vis[src] = true;
        while(pq.size() > 0){
            int cur = pq.peek().src;
            int par = pq.remove().par;
            
            for(Integer i : adj.get(cur)){
                if(!vis[i]){
                    pq.add(new Pair(i , cur));
                    vis[i] = true;
                }
                else if(i != par) return true;
            }
        }
        return false;
    }
    
    class Pair {
        int src;
        int par;
    
        Pair(int src, int par) {
          this.src = src;
          this.par = par;
        }
    }
}
