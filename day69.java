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
}
