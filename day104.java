
public class day104 {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return (helper(root));
    }
    
    public boolean helper(TreeNode root){
        if(root == null) return true;
        
        boolean ls = helper(root.left);
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        boolean rs = helper(root.right);
        
        return (ls && rs);
    }

    class TreeNode{
        int val;
        TreeNode right , left;
        TreeNode(int val){
            this.val = val;
        }
    }
}
