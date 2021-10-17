import java.util.*;
public class day105 {
    class TreeNode{
        TreeNode left , right;
        int val;
        TreeNode(int val) {this.val = val;}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        TreeNode cur = root;
        
        while(cur != null){
            TreeNode lc = cur.left;
            
            if(lc == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode rm = getrightNode(cur , lc);
                
                if(rm.right == null){
                    rm.right = cur;
                    cur = cur.left;
                }
                else if(rm.right == cur){
                    res.add(cur.val);
                    rm.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    
    public TreeNode getrightNode(TreeNode cur , TreeNode lc){
        TreeNode rm = lc;
        
        while(rm.right != null && rm.right != cur) rm = rm.right;
        
        return rm;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        TreeNode cur = root;
        
        while(cur != null){
            
            TreeNode rc = cur.right;
            
            if(rc == null){
                res.add(cur.val);
                cur = cur.left;
            } 
            else{
                TreeNode lm = getleftNode(cur , rc);
                
                if(lm.left == cur){
                    lm.left = null;
                    cur = cur.left;
                }
                else if(lm.left == null){
                    res.add(cur.val);
                    lm.left = cur;
                    cur = cur.right;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
    
    public TreeNode getleftNode(TreeNode cur , TreeNode rc){
        TreeNode lm = rc;
        
        while(lm.left != null && lm.left != cur) lm = lm.left;
        
        return lm;
    }
}
