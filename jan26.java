import java.util.*;
public class jan26 {
    class TreeNode{
        TreeNode left , right;
        int val;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        
        inorder(root1 , t1);
        inorder(root2 , t2);
        merge(t1 , t2 , res);
        
        return res;
    }
    
    public void inorder(TreeNode root , List<Integer> list){
        if(root == null) return;
        
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }
    
    public void merge(List<Integer> t1 , List<Integer> t2 , List<Integer> res){
        int i = 0 , j = 0;
        
        while(i < t1.size() && j < t2.size()){
            if(t1.get(i) <= t2.get(j)){
                res.add(t1.get(i));
                i++;
            }
            else{
                res.add(t2.get(j));
                j++;
            }
        }
        
        while(i < t1.size()){
            res.add(t1.get(i));
            i++;
        } 
        while(j < t2.size()){
            res.add(t2.get(j));
            j++;
        } 
    }
}
