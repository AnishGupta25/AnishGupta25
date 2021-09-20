public class day79 {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for(String word : words){
            if(check(word , s)) res++;
        }
        return res;
    }
    
    public boolean check(String word , String str){
        if(str.length() < word.length()) return false;
        int i = 0, j = 0, m = str.length(), n = word.length();
        
        while(i < m && j < n){
            if(str.charAt(i) != word.charAt(j)) return false;
            else{
                if(i == m-1 && j == n-1) return true;
                int lstr = i , lword = j;
                while(i < m && str.charAt(i) == str.charAt(lstr)) i++;
                while(j < n && word.charAt(j) == word.charAt(lword)) j++;
                
                int countstr = i - lstr , countword = j - lword;
                if(countstr < countword) return false;
                if(countstr == 2 && countword == 1) return false;
            }
        }
        return i == m && j == n;
    }
}
