public class day34 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int arr[] = new int[2];
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(hm.containsKey(target - nums[i])){
                arr[0] = i;
                arr[1] = hm.get(target - nums[i]);
                break;
            }
            hm.put(nums[i] , i);
        }
        return arr;
    }
}
