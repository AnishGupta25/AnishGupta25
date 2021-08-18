public class day45 {
    public int largestAltitude(int[] gain) {
        if(gain.length == 0) return 0;
        
        int sum = 0;
        int maxAlti = -1000000;
        for(int i = 0; i < gain.length; i++){
            sum += gain[i];
            if(sum > maxAlti) maxAlti = sum;
            if(maxAlti < 0) maxAlti = 0;
        }
        return maxAlti;
    }

    public static class ListNode {
        int val = 0;
        ListNode next = null;
    
        ListNode(int val) {
          this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
