import java.util.*;
public class day75 {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0, x = 0;
        for(int i = 0; i < k; i++){
            int val1 = j < arr1.length ? arr1[j] : Integer.MAX_VALUE;
            int val2 = x < arr2.length ? arr2[x] : Integer.MAX_VALUE;
            if(val1 <= val2){
                pq.add(val1);
                j++;
            } 
            else{
                pq.add(val2);
                x++;
            } 
        }
        return new Long(pq.poll());
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left , root2.left);
        root.right = mergeTrees(root1.right , root2.right);
        
        return root;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[1];
        
        ArrayList<Integer> a = new ArrayList<>();
        
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : nums2){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        
        for(int i : nums1){
            if(map.keySet().contains(i) && map.get(i) > 0){
                a.add(i);
                map.put(i , map.get(i) - 1);
            }
        }
        
        int[] arr = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            arr[i] = a.get(i);
        }
        return arr;
    }

    public boolean isPowerOfTwo(int n) {
        if(n==0) return(false);
        if(n==1) return(true);
        if(n%2==0) return(isPowerOfTwo(n/2));
        else return false;
    }
}
