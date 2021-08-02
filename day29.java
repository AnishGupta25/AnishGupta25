public class day29 {
  public static class info{
      int num_bst , max , min;
      boolean isbst;
      info(int num_bst , int max , int min , boolean isbst){
          this.num_bst = num_bst;
          this.max = max;
          this.min = min;
          this.isbst = isbst;
      }
  }
    
  public static info NumberOfBST(Node node){
      if(node == null) return new info(0, Integer.MIN_VALUE,Integer.MAX_VALUE, true);
      if (node.left == null && node.right == null) return new info(1, node.data,node.data, true);
      
      info L = NumberOfBST(node.left);
      info R = NumberOfBST(node.right);
      
      // info bst = new info();
      int min = Math.min(node.data, (Math.min(L.min, R.min)));
      int max = Math.max(node.data, (Math.max(L.max, R.max)));
      boolean isbst = false;
      int num_bst = L.num_bst + R.num_bst;
      if (L.isbst && R.isbst && node.data > L.max && node.data < R.min){
          isbst = true;
          num_bst = 1 + L.num_bst + R.num_bst;
      }
      return new info(num_bst , max , min , isbst);
  }

  int count;
  public int totalNQueens(int n) {
      printNQueens(new int[n][n] , 0);
      return count;
  }
  public void printNQueens(int[][] chess, int row){
      if(row == chess.length){
          count++;
      }
      
      for(int col = 0; col < chess.length; col++){
          if(isSafe(chess , row , col)){
              chess[row][col] = 1;
              printNQueens(chess  , row + 1);
              chess[row][col] = 0;
          }
      }
  }
  
  public boolean isSafe(int[][] chess , int r , int c){
      for (int i = r - 1, j = c; i >= 0; i--) {
        if (chess[i][j] == 1) {
          return false;
        }
      }
      for (int i = r - 1, j = c + 1; i >= 0 && j < chess[0].length; i--, j++) {
        if (chess[i][j] == 1) {
          return false;
        }
      }

      for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
        if (chess[i][j] == 1) {
          return false;
        }
      }

      return true;
  }

  public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
      
    for(int i = 0; i < nums.length - 1; i++){
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] + nums[j] == target){
                ans[0] = i;
                ans[1] = j;
                break;
            }
        }
    }
    return ans;
  }

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int Area = 0;
    
    while(left < right){
        int width = height[left] < height[right] ? height[left] : height[right];
        int length = right - left;
        int curArea = length * width;
        
        if(curArea > Area){
            Area = curArea;
        }
        if(height[left] < height[right]){
            left++;
        }
        else{
            right--;
        }
    }
    return Area;
  }
}
