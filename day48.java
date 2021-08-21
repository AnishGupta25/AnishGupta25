public class day48 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        int countA = 0, countB = 0;
        
        while(a > 0 || b > 0){
            if((a >= b && countA < 2) || (a > 0 && countB == 2)){
                sb.append('a');
                a--;
                countB = 0;
                countA++;
            }
            else if((b >= a && countB < 2) || (b > 0 && countA == 2)){
                sb.append('b');
                b--;
                countA = 0;
                countB++;
            }
            else return "";
        }
        return sb.toString();
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
