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
}
