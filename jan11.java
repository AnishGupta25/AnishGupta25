import java.util.*;
public class jan11 {
    class TreeNode{
        TreeNode right , left;
        int val;
    }
    class Pair(){
        TreeNode node;
        int val;
        Pair(TreeNode node , int val){
            this.node = node;
            this.val = val;
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currNumber = p.getValue();

            if (root != null) {
                currNumber = (currNumber << 1) | root.val;
                if (root.left == null && root.right == null) {
                    rootToLeaf += currNumber;
                } 
                else {
                    stack.push(new Pair(root.right, currNumber));
                    stack.push(new Pair(root.left, currNumber));
                }
            }
        }
        return rootToLeaf;
    }
}
