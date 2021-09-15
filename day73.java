import java.util.*;
public class day73 {
    public static void sort012(int a[], int n){
        int i = 0 , j = 0 , k = n - 1;
        
        while(j <= k){
            if(a[j] == 1){
                j++;
            }
            else if(a[j] == 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                
                i++;
                j++;
            }
            else if(a[j] == 2){
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
                k--;
            }
        }
    }
    public int lengthOfLongestSubstring(String s) {
        int i = -1 , j = -1;
        int ans = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i < s.length() - 1){
                flag1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch , map.getOrDefault(ch , 0) + 1);
                
                if(map.get(ch) > 1) break;
                else {
                    int len = i - j;
                    if(len > ans) ans = len;
                }
            }
            
            while(j < i){
                flag2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch , map.get(ch) - 1);
                
                if(map.get(ch) == 1) break;
            }
            if(!flag1 && !flag2) break;
        }
        return ans;
    }
}
