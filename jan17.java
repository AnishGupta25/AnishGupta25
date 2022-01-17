import java.util.*;
public class jan17 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> dic = new HashMap<Character, String>(); 
        Set<String> word_set = new HashSet<String>();;
        Set<Character> pattern_set = new HashSet<Character>();
        String[] words = s.split(" ");
        for (String word: words) word_set.add(word);
        for (char c: pattern.toCharArray()) pattern_set.add(c);
        if (words.length != pattern.length() || word_set.size() != pattern_set.size()) return false;
        for (int i = 0; i < words.length; i++) {
            if (dic.containsKey(pattern.charAt(i))) { 
                if (!dic.get(pattern.charAt(i)).equals(words[i])) return false; 
            } else {
                dic.put(pattern.charAt(i), words[i]);
            }
        }
        return true;   
    }
}
