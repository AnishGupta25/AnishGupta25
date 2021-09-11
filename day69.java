public class day69 {
    public int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if((nums[right] * nums[right]) > (nums[left] * nums[left])){
                res[i] = nums[right] * nums[right];
                right--;
            }
            else{
                res[i] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        reverse(nums , 0 , nums.length-1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , nums.length-1);
    }
    
    public void reverse(int[] nums, int i , int j){
        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            i++;
            j--;
        }
    }
}
