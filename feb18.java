import java.util.*;
public class feb18 {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
