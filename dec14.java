public class dec14 {
    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
    }
    int sum1 = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        int lp = rangeSumBST(root.left , low , high);
        int rp = rangeSumBST(root.right , low , high);
        
        if(root.val <= high && root.val >= low) sum1 += root.val;
        return sum1;
    }
}
