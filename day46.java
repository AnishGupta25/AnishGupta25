import java.util.Arrays;

public class day46 {
    public int countGoodRectangles(int[][] rectangles) {
        int arr[] = new int[rectangles.length];
        int maxLen = 0;
        for(int i = 0; i < rectangles.length; i++){
            arr[i] = Math.min(rectangles[i][0] , rectangles[i][1]);
            if(arr[i] > maxLen) maxLen = arr[i];
        }
        int count = 0;
        for(int i = 0; i < rectangles.length; i++){
            if(arr[i] == maxLen) count++;
        }
        return count;
    }

    public String modifyString(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        
        for(int i = 0; i < n; i++){
            if(str[i] == '?' && i == 0){
                if(s.length() > 1){
                    for(char ch = 'a'; ch < 'z'; ch++){
                        if(str[i+1] != ch) str[i] = ch; 
                    }
                }
                else str[i] = 'a';
            }
            else if(str[i] == '?' && i == n-1){
                for(char ch = 'a'; ch < 'z'; ch++){
                    if(str[i-1] != ch) str[i] = ch; 
                }
            }
            else if(str[i] == '?'){
                for(char ch = 'a'; ch < 'z'; ch++){
                    if(str[i-1] != ch && str[i+1] != ch) str[i] = ch; 
                }
            }
        }
        
        return new String(str);
    }

    public int maxAscendingSum(int[] nums) {
        int MaxSum = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]) max += nums[i];
            else max = nums[i];
            if(max > MaxSum) MaxSum = max;
        }
        return MaxSum;
    }

    public static boolean find3Numbers(int A[], int n, int X) { 
        Arrays.sort(A);
        
        for(int i = 0; i < n; i++){
            int l = i+1;
            int r = n - 1;
            
            while(l < r){
                if(A[i] + A[l] + A[r] == X) return true;
                else if(A[i] + A[l] + A[r] > X) r--;
                else l++;
            }
        }
        return false;
    }
}
