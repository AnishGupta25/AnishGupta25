public class day42 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null || head.next == null) return head;
        
        ListNode OrigHead = null;
        ListNode OrigTail = null;
        ListNode tempHead = head;
        ListNode tempTail = head;
        ListNode cur = head;
        int size = size(head);
        
        while(size >= k){
            int tempk = k;
            while(tempk-- > 1){
                tempTail = tempTail.next;
                cur = tempTail.next;
            }
            reverse(tempHead , tempTail);
            if(OrigHead == null){
                OrigHead = tempTail;
                OrigTail = tempHead;
            }
            else{
                OrigTail.next = tempTail;
                OrigTail = tempHead;
            }
            size -= k;
            tempHead = tempTail = cur;
        }
        OrigTail.next = tempHead;
        return OrigHead;
    }
    
    public void reverse(ListNode slow , ListNode fast){
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != fast){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        curr.next = prev;
    }
    
    public int size(ListNode head){
        ListNode temp = head;
        int size = 0;
        
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
}
