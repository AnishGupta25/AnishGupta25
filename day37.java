import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class day37 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a , b)->{
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        
        int initial = 0;
        int cur_energy = 0;
        
        for(int i = 0; i < tasks.length; i++){
            if(cur_energy < tasks[i][1]){
                initial += tasks[i][1] - cur_energy;
                cur_energy = tasks[i][1];
            }
            cur_energy -= tasks[i][0];
        }
        return initial;
    }

    public Node connect(Node root) {
        if(root == null) return root;
        helper(root);
        return root;
    }
    
    public void helper(Node node){
        if(node == null) return;
        
        if(node.left != null && node.right != null){
            node.left.next = node.right;
        }
        if(node.next != null && node.right != null){
            node.right.next = node.next.left;
        }
        
        helper(node.left);
        helper(node.right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        ListNode slow = head , fast = head , preslow = null;
        while(fast != null && fast.next != null){
            preslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(preslow != null) preslow.next = null;
        if(slow == null) return null;
        
        TreeNode root = new TreeNode(slow.val);
        
        if(head != slow) root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }

    public MedianFinder() {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(right.size() > 0 && num > right.peek()){
            right.add(num);
        }
        else {
            left.add(num);
        }
        int gap = left.size() - right.size();
        if(gap > 1){
            right.add(left.remove());
        }
        else if(gap < -1){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()){
            return left.peek() * 1.0;
        }
        else if(right.size() > left.size()){
            return right.peek() * 1.0;
        }
        else{
            return (left.peek()*1.0 + right.peek()*1.0)/2;
        }
    }

    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        Queue<Node> Helperque = new ArrayDeque<>();
        
        while(que.size() > 0){
            Node temp = que.remove();
            if(temp.left != null) Helperque.add(temp.left);
            if(temp.right != null) Helperque.add(temp.right);
            while(que.size() > 0){
                Node curr = que.remove();
                if(curr.left != null) Helperque.add(curr.left);
                if(curr.right != null) Helperque.add(curr.right);
                temp.next = curr;
                temp = curr;
            }
            if(que.size() == 0){
                que = Helperque;
                Helperque = new ArrayDeque<>();
            }
            
        }
        return root;
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        
        return Math.min(minDepth(root.left) , minDepth(root.right)) + 1;
    }
}
