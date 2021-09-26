import java.util.*;
public class day84 {
    int search(String pat, String txt) {
        int p[] = new int[26];
        int t[] = new int[26];
        
        for(int i = 0; i < pat.length(); i++){
            p[pat.charAt(i) - 'a']++;
            t[txt.charAt(i) - 'a']++;
        }
        int count = 0;
        if(Arrays.equals(p , t)) count++;
        
        for(int i = pat.length(); i < txt.length(); i++){
            t[txt.charAt(i - pat.length()) - 'a']--;
            t[txt.charAt(i) - 'a']++;
            if(Arrays.equals(p , t)) count++;
        }
        return count;
    }
}
