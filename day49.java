public class day49 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        if(root.val == val) return root;
        
        if(val < root.val && root.left != null){
            return searchBST(root.left , val);
        }
        
        if(val > root.val && root.right != null){
            return searchBST(root.right , val);
        }
        return null;
    }

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        if(i-1 >= 0 && j-2 >= 0 && chess[i-1][j-2]) return false;
        if(i-1 >= 0 && j+2 < chess.length && chess[i-1][j+2]) return false;
        if(i-2 >= 0 && j+1 < chess.length && chess[i-2][j+1]) return false;
        if(i-2 >= 0 && j-1 >= 0 && chess[i-2][j-1]) return false;
        return true;
    }

    public static void queensPermutations(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
          for (int row = 0; row < chess.length; row++) {
            for (int col = 0; col < chess.length; col++) {
              System.out.print(chess[row][col] != 0 ? "q"+chess[row][col]+"\t" : "-\t");
            }
            System.out.println();
          }
          System.out.println();
          return;
        }
        
        for(int i = 0; i < tq*tq; i++){
            int row = i / tq, col = i % tq;
            if(chess[row][col] == 0){
                chess[row][col] = qpsf + 1;
                queensPermutations(qpsf+1 , tq , chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j) {
        if (qpsf == tq) {
          for (int row = 0; row < chess.length; row++) {
            for (int col = 0; col < chess.length; col++) {
              System.out.print(chess[row][col] ? "q\t" : "-\t");
            }
            System.out.println();
          }
          System.out.println();
          return;
        }
    
        for (int k = i; k < tq * tq; k++) {
          int row = k / tq, col = k % tq;
          if (!chess[row][col]) {
            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess , k , j);
            chess[row][col] = false;
          }
        }
    }
}
