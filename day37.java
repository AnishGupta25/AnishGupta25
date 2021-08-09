import java.util.Arrays;

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
}
