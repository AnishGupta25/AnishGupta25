public class dec29 {
    class Node{
        Node left , right , next;
    }
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root);
        return root;
    }
    
    public void helper(Node node){
        if(node == null) return;
        
        if(node.left != null && node.right != null){
            node.left.next = node.right;
        }
        if(node.next != null && node.right != null){
            node.right.next = node.next.left;
        }
        
        helper(node.left);
        helper(node.right);
    }
}
