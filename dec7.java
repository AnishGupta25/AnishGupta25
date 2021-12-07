public class dec7 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(){}
    }
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head != null){
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }
}
