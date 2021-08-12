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

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode res = new ListNode(-1);
        ListNode itr = res;
        
        ListNode cur = head;
        ListNode fwd = head.next;
        
        while(cur != null){
            boolean repeat = false;
            while(fwd != null && cur.val == fwd.val){
                repeat = true;
                cur = fwd;
                fwd = cur.next;
            }
            if(!repeat){
                itr.next = new ListNode(cur.val);
                itr = itr.next;
            }
            cur = fwd;
            fwd = (cur != null ? cur.next : null);
        }
        
        return res.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        int size = size(head);
        if(k % size == 0) return head;
        k = size - (k % size);
        ListNode temp = head;
        while(k - 1 > 0){
            temp = temp.next;
            k--;
        }
        ListNode start = temp.next;
        temp.next = null;
        
        ListNode last = start;
        while(last.next != null){
            last = last.next;
        }
        
        last.next = head;
        head = start;
        
        return head;
    }
    
    public int size(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prefix = null;
        while(right-- > 1){
            fast = fast.next;
        }
        ListNode tail = fast.next;
        
        while(left-- > 1){
            prefix = slow;
            slow = slow.next;
        }
        
        reverse(slow , fast);
        if(prefix == null){
            head = fast;
            slow.next = tail;
        }
        else{
            prefix.next = fast;
            slow.next = tail;
        }
        return head;
    }
    
    public void reverse(ListNode slow , ListNode fast){
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != fast){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        curr.next = prev;
    }
}
