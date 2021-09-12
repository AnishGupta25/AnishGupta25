public class day70 {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0; int j = 0;
        
        while(i < nums.length){
            if(nums[i] == 0){
                i++;
            }
            else if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }
}
