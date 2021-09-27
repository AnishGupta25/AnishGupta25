public class day85 {
    public class Codec {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
        public String serialize(TreeNode root) {
            if(root == null) return "#";
            
            String ls = serialize(root.left);
            String rs = serialize(root.right);
            
            return root.val + " " + ls + " " + rs;
        }
        public TreeNode deserialize(String data) {
            String[] str = data.split(" ");
            i = 0;
            return helper(str);
        }
        int i;
        public TreeNode helper(String[] str){
            if(i >= str.length || str[i].equals("#")){
                i++;
                return null;
            } 
            
            TreeNode node = new TreeNode(Integer.parseInt(str[i++]));
            
            node.left = helper(str);
            node.right = helper(str);
            
            return node;
        }
    }
    
}
