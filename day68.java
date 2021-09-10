import java.util.*;
public class day68 {
    public int search(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;
        
        while(i <= j){
            int mid = (i+j) / 2;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)) end = mid-1;
            else start = mid+1;
        }
        return start;
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        return i;
    }

    public static int minIndexChar(String str, String patt){
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int minIndex = Integer.MAX_VALUE;
     
        int m = str.length();
        int n = patt.length();
     
        for (int i = 0; i < m; i++)
            if(!hm.containsKey(str.charAt(i))) hm.put(str.charAt(i),i);
     
        for (int i = 0; i < n; i++)
            if (hm.containsKey(patt.charAt(i)) && hm.get(patt.charAt(i)) < minIndex) minIndex = hm.get(patt.charAt(i));
        if (minIndex != Integer.MAX_VALUE) return minIndex;
        return -1;
    }
}
