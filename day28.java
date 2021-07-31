import java.util.ArrayList;
import java.util.Stack;

public class day28 {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int nums = digits[i] + carry;
            if(i == digits.length - 1){
                nums += 1;
            }
            carry = nums / 10;
            nums = nums%10;
            res.add(0 , nums);
        }
        if(carry != 0){
            res.add(0 , carry);
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }

    public boolean isValid(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        
        for(int i = 1; i < n; i++){
            char ch = chars[i];
            
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                st.push(ch);
            }
            
            else{
                if(st.size() == 0) return false;
                char pre = st.peek();
                if(pre == '(' && chars[i] == ')') st.pop();
                else if(pre == '[' && chars[i] == ']') st.pop();
                else if(pre == '{' && chars[i] == '}') st.pop();
                
                else return false;
            }
        }
        
        if(st.size() > 0) return false;
        return true;
    }
}
