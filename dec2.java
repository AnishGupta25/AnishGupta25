import java.util.*;
public class dec2 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evn = head.next;
        
        while(evn != null && evn.next != null){
            odd.next = odd.next.next;
            evn.next = evn.next.next;
            
            odd = odd.next;
            evn = evn.next;
        }
        odd.next = even;
        return head;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else{
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
