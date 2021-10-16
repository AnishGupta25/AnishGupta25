
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
    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;
    
        Node(int val) {
          this.val = val;
        }
    }
      
    static Node pr , head , tail;
    
    public static Node bToDLL(Node root) {
        pr = head = tail = null;
        
        treetoll(root);
        tail = pr;
        
        tail.right = head;
        head.left = tail;
        
        return head;
    }
      
    public static void treetoll(Node root){
        if(root == null) return;
        
        treetoll(root.left);
        
        if(pr == null){
            head = root;
        }
        else{
            pr.right = root;
            root.left = pr;
        }
        pr = root;
        
        treetoll(root.right);
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
