public class day31 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        
        String pre = strs[0];
        int i = 1;
        
        while(i < strs.length && pre.length() != 0){
            if(strs[i].startsWith(pre)){
                i++;
            }
            else{
                pre = pre.substring(0 , pre.length() - 1);
            }
        }
        return pre;
    }

    public int getLucky(String s, int k) {
        int ans = convert(s);
        for(int i = 0; i < k - 1; i++) {
            ans = transform(ans);
        }
        return ans;
    }
    public int convert(String num) {
        int ans = 0;
        for(char ch : num.toCharArray()) {
            ans += transform(ch - 'a' + 1);
        }
        return ans;
    }
    
    public int transform(int num) {
        int ans = 0;
        while(num != 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }
}
