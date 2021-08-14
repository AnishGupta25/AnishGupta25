public class day41 {
    public void setZeroes(int[][] matrix) {
        int col = 1;
        int n = matrix.length , m = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0) col = 0;
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col == 0) matrix[i][0] = 0;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        
        int size = size(head);
        if(size < k) return head;
        
        ListNode OrigHead = null;
        ListNode OrigTail = null;
        ListNode curr = head;
        
        while(size >= k){
            int tempk = k;
            while(tempk-- > 0){
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = fwd;
            }
            if(OrigHead == null){
                OrigHead = tempHead;
                OrigTail = tempTail;
            }
            else{
                OrigTail.next = tempHead;
                OrigTail = tempTail;
            }
            size -= k;
            tempHead = null;
            tempTail = null;
        }
        OrigTail.next = curr;
        return OrigHead;
    }
    ListNode tempHead = null;
    ListNode tempTail = null;
    public void addFirst( ListNode node){
        if(tempHead == null){
            tempHead = node;
            tempTail = node;
        }
        else{
            node.next = tempHead;
            tempHead = node;
        }
    }
    
    public int size(ListNode head){
        ListNode temp = head;
        int size = 0;
        
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
}
