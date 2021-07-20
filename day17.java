public class day17 {
    public int findTilt(TreeNode root) {
        TiltPair tilt = find(root);
        return tilt.tiltOfTree;
    }
    
    public TiltPair find(TreeNode root) {
     if(root == null) return new TiltPair(0 , 0);
        
        TiltPair lpair = find(root.left);
        TiltPair rpair = find(root.right);
        
        int sum = lpair.sum + rpair.sum + root.val;
        int tiltOfNode = Math.abs(lpair.sum - rpair.sum);
        int tiltOfTree = lpair.tiltOfTree + rpair.tiltOfTree + tiltOfNode;
        
        return new TiltPair(sum , tiltOfTree);
    }
    
    public static class TiltPair{
        int sum, tiltOfTree;
        
        TiltPair(int sum, int tiltOfTree){
            this.sum = sum;
            this.tiltOfTree = tiltOfTree;
        }
    }

    boolean isBST(Node root){
        BSTpair tree = IsBst(root);
        return tree.bst;
    }
    
    public BSTpair IsBst(Node node){
        if(node == null) return new BSTpair(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        
        BSTpair lpair = IsBst(node.left);
        BSTpair rpair = IsBst(node.right);
        
        int max = Math.max(node.data , Math.max(lpair.max , rpair.max));
        int min = Math.min(node.data , Math.max(lpair.min , rpair.min));
        boolean bst = lpair.bst && rpair.bst && node.data < rpair.min && node.data > lpair.max;
        
        return new BSTpair(max , min , bst);
    }
    
    public class BSTpair{
        int max , min;
        Boolean bst;
        BSTpair(int max, int min, boolean bst){
            this.max = max;
            this.min = min;
            this.bst = bst;
        }
    }
}
