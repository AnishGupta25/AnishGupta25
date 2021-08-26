import java.util.*;
public class day53 {
    public boolean wordBreak(String s, ArrayList<String> wordDict) {
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

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(st.size() == 0) st.push(ch);
            else if(st.size() != 0 && st.peek() == ch) st.pop();
            else st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
}
