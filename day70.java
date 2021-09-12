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

    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        
        int i = 0, j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            }
            else if(sum > target) j--;
            else i++;
        }
        return ans;
    }
}
