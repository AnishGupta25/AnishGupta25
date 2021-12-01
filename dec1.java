import java.util.*;
public class dec1 {
    public int firstUniqChar(String str) {
        if(str.length() == 1) return 0;
        
        int[] freq = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            freq[str.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < str.length(); i++){
            if(freq[str.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    class MyQueue {
        Stack<Integer> st;
        public MyQueue() {
            st = new Stack<>();
        }
        
        public void push(int x) {
            st.add(0 , x);
        }
        
        public int pop() {
            return st.pop();
        }
        
        public int peek() {
            return st.peek();
        }
        
        public boolean empty() {
            return st.isEmpty();
        }
    }
    
}
