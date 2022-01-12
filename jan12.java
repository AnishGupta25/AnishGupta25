public class jan12 {
    class TreeNode{
        TreeNode right , left;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        if(val>root.val)
            root.right = insertIntoBST(root.right, val);
        else if(val<root.val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
