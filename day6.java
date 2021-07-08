public class day6 {
    int getNthFromLast(Node head, int n){
        int size = 0;
        Node temp = head;
        
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n > size || n < 0){
            return -1;
        }
        temp = head;
        
        while(n > 0){
            temp = temp.next;
            n--;
        }
        
        while(temp != null){
            temp = temp.next;
            head = head.next;
        }
        
        return head.data;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode r = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                r.next = l1;
                l1 = l1.next;
                r = r.next;
            }
            else if(l2.val < l1.val){
                r.next = l2;
                l2 = l2.next;
                r = r.next;
            }
        }
        
        while(l1 != null){
            r.next = l1;
            l1 = l1.next;
            r = r.next;
        }

        while(l2 != null){
            r.next = l2;
            l2 = l2.next;
            r = r.next;
        }
        return res.next;
    }
}
