public class day81 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode pivit(ListNode head){
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sh = new ListNode(-1);
        ListNode st = sh;
        
        ListNode lh = new ListNode(-1);
        ListNode lt = lh;
        
        ListNode last = pivit(head);
        
        ListNode cur = head;
        while(cur != null){
            if(cur.val <= last.val){
                st.next = cur;
                st = st.next;
            }
            else{
                lt.next = cur;
                lt = lt.next;
            }
            cur = cur.next;
        }
        lt.next = null;
        st.next = lh.next;
        return st;
    }

    public static ListNode getPivot(ListNode head , int idx){
        ListNode temp = head;
        
        while(idx-- > 0){
            temp = temp.next;
        }
        return temp;
    }
    
    public static ListNode segregate(ListNode head, int pivotIdx) {
        ListNode pivot = getPivot(head , pivotIdx);
        int pd = pivot.val;
        
        ListNode sh = new ListNode(-1);
        ListNode st = sh;
        
        ListNode lh = new ListNode(-1);
        ListNode lt = lh;
        
        ListNode cur = head;
        while(cur != null){
            if(cur == pivot){}
            else if(cur.val <= pd){
                st.next = cur;
                st = st.next;
            }
            else if(cur.val > pd){
                lt.next = cur;
                lt = lt.next;
            }
            cur = cur.next;
        }
        
        lt.next = null;
        st.next = pivot;
        pivot.next = lh.next;
        
        return sh.next;
    }

    public static ListNode segregate012(ListNode head) {
        ListNode one = new ListNode(-1);
        ListNode onet = one;
        
        ListNode zero = new ListNode(-1);
        ListNode zerot = zero;
        
        ListNode two = new ListNode(-1);
        ListNode twot = two;
        
        ListNode temp = head;
        while(temp != null){
            if(temp.val == 0){
                zerot.next = temp;
                zerot = zerot.next;
            }
            if(temp.val == 1){
                onet.next = temp;
                onet = onet.next;
            }
            if(temp.val == 2){
                twot.next = temp;
                twot = twot.next;
            }
            temp = temp.next;
        }
        twot.next = null;
        
        onet.next = two.next;
        zerot.next = one.next;
        
        return zero.next;
    }

    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        
        char[] str = palindrome.toCharArray();
        for(int i = 0; i < str.length / 2; i++){
            if(str.length % 2 == 1 && i == str.length / 2) continue;
            if(str[i] != 'a') {
                str[i] = 'a';
                return String.valueOf(str);
            }
        }
        str[str.length - 1] ='b';
        return String.valueOf(str);
    }
}
