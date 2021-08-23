import java.util.ArrayList;
import java.util.HashSet;
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

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root , list);
        
        int i = 0, j = list.size() - 1;
        
        while(i < j){
            if(list.get(i).val + list.get(j).val < k){
                i++;
            }
            else if(list.get(i).val + list.get(j).val > k){
                j--;
            }
            else return true;
        }
        return false;
    }
    
    public void inOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        
        inOrder(root.left , list);
        list.add(root);
        inOrder(root.right , list);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        
        while(true){
            int val = 0;
            while(n > 0){
                int temp = n % 10;
                val += temp*temp;
                n /= 10;
            }
            if(val == 1) return true;
            else if(!set.contains(val)) set.add(val);
            else if(set.contains(val)) break;
            n = val;
        }
        return false;
    }
}
