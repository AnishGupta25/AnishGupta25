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

    class Pair1{
        int time;
        int x , y;
        Pair1(int time , int x , int y){
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int forg = 0;
        Queue<Pair1> qu = new ArrayDeque<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) qu.add(new Pair1(0 , i , j));
                if(grid[i][j] == 1) forg++;
            }
        }
        
        int ans = 0;
        
        while(qu.size() > 0){
            Pair1 temp = qu.remove();
            
            for(int i = 0; i < dirs.length; i++){
                int row = temp.x + dirs[i][0];
                int col = temp.y + dirs[i][1];
                if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1){
                    grid[row][col] = 2;
                    qu.add(new Pair1(temp.time + 1 , row , col));
                    forg--;
                    ans = temp.time + 1;
                }
            }
        }
        return forg == 0 ? ans : -1;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0]-coordinates[0][0];
        int dy = coordinates[1][1]-coordinates[0][1];

        for(int i =1; i<coordinates.length-1; i++)
            if(dx*(coordinates[i+1][1]-coordinates[i][1]) != dy*(coordinates[i+1][0]-coordinates[i][0])) return false;

        return true;
    }

    List<Integer> querySum(int n, int arr[], int q, int queries[]){
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < queries.length; i += 2){
            int l = queries[i-1];
            int r = queries[i];
            int sum = 0;
            for(int j = l - 1; j < r; j++){
                sum += arr[j];
            }
            list.add(sum);
        }
        return list;
    }
}
