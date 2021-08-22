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
}
