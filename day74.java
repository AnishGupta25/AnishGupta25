import java.util.*;
public class day74 {
    public List<Integer> spiralOrder(int[][] mat) {
        int rmin = 0, cmin = 0, rmax = mat.length - 1, cmax = mat[0].length - 1;
        int count = 0 , tw = mat.length *  mat[0].length;
        List<Integer> ans = new ArrayList<>();
        while(count < tw){
            for(int i = rmin , j = cmin; j <= cmax && count < tw; j++){
                ans.add(mat[i][j]);
                count++;
            }
            for(int i = rmin + 1 , j = cmax; i <= rmax && count < tw; i++){
                ans.add(mat[i][j]);
                count++;
            }
            for(int i = rmax , j = cmax - 1; j >= cmin && count < tw; j--){
                ans.add(mat[i][j]);
                count++;
            }
            for(int i = rmax - 1 , j = cmin; i > rmin && count < tw; i--){
                ans.add(mat[i][j]);
                count++;
            }
            rmin++;
            cmin++;
            rmax--;
            cmax--;
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    boolean[][] vis = new boolean[grid.length][grid[0].length];
                    count = 0;
                    maxAreaOfIslandHelper(grid , i , j , vis);
                    if(count > ans) ans = count;
                    count = 0;
                }
            }
        }
        return ans;
    }
    
    public int count;
    public void maxAreaOfIslandHelper(int[][] grid , int row , int col , boolean[][] vis){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] != 1) return;
        
        if(grid[row][col] == 1){
            vis[row][col] = true;
            count++;
        }
        
        maxAreaOfIslandHelper(grid , row - 1 , col , vis);
        maxAreaOfIslandHelper(grid , row , col - 1 , vis);
        maxAreaOfIslandHelper(grid , row , col + 1 , vis);
        maxAreaOfIslandHelper(grid , row + 1 , col , vis);
    }

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            ans.next = node;
            ans = node;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        ans = reverse(dummy.next);
        return ans;
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;
    }
}
