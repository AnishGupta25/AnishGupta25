public class dec28 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode b_Head = new ListNode(0);
        ListNode bHead = b_Head;
        ListNode A_Head = new ListNode(0);
        ListNode aHead = A_Head;
        
        while(head != null){
            if(head.val < x){
                bHead.next = head;
                bHead = bHead.next;
            }
            else{
                aHead.next = head;
                aHead = aHead.next;
            }
            head = head.next;
        }
        
        aHead.next = null;
        
        bHead.next = A_Head.next;
        
        return b_Head.next;
    }
}
