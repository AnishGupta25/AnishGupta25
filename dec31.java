public class dec31 {
    class TreeNode{
        int val;
        TreeNode left , right;
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        
        return helper(root , root.val , root.val);
    }
    
    public int helper(TreeNode root , int curMin , int curMax){
        if(root == null) return curMax - curMin;
        
        curMax = Math.max(curMax , root.val);
        curMin = Math.min(curMin , root.val);
        
        int left = helper(root.left , curMin , curMax);
        int right = helper(root.right , curMin , curMax);
        
        return Math.max(left , right);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int Area = 0;
        
        while(left < right){
            int width = height[left] < height[right] ? height[left] : height[right];
            int length = right - left;
            int curArea = length * width;
            
            if(curArea > Area){
                Area = curArea;
            }
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return Area;
    }
}
