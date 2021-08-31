import java.util.*;
public class day58 {
    public int scoreOfParentheses(String s) {
        if(s.length() == 0 || s.length() == 1) return 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(-1);
            }
            else{
                if(st.peek() == -1){
                    st.pop();
                    st.push(1);
                }
                else{
                    int val = 0;
                    while(st.peek() != -1){
                        val += st.pop();
                    }
                    st.pop();
                    st.push(2*val);
                }
            }
        }
        int val = 0;
        while(st.size() > 0){
            val += st.pop();
        }
        return val;
    }

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        
        int ans = arr[n-1] - arr[0];
        
        int small = arr[0] + k;
        int large = arr[n-1] - k;
        
        for(int i = 0; i < n-1; i++){
            int min = Math.min(small , arr[i+1] - k);
            int max = Math.max(large , arr[i] + k);
            ans = Math.min(ans , max - min);
        }
        return ans;
    }
}
