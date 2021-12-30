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
}
