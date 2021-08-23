public class day50 {
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
    public int sumNumbers(TreeNode root) {
        int ans[] = {0};
        helper(root , 0 , ans);
        return ans[0];
    }
    
    public void helper(TreeNode root , int current , int[] ans){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            ans[0] += current * 10 + root.val;
            return;
        }
        
        helper(root.left , current * 10 + root.val , ans);
        helper(root.right , current * 10 + root.val , ans);
    }
}
