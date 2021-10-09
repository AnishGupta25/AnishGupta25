import java.util.*;
public class day97 {
    public int findK(int a[][], int n, int m, int k){
	    int rmin = 0, cmin = 0, rmax = a.length - 1 , cmax = a[0].length - 1 , count = 1;
	    
	    while(count != k){
	        for(int i = rmin , j = cmin; j <= cmax && count < k; j++){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        for(int i = rmin + 1 , j = cmax; i <= rmax && count < k; i++){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        for(int i = rmax , j = cmax - 1; j >= cmin && count < k; j--){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        for(int i = rmax - 1 , j = cmin; i > rmin && count < k; i--){
	            if(count == k) return a[i][j];
	            count++;
	        }
	        rmin++;
            cmin++;
            rmax--;
            cmax--;
	    }
	    return 0;
	}

	public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                if(!canpass(nums , i)) return false;
            }
        }
        return true;
    }
    
    public boolean canpass(int[] nums , int pos){
        for(int i = pos - 1; i >= 0; i--){
            if(nums[i] > pos - i) return true;
        }
        return false;
    }

	class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            ArrayList<Integer> arr = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = qu.remove();
                while(node != null){
                    arr.add(node.val);
                    if(node.right != null) qu.add(node.right);
                    node = node.left;
                }
            }
            list.add(arr);
        }
        
        return list;
    }
}
