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
}
