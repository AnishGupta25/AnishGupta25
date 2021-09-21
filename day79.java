import java.util.*;
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

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0] , nums[1]);
        else{
            nums[2] = Math.max(nums[0] + nums[2] , nums[1]);
            for(int i = 3; i < n; i++){
                nums[i] = nums[i] + Math.max(nums[i - 2] , nums[i - 3]);
            }
        }
        
        return Math.max(nums[n-1] , nums[n-2]);
    }

    public int minDeletions(String s) {
        int ans = 0;
        int arr[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 26; i++){
            while(arr[i] > 0 && set.contains(arr[i])){
                arr[i]--;
                ans++;
            }
            set.add(arr[i]);
        }
        return ans;
    }
}
