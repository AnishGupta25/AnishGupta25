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
}
