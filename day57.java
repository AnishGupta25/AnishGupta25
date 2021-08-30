import java.util.*;
public class day57 {
    public String reverseParentheses(String s) {
        if(s.length() == 0) return s;
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                Queue<Character> qu = new ArrayDeque<>();
                while(st.peek() != '('){
                    qu.add(st.pop());
                }
                st.pop();
                while(qu.size() > 0){
                    st.push(qu.remove());
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        while(st.size() > 0){
            str.append(st.pop());
        }
        
        return str.reverse().toString();
    }

    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(a,Math.max(b,c)) , min = Math.min(a,Math.min(b,c)) , mid = a+b+c-max-min;
        
        int res[] = new int[2];
        res[1] = max - min - 2; 
        
        if(max - mid == 1 && mid - min == 1) res[0] = 0;
        else if(max - mid <= 2 || mid - min <= 2) res[0] = 1;
        else res[0] = 2;
        
        return res;
    }

    class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }

    boolean isPalindrome(Node head) {
        left = head;
        return isPalindromehelper(head);
    }
    Node left;
    
    boolean isPalindromehelper(Node right){
        if(right == null) return true;
        
        boolean ress = isPalindromehelper(right.next);
        if(!ress) return false;
        else if(left.data != right.data) return false;
        else left = left.next; return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public ArrayList<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return new ArrayList<>();
        
        ArrayList<TreeNode> forest = new ArrayList<>();
        HashSet<Integer> delete = new HashSet<>();
        for(int i : to_delete){
            delete.add(i);
        }
        
        if(!delete.contains(root.val)){
            forest.add(root);
        }
        delNodeshelper(root , null , forest , delete);
        return forest;
    }
    
    public void delNodeshelper(TreeNode root , TreeNode parent , ArrayList<TreeNode> forest , HashSet<Integer> delete){
        if(root == null) return;
        
        delNodeshelper(root.left , root , forest , delete);
        delNodeshelper(root.right , root , forest , delete);
        
        if(delete.contains(root.val)){
            unlink(root , parent);
            if(root.left != null){
                forest.add(root.left);
            }
            if(root.right != null){
                forest.add(root.right);
            }
        }
    }
    
    public void unlink(TreeNode root , TreeNode parent){
        if(parent == null || root == null) return;
        
        if(parent.left == root){
            parent.left = null;
        }
        else{
            parent.right = null;
        }
    }
}
