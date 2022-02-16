public class feb16 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode node1 = head;
        ListNode node2 = head.next;
        
        while(node2 != null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
            
            if(node2.next != null){
                node1 = node2.next;
                node2 = node1.next;
            }
            else node2 = node2.next;
        }
        return head;
    }
}
