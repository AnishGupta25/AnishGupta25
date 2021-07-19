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
}
