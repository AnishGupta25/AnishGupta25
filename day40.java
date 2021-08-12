public class day40 {
    public int getDecimalValue(ListNode head) {
        if(head.next == null) return head.val;
        
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        String str = sb.toString();
        int val = Integer.parseInt(str , 2);
        return val;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
    
        ListNode list1 = headA;
        ListNode list2 = headB;
        
        while(list1 != list2){
            list1 = list1 == null ? headB : list1.next;
            list2 = list2 == null ? headA : list2.next;
        }
        return list1;
    }
}
