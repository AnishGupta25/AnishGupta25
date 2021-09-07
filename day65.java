import java.util.*;
public class day65 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    class GfG{
        int minEle;
        Stack<Integer> st;
        GfG(){
            st = new Stack<>();
        }
        int getMin(){
            if(st.isEmpty()) return (-1);
            
            return minEle;
        }
        int pop(){
            if(st.isEmpty()) return (-1);
            
            int t = st.pop();
            if(t < minEle){
                int temp = minEle;
                minEle = 2*minEle - t;
                return temp;
            }
            return t;
        }
        void push(int x){
            if(st.size() == 0){
                minEle = x;
                st.push(x);
                return;
            }
            if(x < minEle){
                st.push(2*x - minEle);
                minEle = x;
            }
            else st.push(x);
        }	
    }

    public boolean isThree(int n) {
        int count = 2;
        
        for(int i = 2; i < n-1; i++){
            if(n % i == 0) count++;
        }
        if(count == 3) return true;
        return false;
    }

    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public Node rotate(Node head, int k) {
        Node temphead = head;
        int count = 1;
        while(count < k && temphead != null){
            count++;
            temphead = temphead.next;
        }
        if(temphead == null) return head;
        
        Node kthnode = temphead;
        
        while(temphead.next != null){
            temphead = temphead.next;
        }
        temphead.next = head;
        
        head = kthnode.next;
        kthnode.next = null;
        
        return head;
    }
}
