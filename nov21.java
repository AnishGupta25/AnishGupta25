import java.util.*;
public class nov21 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            
            Integer count = map.get(ch);
            
            if(count == null) return false;
            else if(count > 1) map.put(ch , map.getOrDefault(ch , 0) - 1);
            else if(count == 1) map.remove(ch);
        }
        return true;
    }
}
