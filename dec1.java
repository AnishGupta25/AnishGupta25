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
    
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            map.put(magazine.charAt(i) , map.getOrDefault(magazine.charAt(i) , 0) + 1);
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            if(!map.containsKey(ransomNote.charAt(i))) return false;
            
            map.put(ransomNote.charAt(i) , map.get(ransomNote.charAt(i)) - 1);
            if(map.get(ransomNote.charAt(i)) < 0) return false;
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            arr[magazine.charAt(i) - 'a'] += 1;
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            if(arr[ransomNote.charAt(i) - 'a'] == 0) return false;
            
            arr[ransomNote.charAt(i) - 'a'] -= 1;
            if(arr[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
