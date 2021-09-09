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
    
    public ListNode middleNode1(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if(head == null) return;
        
        ListNode mid = Mid(head);
        ListNode rev = reverse(mid);
        ListNode temp = head;
        while(temp != null && rev != null){
            ListNode next1 = temp.next;
            ListNode next2 = rev.next;
            
            temp.next = rev;
            rev.next = next1;
            temp = next1;
            rev = next2;
        }
    }
    
    public ListNode Mid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
    
        while (fast.next != null && fast.next.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode res = null;
        ListNode r = res;
        while (l1 != null && l2 != null) {
          if (l1.val <= l2.val) {
            r.next = l1;
            l1 = l1.next;
            r = r.next;
          }
          else if (l2.val < l1.val) {
            r.next = l2;
            l2 = l2.next;
            r = r.next;
          }
        }
        if (l1 != null) r.next = l1;
        if (l2 != null) r.next = l2;
    
        return res.next;
      }

    public static ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        
        ListNode mid = middleNode(head);
        ListNode rh = mid.next;
        mid.next = null;
        
        return mergeTwoLists(mergeSort(head) , mergeSort(rh));
    }
}
