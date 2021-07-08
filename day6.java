public class day6 {
    int getNthFromLast(Node head, int n){
        int size = 0;
        Node temp = head;
        
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n > size || n < 0){
            return -1;
        }
        temp = head;
        
        while(n > 0){
            temp = temp.next;
            n--;
        }
        
        while(temp != null){
            temp = temp.next;
            head = head.next;
        }
        
        return head.data;
    }
}
