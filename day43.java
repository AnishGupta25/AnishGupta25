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

    public Node pairwiseSwap(Node head){
        if(head == null || head.next == null) return head;
        
        Node slow = head;
        Node fast = head.next;
        head = fast;
        while(true){
            Node fwd = fast.next;
            fast.next = slow;
            if(fwd == null || fwd.next == null){
                slow.next = fwd;
                break;
            }
            slow.next = fwd.next;
            slow = fwd;
            fast = slow.next;
        }
        return head;
    }
}
