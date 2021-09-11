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

    public int[] findDiagonalOrder(int[][] mat) {
        int res[] = new int[mat.length * mat[0].length];
        
        int r = 0; int c = 0;
        for(int i = 0; i < mat.length * mat[0].length; i++){
            res[i] = mat[r][c];
            if((r + c) % 2 == 0){
                if(c == mat[0].length - 1){
                    r++;
                }
                else if(r == 0){
                    c++;
                }
                else{
                    r--;
                    c++;
                }
            }
            else{
                if(r == mat.length - 1){
                    c++;
                }
                else if(c == 0){
                    r++;
                }
                else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
