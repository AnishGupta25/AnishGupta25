import java.util.*;
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
    
    public int numUniqueEmails(String[] emails) {
        if(emails.length == 1) return 1;
        
        HashSet<String> set = new HashSet<>();
        for(String s : emails){
            String[] str = s.split("@");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str[0].length(); i++){
                if(str[0].charAt(i) == '+') break;
                else if(str[0].charAt(i) == '.') continue;
                sb.append(str[0].charAt(i));
            }
            sb.append("@" + str[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
