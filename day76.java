import java.util.*;
public class day76 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> qu = new ArrayDeque<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i , j));
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
        while(qu.size() > 0){
            Pair temp = qu.remove();
            
            for(int i = 0; i < dirs.length; i++){
                int row = temp.x + dirs[i][0];
                int col = temp.y + dirs[i][1];
                if(row >= 0 && col >= 0 && row < mat.length && col < mat[0].length && mat[row][col] < 0){
                    mat[row][col] = mat[temp.x][temp.y] + 1;
                    qu.add(new Pair(row , col));
                }
            }
        }
        return mat;
    }
    
    public int[][] dirs = new int[][] {{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};
    
    class Pair{
        int x , y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
}
