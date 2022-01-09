public class jan9 {
    public int firstMissingPositive(int[] nums) {
        int l = 0 , r = 0; 
        while(l < nums.length){
            if(nums[l] <= 0) l++;
            else{
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r++;
                l++;
            }
        }
        
        for(int i = 0; i < r; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(idx >= 0 && idx < r && nums[idx] > 0) nums[idx] = -nums[idx];
        }
        
        for(int i = 0; i < r; i++){
            if(nums[i] > 0) return i+1;
        }
        
        return r + 1;
    }

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE , min2 = Integer.MAX_VALUE; 
        int max1 = Integer.MIN_VALUE , max2 = Integer.MIN_VALUE , max3 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] > max3) max3 = nums[i];
            
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] < min2) min2 = nums[i];
        }
        return Math.max((min1 * min2 * max1) , (max1 * max2 * max3));
    }
}
