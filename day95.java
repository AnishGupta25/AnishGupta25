import java.util.*;
public class day95 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(root , 0 , 0));
        
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        
        while(pq.size() > 0){
            Pair temp = pq.remove();
            min = Math.min(min , temp.x);
            max = Math.max(max , temp.x);
            
            if(!map.containsKey(temp.x)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.node.val);
                map.put(temp.x , list);
            }
            else{
                ArrayList<Integer> list = map.get(temp.x);
                list.add(temp.node.val);
                map.put(temp.x , list);
            }
            
            if(temp.node.left != null) pq.add(new Pair(temp.node.left , temp.x - 1, temp.y +1));
            if(temp.node.right != null) pq.add(new Pair(temp.node.right , temp.x + 1, temp.y +1));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
    
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int x , y;
        Pair(TreeNode node , int x , int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o){
            if(this.y != o.y) return this.y - o.y;
            else if(this.x != o.x) return this.x - o.x;
            else return this.node.val - o.node.val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        
        while(qu.size() > 0){
            int size = qu.size();
            ArrayList<Integer> arr = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = qu.remove();
                while(temp != null){
                    arr.add(temp.val);
                    if(temp.left != null) qu.add(temp.left);
                    temp = temp.right;
                }
            }
            list.add(arr);
        }
        return list;
    }
}
