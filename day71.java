public class day71 {
    public String reverseWords(String s) {
        if(s.length() == 1) return s;
        
        String[] str = s.trim().split("\\s+");
        
        for(int i = 0; i < str.length; i++){
            String word = str[i];
            str[i] = reverse(word);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        for(int i = 1; i < str.length; i++){
            sb.append(" "+ str[i]);
        }
        return sb.toString();
    }
    
    public String reverse(String word){
        char[] c = word.toCharArray();
        
        int j = c.length-1;
        StringBuilder sb = new StringBuilder();
        while(j >= 0){
            sb.append(c[j]);
            j--;
        }
        return sb.toString();
    }

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
