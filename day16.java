public class day16 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        
        int maxP = 0;
        int maxA = 0;
        
        for(int i = 0; i < n - 1; i++){
            maxP = Math.max(0 , maxP += prices[i+1] - prices[i]);
            if(maxP > maxA) maxA = maxP;
        }
        
        return maxA;
    }

    public int fib(int n) {
        int dp[] = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            if(i == 0){
                dp[i] = 0;
            }
            else if(i == 1){
                dp[i] = 1;
            }
            else{
                dp[i] = dp[i-1] + dp[i - 2];
            }
        }
        
        return dp[n];
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodep = NodetoRoot(root , p);
        int n = nodep.size();
        List<TreeNode> nodeq = NodetoRoot(root , q);
        int m = nodeq.size();
        
        int i = n - 1, j = m - 1;
        
        while(i >= 0 && j >= 0){
            TreeNode D1 = nodep.get(i);
            TreeNode D2 = nodeq.get(j);
            if(D1.val == D2.val){
                i--;
                j--;
            }
            else break;   
        }
        return nodep.get(i+1);
    }
    
    public static List<TreeNode> NodetoRoot(TreeNode root, TreeNode node){
        if(root == null) return new ArrayList<>();
        
        if(root.val == node.val){
            List<TreeNode> res = new ArrayList<>();
            res.add(root);
            return res;
        }
        
        List<TreeNode> lres = NodetoRoot(root.left , node);
        if(lres.size() > 0){
            lres.add(root);
            return lres;
        }
        
        List<TreeNode> rres = NodetoRoot(root.right , node);
        if(rres.size() > 0){
            rres.add(root);
            return rres;
        }
        
        return new ArrayList<>();
    }
}
