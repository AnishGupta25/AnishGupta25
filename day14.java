public class day14 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root , 0));
        List<Integer> res = new ArrayList<>();
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 0){
                if(top.node.left != null) st.push(new Pair(top.node.left , 0));
                top.state++;
            }
            else if(top.state == 1){
                if(top.node.right != null) st.push(new Pair(top.node.right , 0));
                res.add(top.node.val);
                top.state++;
            }
            else{
                st.pop();
            }
        }
        
        return res;
    }
    static class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node ,int state){
            this.node = node;
            this.state = state;
        }
    }
}
