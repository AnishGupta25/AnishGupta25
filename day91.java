import java.util.*;
public class day91 {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(adj , vis , i)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj , boolean[] vis , int src){
        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(src , -1));
        vis[src] = true;
        while(pq.size() > 0){
            int cur = pq.peek().src;
            int par = pq.remove().par;
            
            for(Integer i : adj.get(cur)){
                if(!vis[i]){
                    pq.add(new Pair(i , cur));
                    vis[i] = true;
                }
                else if(i != par) return true;
            }
        }
        return false;
    }
    
    class Pair {
        int src;
        int par;
    
        Pair(int src, int par) {
          this.src = src;
          this.par = par;
        }
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board , 0 , 0);
    }
    
    public boolean solveSudokuHelper(char[][] board , int i , int j){
        if(j == board[0].length){
            i = i + 1;
            j = 0;
        }
        
        if(i == board.length) return true;
        
        if(board[i][j] != '.') return solveSudokuHelper(board , i , j+1);
        
        for(char num = '1'; num <= '9'; num++){
            if(isValid(board, i , j , num)){
                board[i][j] = num;
                boolean solved = solveSudokuHelper(board , i , j+1);
                if(solved) return true;
                else board[i][j] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board , int i , int j , char num){
        for (int r = 0; r < board.length; r++) {
          if (board[r][j] == num) return false;
        }
        for(int c = 0; c < board.length; c++){
            if (board[i][c] == num) return false;
        }
        
        int x = (i / 3) * 3;
        int y = (j / 3) * 3;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(board[x + r][y + c] == num) return false;
            }
        }
        return true;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        
        while(!qu.isEmpty()){
            int size = qu.size();
            TreeNode temp = null;
            while(size-- > 0){
                temp = qu.remove();
                if(temp.left != null) qu.add(temp.left);
                if(temp.right != null) qu.add(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }

    class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node sortedMerge(Node head1, Node head2) {
        if(head1 == null || head2 == null) return head1 == null ? head2 : head1;
        
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                res.next = head1;
                head1 = head1.next;
            }
            else{
                res.next = head2;
                head2 = head2.next;
            }
            res = res.next;
        }
        if(head1 != null) res.next = head1;
        if(head2 != null) res.next = head2;
        
        return dummy.next;
    } 

    class Node2{
    int data;
    Node2 left, right;

    Node2(int item){
        data = item;
        left = right = null;
    }
} 

    int getMaxWidth(Node2 root) {
        if(root == null) return 0;
        
        Queue<Node2> qu = new ArrayDeque<>();
        qu.add(root);
        int max = 1;
        
        while(!qu.isEmpty()){
            int n = qu.size();
            max = Math.max(n , max);
            
            while(n-- > 0){
                Node2 node = qu.remove();
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
        }
        return max;
    }
}
