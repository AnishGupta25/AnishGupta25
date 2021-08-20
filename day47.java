import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class day47 {
    public static void orderofcompile(ArrayList<Edge>[] graph, int vtces) {
        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < vtces; i++) {
          if (!visited[i]) {
            Topological(graph, st, visited, i);
          }
        }
        while (st.size() > 0) {
          System.out.println(st.pop());
        }
    }
    
    public static void Topological(ArrayList<Edge>[] graph, Stack<Integer> st, boolean[] visited, int src) {
        visited[src] = true;
        for (Edge e : graph[src]) {
          if (!visited[e.nbr]) {
            Topological(graph, st, visited, e.nbr);
          }
        }
        st.push(src);
    }

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
}
