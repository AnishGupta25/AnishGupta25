public class day39 {
    void nextGreatest(int arr[], int n) {
        int maxR = arr[n - 1];
        arr[n - 1] = -1;
        for(int i = n - 2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = maxR;
            if(temp > maxR){
                maxR = temp;
            }
        }
    }

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        if(list1 == null || list2 ==null) return (list1 == null ? list2 : list1);
        
        ListNode l1 = reverse(list1);
        ListNode l2 = reverse(list2);
        ListNode res = new ListNode(-1);
        ListNode itr = res;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            
            carry = sum / 10;
            sum %= 10;
            itr.next = new ListNode(sum);
            itr = itr.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return reverse(res.next);
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;
    }
}
