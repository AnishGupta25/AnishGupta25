public class jan31 {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for(int i = 0; i < accounts.length; i++){
            int temp = 0;
            for(int j = 0; j < accounts[0].length; j++){
                temp += accounts[i][j];
            }
            ans = Math.max(ans , temp);
            temp = 0;
        }
        return ans;
    }
}
