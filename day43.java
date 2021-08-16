public class day43 {
    Node reverseList(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        
        while(cur != null){
            Node fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;
    }
}
