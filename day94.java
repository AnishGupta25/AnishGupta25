import java.util.*;
public class day94 {
    public int editDistance(String s, String t) {
        int n = s.length() , m = t.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <=m; j++){
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1] , dp[i-1][j]));
            }
        }
        return dp[n][m];
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) res.add(idx+1);
            nums[idx] *= -1;
        }
        return res;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair{
        TreeNode node;
        int lvl;
        Pair(TreeNode node , int lvl){
            this.node = node;
            this.lvl = lvl;
        }
    }
    
    static int min;
    static int max;

    public static ArrayList<Integer> BottomView(TreeNode root) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        width(root , 0);
        
        int rvl = -min;
        int w = max - min + 1;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < w; i++) {
            list.add(-1);
        }
        
        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(root , rvl));
        
        while(!pq.isEmpty()){
            Pair temp = pq.remove();
            list.set(temp.lvl , temp.node.val);
            
            if(temp.node.left != null) pq.add(new Pair(temp.node.left , temp.lvl-1));
            if(temp.node.right != null) pq.add(new Pair(temp.node.right , temp.lvl+1));
        }
        return list;
    }

    public static void width(TreeNode node , int lvl){
        if(node == null) return;
        
        min = Math.min(min , lvl);
        max = Math.max(max , lvl);
        
        width(node.left , lvl-1);
        width(node.right , lvl+1);
    }
}
