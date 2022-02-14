public class feb14 {
    class TreeNode{
        TreeNode left, right;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int lht = maxDepth(root.left);
        int rht = maxDepth(root.right);
        
        return Math.max(lht , rht) + 1;
    }
}
