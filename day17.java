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
}
