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
}
