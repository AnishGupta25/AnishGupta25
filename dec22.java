public class dec22 {
    class ListNode{
        ListNode next;
        int val;
    }
    public void reorderList(ListNode head) {
        if(head == null) return;
        
        ListNode mid = Mid(head);
        ListNode rev = reverse(mid);
        ListNode temp = head;
        while(temp != null && rev != null){
            ListNode next1 = temp.next;
            ListNode next2 = rev.next;
            
            temp.next = rev;
            rev.next = next1;
            temp = next1;
            rev = next2;
        }
    }
    
    public ListNode Mid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;
    }
}
