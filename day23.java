import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class day23 {
    static int canRepresentBST(int arr[], int N) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++){
            if(arr[i] < root) return 0;
            
            while(st.size() > 0 && st.peek() < arr[i]){
                root = st.peek();
                st.pop();
            }
            st.push(arr[i]);
        }
        return 1;
    }

    ArrayList<Integer> leftView(Node root){
        if(root == null) return new ArrayList<>();
    
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            res.add(queue.getFirst().data);
            while(size --> 0){
                Node rn = queue.removeFirst();
                if(rn.left != null) queue.addLast(rn.left );
                if(rn.right != null) queue.addLast(rn.right);
            }
            
        }
        return res;
    }

    int height(Node node) {
        if(node == null) return 0;
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        int ht = Math.max(lh , rh) + 1;
        
        return ht;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root , root);
    }
    
    public boolean isMirror(TreeNode node1 , TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        
        return (node1.val == node2.val) && isMirror(node1.left , node2.right) && isMirror(node1.right , node2.left);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        
        int mid = (startIndex + endIndex) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = sortedArrayToBST(nums, startIndex, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, endIndex);
        
        return node;
    }
}
