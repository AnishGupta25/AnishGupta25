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
}
