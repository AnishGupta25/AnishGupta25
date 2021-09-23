public class day81 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode pivit(ListNode head){
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sh = new ListNode(-1);
        ListNode st = sh;
        
        ListNode lh = new ListNode(-1);
        ListNode lt = lh;
        
        ListNode last = pivit(head);
        
        ListNode cur = head;
        while(cur != null){
            if(cur.val <= last.val){
                st.next = cur;
                st = st.next;
            }
            else{
                lt.next = cur;
                lt = lt.next;
            }
            cur = cur.next;
        }
        lt.next = null;
        st.next = lh.next;
        return st;
    }

    public static ListNode getPivot(ListNode head , int idx){
        ListNode temp = head;
        
        while(idx-- > 0){
            temp = temp.next;
        }
        return temp;
    }
    
    public static ListNode segregate(ListNode head, int pivotIdx) {
        ListNode pivot = getPivot(head , pivotIdx);
        int pd = pivot.val;
        
        ListNode sh = new ListNode(-1);
        ListNode st = sh;
        
        ListNode lh = new ListNode(-1);
        ListNode lt = lh;
        
        ListNode cur = head;
        while(cur != null){
            if(cur == pivot){}
            else if(cur.val <= pd){
                st.next = cur;
                st = st.next;
            }
            else if(cur.val > pd){
                lt.next = cur;
                lt = lt.next;
            }
            cur = cur.next;
        }
        
        lt.next = null;
        st.next = pivot;
        pivot.next = lh.next;
        
        return sh.next;
    }
}
