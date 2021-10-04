public class day92 {
    int maxSubstring(String S) {
        int max_val = 0 , count = 0 , ans = 0 , temp = 0;
        
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '0') temp = 1;
            else{
                temp = -1;
                count++;
            }
            max_val = Math.max(max_val + temp , temp);
            ans = Math.max(ans , max_val);
        }
        if(count == S.length()) return -1;
        return ans;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head , slow = head , cur = head;
        int count = 1;
        
        while(cur != null){
            if(count < k) slow = slow.next;
            if(count > k) fast = fast.next;
            cur = cur.next;
            count++;
        }
        int temp = fast.val;
        fast.val = slow.val;
        slow.val = temp;
        
        return head;
    }
}
