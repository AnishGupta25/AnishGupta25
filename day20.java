public class day20 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(p == null && q == null) {
                return true;
            }
            return false;
        }
        
        boolean left = isSameTree(p.left , q.left);
        boolean right = isSameTree(p.right , q.right);
        
        if(left == true && right == true && p.val == q.val){
            return true;
        }
        return false;
    }
}
