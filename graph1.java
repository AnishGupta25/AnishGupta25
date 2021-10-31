import java.util.*;
public class graph1 {
    public int maxDistance(int[][] grid) {
        Queue<Pair> qu = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) qu.add(new Pair(i , j));
            }
        }
        int[][] dist = new int[grid.length][grid[0].length];
        
        int maxd = -1;
        while(qu.size() > 0){
            Pair temp = qu.remove();
            for(int i = 0; i < 4; i++){
                int row = temp.x + dirs[i][0];
                int col = temp.y + dirs[i][1];
                if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 0){
                    dist[row][col] = dist[temp.x][temp.y] + 1;
                    maxd = Math.max(maxd , dist[row][col]);
                    qu.add(new Pair(row , col));
                    grid[row][col] = -1;
                }
            }
        }
        return maxd;
    }
    
    public int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    public class Pair{
        int x , y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
}
