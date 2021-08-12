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
}
