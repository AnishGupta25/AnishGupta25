import java.util.*;
public class nov22 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode temp = head , prev = head;
        
        while(temp != null && temp.val == val) temp = temp.next;
        
        head = temp;
        
        while(temp != null){
            if(temp.val == val){
                prev.next = temp.next;
                temp = temp.next;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
