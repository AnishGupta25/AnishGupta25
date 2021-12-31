import java.util.*;
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

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++; 
                    i--;
                }
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                }
                else if (skipT > 0) {
                    skipT--;
                    j--;
                }
                else break;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false;
            i--; 
            j--;
        }
        return true;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> ans = new ArrayList();
        int i = 0, j = 0;
    
        while (i < A.length && j < B.length) {
          int lo = Math.max(A[i][0], B[j][0]);
          int hi = Math.min(A[i][1], B[j][1]);
          if (lo <= hi) ans.add(new int[]{lo, hi});
    
          if (A[i][1] < B[j][1]) i++;
          else j++;
        }
        return ans.toArray(new int[ans.size()][]);
      }
}
