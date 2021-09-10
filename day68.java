public class day68 {
    public int search(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;
        
        while(i <= j){
            int mid = (i+j) / 2;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)) end = mid-1;
            else start = mid+1;
        }
        return start;
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        return i;
    }
}
