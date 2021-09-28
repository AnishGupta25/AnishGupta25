public class day87 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length - 1;
        return construct(preorder , postorder , 0 , n , 0 , n);
    }
    
    public TreeNode construct(int[] preorder, int[] postorder , int preS , int preE , int postS , int postE){
        if(postS > postE) return null;
        
        TreeNode node = new TreeNode(preorder[preS]);
        int postIdx = postS;
        
        if(preS == preE) return node;
        
        while(preorder[preS + 1] != postorder[postIdx]){
            postIdx++;
        }
        
        int k = postIdx - postS + 1;
        
        node.left = construct(preorder , postorder , preS+1 , preS+k , postS , postIdx);
        node.right = construct(preorder , postorder , preS+k+1 , preE , postIdx+1 , postE-1);
        
        return node;
    }
}
