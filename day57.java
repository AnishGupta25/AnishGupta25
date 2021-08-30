import java.util.*;
public class day57 {
    public String reverseParentheses(String s) {
        if(s.length() == 0) return s;
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                Queue<Character> qu = new ArrayDeque<>();
                while(st.peek() != '('){
                    qu.add(st.pop());
                }
                st.pop();
                while(qu.size() > 0){
                    st.push(qu.remove());
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        while(st.size() > 0){
            str.append(st.pop());
        }
        
        return str.reverse().toString();
    }
}
