import java.util.*;
public class feb5 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a , b) ->{
            return a.val - b.val;
        });
        for(ListNode l : lists) if(l != null) pq.add(l);
       
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(pq.size() > 0){
            ListNode node = pq.remove();
            prev.next = node;
            prev = prev.next;
            node = node.next;
            if(node != null) pq.add(node);
        }
        return dummy.next;
    }
}
