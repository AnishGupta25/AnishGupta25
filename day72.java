public class day72 {
    public int[] findPeakGrid(int[][] mat) {
        if(mat.length == 1 && mat[0].length == 1){
            return new int[]{0,0};
        }
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(isPeek(mat , i , j)){
                    return new int[]{i,j};
                } 
            }
        }
        return new int[]{-1,-1};
    }
    
    public boolean isPeek(int[][] mat , int i , int j){
        for(int k = 0; k < mat[0].length; k++){
            if(mat[i][k] > mat[i][j]) return false;
        }
        for(int k = 0; k < mat.length; k++){
            if(mat[k][j] > mat[i][j]) return false;
        }
        return true;
    }
}
