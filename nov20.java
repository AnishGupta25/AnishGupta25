
public class nov20 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r * c != mat.length * mat[0].length) return mat;
        
        int[][] arr = new int[r][c];
        
        int col = 0 , row = 0;
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                arr[row][col++] = mat[i][j];
                
                if(col == c){
                    col = 0;
                    row++;
                }
            }
        }
        return arr;
    }
}