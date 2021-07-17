public class day15 {
    int lo = 0 , hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[lo] <= nums[mid]){
                if(nums[mid] > target && nums[lo] <= target){
                    hi = mid - 1;
                }
                else{
                    lo = mid + 1;
                }
            } 
            else{
                if(nums[mid] <= target && nums[hi] >= target){
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                sum = nums[i];
            }
            else{
                sum = Math.max(nums[i] , sum + nums[i]);
            }
            
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
