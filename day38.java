public class day38 {
    public void flatten(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left != null){
            TreeNode tail = Tail(root.left);
            tail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    public TreeNode Tail(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode node1 = head;
        ListNode node2 = head.next;
        
        while(node2 != null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
            
            if(node2.next != null){
                node1 = node2.next;
                node2 = node1.next;
            }
            else node2 = node2.next;
        }
        return head;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return overlap(rec1[0] , rec1[2] , rec2[0] , rec2[2]) && overlap(rec1[1] , rec1[3] , rec2[1] , rec2[3]);
    }
    
    public boolean overlap(int a1 , int a2 ,int b1 , int b2){
        if(a2 <= b1 || b2 <= a1) return false;
        return true;
    }
}
