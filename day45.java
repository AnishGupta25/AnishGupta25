import java.util.ArrayList;

public class day45 {
    public int largestAltitude(int[] gain) {
        if(gain.length == 0) return 0;
        
        int sum = 0;
        int maxAlti = -1000000;
        for(int i = 0; i < gain.length; i++){
            sum += gain[i];
            if(sum > maxAlti) maxAlti = sum;
            if(maxAlti < 0) maxAlti = 0;
        }
        return maxAlti;
    }

    public static class ListNode {
        int val = 0;
        ListNode next = null;
    
        ListNode(int val) {
          this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
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

    public static void getPath(int[][] m , int n , String psf , int row , int col , boolean[][] visited , ArrayList<String> list){
        if(row < 0 || col < 0 || row == n || col == n || m[row][col] == 0 || visited[row][col] == true) return;
        
        if(row == n-1 && col == n-1){
            list.add(psf);
            // System.out.println(psf + " ");
            return;
        }
        visited[row][col] = true;
        
        getPath(m , n , psf+"D" , row + 1 , col , visited , list);
        getPath(m , n , psf+"L" , row , col - 1 , visited , list);
        getPath(m , n , psf+"R" , row , col + 1 , visited , list);
        getPath(m , n , psf+"U" , row - 1 , col , visited , list);
        
        visited[row][col] = false;
    }

    int intersectPoint(ListNode head1, ListNode head2){
        // if(head1 == null || head2 == null) return null;
         
        ListNode temp1 = head1;
        ListNode temp2 = head2;
         
         while(temp1 != temp2){
             temp1 = temp1 == null ? head2 : temp1.next;
             temp2 = temp2 == null ? head1 : temp2.next;
         }
         return temp1.val;
     }
}
