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

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]) l = mid + 1;
            else if(nums[mid] < nums[r]) r = mid;
        }
        return nums[l];
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r =nums.length - 1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            
            if(mid == 0 || nums[mid] > nums[mid - 1]){
                if(mid == nums.length - 1 || nums[mid + 1] < nums[mid]) return mid;
                else l = mid + 1;
            }
            else r = mid - 1;
        }
        return 0;
    }
}
