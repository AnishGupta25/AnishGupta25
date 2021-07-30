import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class day27 {
    public static void BSFpath(ArrayList<Edge>[] graph , int vtx , boolean[] visited){
        Queue<BSFPair> queue = new ArrayDeque<>();
        queue.add(new BSFPair(vtx , vtx+""));
        
        while(queue.size()> 0){
            BSFPair head = queue.remove();
            
            if(visited[head.v] != true){
                visited[head.v] = true;
                System.out.println(head.v + "@" + head.path);
                for(Edge e : graph[head.v]){
                    if (!visited[e.nbr]){
                        queue.add(new BSFPair(e.nbr , head.path + e.nbr));
                    }
                }
            }
        }
      }
      
      public static class BSFPair{
        int v;
        String path;
        BSFPair(int v , String path){
            this.v = v;
            this.path = path;
        }
      
}
