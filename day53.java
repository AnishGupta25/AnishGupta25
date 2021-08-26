public class day53 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                String str = s.substring(j , i+1);
                if(wordDict.contains(str)){
                    if(j > 0){
                        dp[i] += dp[j - 1];
                    }
                    else{
                        dp[i] += 1;
                    }
                }
            }
        }
        return dp[s.length()-1] > 0;
    }
}
