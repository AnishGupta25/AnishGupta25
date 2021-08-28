import java.util.*;
public class day55 {
    static int mindiff = Integer.MAX_VALUE;
    static String ans = "";
    public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1, int soset2) {
        if(vidx == arr.length){
            if(Math.abs(soset1 - soset2) < mindiff){
                mindiff = Math.abs(soset1 - soset2);
                ans = set1 +" "+ set2;
            }
            return;
        }
        
        if(set1.size() < (arr.length+1)/ 2){
            set1.add(arr[vidx]);
            solve(arr , vidx+1 , set1 , set2 , soset1 + arr[vidx] , soset2);
            set1.remove(set1.size() - 1);
        }
        if(set2.size() < (arr.length+1)/ 2){
            set2.add(arr[vidx]);
            solve(arr , vidx+1 , set1 , set2 , soset1 , soset2 + arr[vidx]);
            set2.remove(set2.size() - 1);
        }
    }

    static int knapSack(int W, int wt[], int val[], int n) { 
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 1; i <= n; i++){
            int wgt = wt[i - 1];
            int v = val[i - 1];
            for(int j = 1; j <= W; j++){
                dp[i][j] = dp[i - 1][j];
                if(wgt <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - wgt] + v);
                }
            }
        }
        return dp[n][W];
    } 

    public static void combination(int i, String ustr, int ssf, int ts, String asf ) {
        if (i == ustr.length()) {
          if (ssf == ts) {
            System.out.println(asf);
          }
          return;
        }
    
        char ch = ustr.charAt(i);
        combination(i+1, ustr, ssf+1, ts, asf + ch);
        combination(i+1, ustr, ssf, ts, asf);
    }
}
