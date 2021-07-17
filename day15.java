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
}
