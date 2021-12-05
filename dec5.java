public class dec5 {
    class TreeNode{
        int val;
        TreeNode right , left;
        TreeNode(){}
    }
    public int rob(TreeNode root) {
        Pair res = robHelper(root);
        return Math.max(res.inc , res.exc);
    }
    
    public Pair robHelper(TreeNode root){
        if(root == null) return new Pair(0 , 0);
        
        Pair lp = robHelper(root.left);
        Pair rp = robHelper(root.right);
        
        int inc = root.val + lp.exc + rp.exc;
        int exc = Math.max(lp.inc , lp.exc) + Math.max(rp.inc , rp.exc);
        
        return new Pair(inc , exc);
    }
    
    class Pair{
        int inc , exc;
        Pair(int inc , int exc){
            this.inc = inc;
            this.exc = exc;
        }
    }
}
