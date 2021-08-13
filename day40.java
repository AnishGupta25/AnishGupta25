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

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evn = head.next;
        
        while(evn != null && evn.next != null){
            odd.next = odd.next.next;
            evn.next = evn.next.next;
            
            odd = odd.next;
            evn = evn.next;
        }
        odd.next = even;
        return head;
    }

    public int numTrees(int n) {
        int dp[] = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1]; 
            } 
        }
        return dp[n];
    }
}
