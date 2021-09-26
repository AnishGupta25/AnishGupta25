import java.util.*;
public class day84 {
    int search(String pat, String txt) {
        int p[] = new int[26];
        int t[] = new int[26];
        
        for(int i = 0; i < pat.length(); i++){
            p[pat.charAt(i) - 'a']++;
            t[txt.charAt(i) - 'a']++;
        }
        int count = 0;
        if(Arrays.equals(p , t)) count++;
        
        for(int i = pat.length(); i < txt.length(); i++){
            t[txt.charAt(i - pat.length()) - 'a']--;
            t[txt.charAt(i) - 'a']++;
            if(Arrays.equals(p , t)) count++;
        }
        return count;
    }

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        TreeNode root = BuiltHelper(preorder , inorder , 0 , n-1 , 0 , n-1);
        return root;
    }
    
    public TreeNode BuiltHelper(int[] preorder, int[] inorder , int ps , int pe , int is , int ie){
        if(ps > pe) return null;
        
        TreeNode node = new TreeNode(preorder[ps]);
        
        int k = -1;
        for(int i = is; i <= ie; i++){
            if(inorder[i] == node.val){
                k = i;
                break;
            }
        }
        int cls = k - is;
        
        node.left = BuiltHelper(preorder , inorder , ps+1 , ps+cls , is , k-1);
        node.right = BuiltHelper(preorder , inorder , ps+cls+1 , pe , k+1 , ie);
        
        return node;
    }
}
