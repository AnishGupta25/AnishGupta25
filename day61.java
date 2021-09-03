import java.util.*;
public class day61 {
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if(idx == words.length){
            return 0;
        }
        
        int max1 = 0 + solution(words , farr , score , idx+1);
        boolean flag = true;
        String word = words[idx];
        int wordScore = 0;
        for(int i = 0; i < word.length(); i++){
            if(farr[word.charAt(i) - 'a'] == 0) flag = false;
            farr[word.charAt(i) - 'a']--;
            wordScore += score[word.charAt(i) - 'a'];
        }
        
        int max2 = 0;
        if(flag){
            max2 = wordScore + solution(words , farr , score , idx+1);
        }
        for(int i = 0; i < word.length(); i++){
            farr[word.charAt(i) - 'a']++;
        }
        
        return Math.max(max1 , max2);
    }

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
        if(pattern.length() == 0){
            if(str.length() == 0){
                boolean[] check = new boolean[26];
                for(int i = 0; i < op.length(); i++){
                    char ch = op.charAt(i);
                    if(!check[ch - 'a']){
                        check[ch - 'a'] = true;
                        System.out.print(ch+" -> "+map.get(ch)+", ");
                    }
                }
                System.out.print("."+"\n");
            }
            return;
        }
        char chp = pattern.charAt(0);
        String rop = pattern.substring(1);
        
        if(!map.containsKey(chp)){
            for(int i = 0; i < str.length(); i++){
                String cp = str.substring(0 , i+1);
                String ros = str.substring(i+1);
                
                map.put(chp , cp);
                solution(ros , rop , map , op);
                map.remove(chp);
            }
        }
        
        else{
            String patternMatching = map.get(chp);
            String patterntocheck = str.length() >= patternMatching.length() ? str.substring(0 , patternMatching.length()) : "-1";
            if(patterntocheck.equals(patternMatching)){
                solution(str.substring(patternMatching.length()) , rop , map , op);
            }
        }
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            String left = str.substring(0 , i+1);
            if(dict.contains(left)){
                wordBreak(str.substring(i+1) , ans + left + " ", dict);
            }
        }
    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        
        return ((n*(n + 1))/ 2) - sum;
    }
}
