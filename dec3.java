import java.util.*;
public class dec3 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int l = 1, r = 1, ans = nums[0];
        
        for(int i = 0; i < n; i++){
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;
            
            l *= nums[i];
            r *= nums[n - i - 1];
            
            ans = Math.max(ans , Math.max(r , l));
        }
        return ans;
    }

    public int binaryGap(int n) {
        char[] bits = Integer.toBinaryString(n).toCharArray();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1') indices.add(i);
        }
        if (indices.size() == 1) return 0;
        int ans = 0;
        for (int i = 0; i < indices.size()-1; i++) {
            ans = Math.max(ans, indices.get(i+1)-indices.get(i));
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1 , -1};
        boolean flag = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target && !flag){
                arr[0] = i;
                arr[1] = i;
                flag = true;
            } 
            else if(nums[i] == target && flag) arr[1] = i;
        }
        return arr;
    }
}
