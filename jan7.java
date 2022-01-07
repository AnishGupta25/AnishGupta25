public class jan7 {
    class Solution {
        class ListNode{
            ListNode next;
            int val;
        }
        ListNode head;
        public Solution(ListNode head) {
            this.head = head;
        }
        
        public int getRandom() {
            int range = 1 , ans = 0;
            ListNode cur = this.head;
            
            while(cur != null){
                if(Math.random() < 1.0 / range) ans = cur.val;
                range += 1;
                cur = cur.next;
            }
            return ans;
        }
    }
}

