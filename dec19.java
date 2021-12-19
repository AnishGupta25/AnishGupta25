import java.util.*;
public class dec19 {
    public String decodeString(String s) {
        Stack<Integer> si = new Stack<>();
        Stack<String> ss = new Stack<>();
        String res = "";
        int i = 0;
        
        while(i < s.length()){
            char cur = s.charAt(i);
            
            if(Character.isDigit(cur)){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                si.push(num);
            }
            else if(cur == '['){
                ss.push(res);
                res = "";
                i++;
            }
            else if(cur == ']'){
                StringBuilder sb = new StringBuilder(ss.pop());
                int count = si.pop();
                while(count-- > 0){
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }
            else{
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }
}
