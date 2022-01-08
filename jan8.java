public class jan8 {
    public int majorityElement(int[] nums) {
        int idx = 0 , freq = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[idx]) freq++;
            else freq--;
            
            if(freq < 0){
                idx = i;
                freq = 1;
            }
        }
        return nums[idx];
    }
}
