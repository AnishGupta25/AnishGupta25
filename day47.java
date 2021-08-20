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
}
