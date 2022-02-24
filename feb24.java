public class feb24 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = Mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        return Merge(sortList(head) , sortList(nhead));
    }
    
    public ListNode Merge(ListNode l1 , ListNode l2){
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            }
            else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l1 != null) res.next = l1;
        if(l2 != null) res.next = l2;
        return dummy.next;
    }
    
    public ListNode Mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
