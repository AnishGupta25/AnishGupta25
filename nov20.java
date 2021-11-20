import java.util.*;
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

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> row = null;
        row = new ArrayList<>();
        row.add(1);
        result.add(row);

        if (numRows == 1) return result;

        for (int i = 2; i <= numRows; i++) {

            int left = 0, right = i - 1;
            int rowArray[] = new int[i];
            rowArray[left++] = 1;
            rowArray[right--] = 1;

            List<Integer> prev = result.get(i - 2);

            while (left <= right) {
                rowArray[left] = prev.get(left - 1) + prev.get(left);
                rowArray[right] = prev.get(right) + prev.get(right - 1);
                left++;
                right--;
            }

            row = new ArrayList<>();

            for (int num : rowArray) row.add(num);

            result.add(row);
        }
        return result;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        int row = 0 , col = mat[0].length - 1;
        
        while(row < mat.length && col >= 0){
            if(mat[row][col] == target) return true;
            else if(mat[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}