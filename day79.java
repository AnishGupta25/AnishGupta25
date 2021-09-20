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

    static int maxCandy(int height[], int n) {
	    if(n <= 2) return 0;
	    
	    int i = 0, j = n - 1;
	    int max = 0;
	    while(i < j){
	        int val1 = height[i];
	        int val2 = height[j];
	        
	        int temp = Math.min(val1 , val2) * (j - i - 1);
	        max = Math.max(max , temp);
	        if(val1 < val2) i++;
	        else if(val1 > val2) j--;
	        else{
	            i++;
	            j--;
	        }
	    }
	    return max;
	}
}
