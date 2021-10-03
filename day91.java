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

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board , 0 , 0);
    }
    
    public boolean solveSudokuHelper(char[][] board , int i , int j){
        if(j == board[0].length){
            i = i + 1;
            j = 0;
        }
        
        if(i == board.length) return true;
        
        if(board[i][j] != '.') return solveSudokuHelper(board , i , j+1);
        
        for(char num = '1'; num <= '9'; num++){
            if(isValid(board, i , j , num)){
                board[i][j] = num;
                boolean solved = solveSudokuHelper(board , i , j+1);
                if(solved) return true;
                else board[i][j] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board , int i , int j , char num){
        for (int r = 0; r < board.length; r++) {
          if (board[r][j] == num) return false;
        }
        for(int c = 0; c < board.length; c++){
            if (board[i][c] == num) return false;
        }
        
        int x = (i / 3) * 3;
        int y = (j / 3) * 3;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(board[x + r][y + c] == num) return false;
            }
        }
        return true;
    }
}
