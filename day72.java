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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        
        sumOfLeftLeavesHelper(root , 0);
        return sum;
    }
    
    public void sumOfLeftLeavesHelper(TreeNode root , int idx){
        if(root == null) return;
        
        if(idx == -1 &&(root.left == null && root.right == null)){
            sum += root.val;
            return;
        }
        
        sumOfLeftLeavesHelper(root.left , -1);
        sumOfLeftLeavesHelper(root.right , 1);
    }
}
