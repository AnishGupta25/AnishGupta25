public class jan3 {
    public int numMagicSquaresInside(int[][] grid) {
        int mag_sq = 0;
        
        for(int i = 0; i <= grid.length - 3; i++){
            for(int j = 0; j <= grid[0].length - 3; j++){
                if(IsMagicSquare(grid , i , j)) mag_sq++;
            }
        }
        return mag_sq;
    }
    
    public boolean IsMagicSquare(int[][] grid , int i , int j){
        if(grid[i+1][j+1] != 5) return false;
        if(grid[i][j] % 2 != 0 || grid[i+2][j] % 2 != 0 || grid[i][j+2] % 2 != 0 || grid[i+2][j+2] % 2 != 0) return false;
        if(grid[i+1][j] % 2 == 0 || grid[i][j+1] % 2 == 0 || grid[i+1][j+2] % 2 == 0 || grid[i+2][j+1] % 2 == 0) return false;
        if(grid[i][j] + grid[i+1][j] + grid[i+2][j] != 15 ||
          grid[i][j] + grid[i][j+1] + grid[i][j+2] != 15 ||
          grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] != 15 ||
          grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] != 15) return false;
        
        return true;
    }
}
