public class day92 {
    int maxSubstring(String S) {
        int max_val = 0 , count = 0 , ans = 0 , temp = 0;
        
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '0') temp = 1;
            else{
                temp = -1;
                count++;
            }
            max_val = Math.max(max_val + temp , temp);
            ans = Math.max(ans , max_val);
        }
        if(count == S.length()) return -1;
        return ans;
    }
}
