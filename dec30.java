import java.util.*;
public class dec30 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val){this.val = val;}
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode res = new ListNode(-1);
        ListNode itr = res;
        
        ListNode cur = head;
        ListNode fwd = head.next;
        
        while(cur != null){
            boolean repeat = false;
            while(fwd != null && cur.val == fwd.val){
                repeat = true;
                cur = fwd;
                fwd = cur.next;
            }
            if(!repeat){
                itr.next = new ListNode(cur.val);
                itr = itr.next;
            }
            cur = fwd;
            fwd = (cur != null ? cur.next : null);
        }
        
        return res.next;
    }

    public int smallestRepunitDivByK(int k) {
        if(k == 1) return 1;
        if(k % 2 == 0 || k % 5 == 0) return -1;
        
        int base = 1, ans = 1;
        
        while(base % k != 0){
            base = (base * 10  + 1) % k;
            ans++;
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int a = nums[i];
            int start = i+1, end = nums.length-1;
            while(start < end){
                int sum = a + nums[start] + nums[end];
                if(sum > 0){
                    end--;
                }else if(sum < 0){
                    start++;
                }else{
					result.add(Arrays.asList(a,nums[start],nums[end]));
                    while(start< end && nums[start] == nums[start+1])
                        start++;	
                    while( start< end && nums[end] == nums[end-1])
                        end--;
                    start++;
                    end--;
                }
            }
        }
        return result;
    }
}
