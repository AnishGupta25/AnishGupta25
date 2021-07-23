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

    public static Node add(Node node, int data) {
        if(node == null) return new Node(data , null , null);
        
        if(data < node.data){
            node.left = add(node.left , data);
            return node;
        }
        else if(data > node.data){
            node.right = add(node.right , data);
            return node;
        }
        else return node;
    }

    public static int size(Node node) {
        if(node == null) return 0;
        int left = size(node.left);
        int right = size(node.right);
        return left + right + 1;
    }
    
    public static int sum(Node node) {
        if(node == null) return 0;
        int left = sum(node.left);
        int right = sum(node.right);
        return left + right + node.data;
    }
    
    public static int max(Node node) {
        if(node.right == null) return node.data;
        int right = max(node.right);
        return right;
    }
    
    public static int min(Node node) {
        if(node.left == null) return node.data;
        int left = min(node.left);
        return left;
    }
    
    public static boolean find(Node node, int data){
        if(node == null) return false;
        if(data < node.data){
            return find(node.left , data);
        }
        else if(data > node.data){
            return find(node.right , data);
        }
        else return true;
    }  
}
