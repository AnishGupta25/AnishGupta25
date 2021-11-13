import java.util.*;
public class stack1 {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < temp.length; i++){
            while(!st.isEmpty() && temp[st.peek()] < temp[i]){
                int tmp = st.pop();
                ans[tmp] = i - tmp;
            }
            st.push(i);
        }
        return ans;
    }
}
