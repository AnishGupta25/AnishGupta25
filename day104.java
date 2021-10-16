
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

    TreeNode pre , fst , snd;
    public void recoverTree(TreeNode root) {
        pre = fst = snd = null;
        
        helper(root);
        
        int temp = fst.val;
        fst.val = snd.val;
        snd.val = temp;
    }
    
    public void helper1(TreeNode root){
        if(root == null) return;
        
        helper1(root.left);
        
        if(pre != null && pre.val >= root.val){
            if(fst == null){
                fst = pre;
            } 
            snd = root;
        }
        pre = root;
        
        helper1(root.right);
    }
}
