public class day38 {
    public void flatten(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left != null){
            TreeNode tail = Tail(root.left);
            tail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    public TreeNode Tail(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}
