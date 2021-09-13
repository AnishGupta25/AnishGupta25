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

    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = -1;
        
        for(int i = arr.length - 2; i >= 0; i--){
            ans[i] = Math.max(arr[i+1] , ans[i+1]);
        }
        return ans;
    }

    public int maxDistToClosest(int[] seats) {
        if(seats.length == 2) return 1;
        int distance = 0, fpos = -1 , lpos = -1 , temp = 0;
        boolean flag = false;
        
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0) temp++;
            else{
                if(!flag){
                    flag = true;
                    fpos = i;
                }
                lpos = i;
                distance = Math.max(distance , temp);
                temp = 0;
            }
        }
        distance = Math.max((distance + 1) / 2 , Math.max(fpos , seats.length - 1 - lpos));
        
        return distance;
    }
}
