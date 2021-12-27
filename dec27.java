public class dec27 {
    public int findComplement(int num) {
        int cou = num;
        int mask = 1;
        while(cou!=0){
            num = num^mask;
            mask = mask<<1;
            cou = cou>>1;
        }
        return num;
    }

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] == val) return 0;
        
        int l = 0 , r = nums.length - 1 , count = 0;
        
        while(l <= r){
            if(nums[l] == val){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                
                r--;
            }
            else{
                l++;
                count++;
            }
        }
        return count;
    }
}
