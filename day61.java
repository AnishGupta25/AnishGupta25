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
}
