public class day51 {

    class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public static boolean detectLoop(Node head){
        if(head == null) return false;
        
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) return true;
        }
        return false;
    }

    public static void removeLoop(Node head){
        if(head == null) return;
        
        Node fast = head;
        Node slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow){
                break;
            }
        }
        
        if (slow == fast){
            fast = head;
            if (slow != fast){
                while(slow.next != fast.next){
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = null;
            }
            else {
                while(slow.next != fast){
                    slow = slow.next;
                }
                slow.next = null;
            }
        }
        
    }
}
