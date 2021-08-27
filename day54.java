import java.util.*;
public class day54 {
    public int minSteps(int n) {
        if(n == 1) return 0;
        if(n == 2) return 2;
        int dp[] = new int[n+1];
        dp[2] = 2;
       
        for(int i = 3; i <= n; i++){
             int j = i / 2;
            while(j >= 1){
                if(i % j == 0){
                    dp[i] = Math.min(i , dp[j] + i/j);
                    break;
                }
                j--;
            }
        }
        return dp[n];
    }
}
