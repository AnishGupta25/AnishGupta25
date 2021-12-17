public class dec17 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        
        int res = Integer.MIN_VALUE;
        
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i == m-1 && j == n-1 || i == m-1 || j == n-1){
                    dp[i][j] = matrix[i][j] - '0';
                }else{
                    int min = Math.min(dp[i][j+1],Math.min(dp[i+1][j+1],dp[i+1][j]));
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1+min;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        
        return res * res;
    }
}
