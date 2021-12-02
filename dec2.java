import java.util.*;
public class dec2 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evn = head.next;
        
        while(evn != null && evn.next != null){
            odd.next = odd.next.next;
            evn.next = evn.next.next;
            
            odd = odd.next;
            evn = evn.next;
        }
        odd.next = even;
        return head;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else{
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }

    class TreeNode{
        TreeNode left , right;
        int val;
        TreeNode(){}
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int lht = maxDepth(root.left);
        int rht = maxDepth(root.right);
        
        return Math.max(lht , rht) + 1;
    }

    public void rotate(int[][] mat) {
        int n = mat.length;
        
        for(int i = 0; i < n; i++){
            int l = 0, r = n-1;
            
            while(l < r){
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++;
                r--;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[n - j -1][n - i - 1];
                mat[n - j -1][n - i - 1] = temp;
            }
        }
    }
}
