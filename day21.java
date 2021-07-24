import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
 
public class day21 {
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void display(ArrayList<Edge>[] graph){
        int vtces = graph.length;
        for(int i = 0 ; i < vtces ; i++){
            ArrayList<Edge> list = graph[i];
            System.out.print(i+" -> ");
            for(Edge e : list){
                System.out.print(e.nbr+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
 
        int vtces = scn.nextInt();
        int edges = scn.nextInt();
 
        ArrayList<Edge>[] graph = new ArrayList[vtces];
 
        for(int i = 0 ; i < vtces ; i++){
            graph[i] = new ArrayList<Edge>();
        }
 
        for(int i = 0 ; i < edges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
 
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
 
        display(graph);        
    }

    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest) {
        boolean arr[] = new boolean[graph.length];
        
        boolean path =  hasPathHelper(graph , src , dest , arr);
        
        return path;
    }
      
    public static boolean hasPathHelper(ArrayList<Edge>[] graph , int src , int dest , boolean arr[]){
        if(src == dest) return true;
          
        arr[src] = true;
        
        for(Edge e : graph[src]){
            if(arr[e.nbr] == false){
                boolean res = hasPathHelper(graph, e.nbr, dest, arr);
                if(res) return true;
            }
        }
        
        return false;
    }

    public static void printallPath(ArrayList<Edge>[] graph , int src , int dest) {
        boolean arr[] = new boolean[graph.length];
        printallPathHelper(graph , src , dest , arr , "");
        // return path;
    }
      
    public static void printallPathHelper(ArrayList<Edge>[] graph , int src , int dest , boolean arr[], String psf){
        if(src == dest){
            System.out.println(psf+src);
            return;
        }
          
        arr[src] = true;
        
        for(Edge e : graph[src]){
            if(arr[e.nbr] == false){
                printallPathHelper(graph, e.nbr, dest, arr, psf+src);
                arr[e.nbr] = false;
            }
        }
    }

    public static class dsfPair{
        int vtx;
        String psf;
        dsfPair(int vtx , String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
      
    public static void DFS(ArrayList<Edge>[] graph , int src){
        
        boolean visited[] = new boolean[graph.length];
        Stack<dsfPair> st = new Stack<>();
        st.push(new dsfPair(src , src+""));
        
        while(st.size() > 0){
            dsfPair top = st.pop();
            if(visited[top.vtx] == false){
                System.out.println(top.vtx+"@"+top.psf);
                visited[top.vtx] = true;
                for(Edge e : graph[top.vtx]){
                    if(visited[e.nbr] == false){
                        st.push(new dsfPair(e.nbr , top.psf+e.nbr));
                    }
                }
            }
        }
    }
}
 
/*
7
8
0 3 40
0 1 10
1 2 10
2 3 10
3 4 4
4 5 3
5 6 3
4 6 8
*/