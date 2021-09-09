public class day67 {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder str = new StringBuilder();
        long max = 0;
        for(int i = shifts.length - 1; i >= 0; i--){
            max += shifts[i];
        }
        
        for(int i = 0; i < s.length(); i++){
            long temp = s.charAt(i) - 'a' + 1;
            temp = (temp + max) % 26;
            char ch = (char)('a' + (temp - 1));
            if(temp == 0) ch = 'z';
            str.append(ch);
            max -= shifts[i];
        }
        return str.toString();
    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = middleNode(head);
        ListNode rev = reverse(temp);
        
        while(rev != null){
            if(head.val != rev.val) return false;
            
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;
    }
    
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
