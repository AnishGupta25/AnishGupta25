public class day29 {
    public static class info{
        int num_bst , max , min;
        boolean isbst;
        info(int num_bst , int max , int min , boolean isbst){
            this.num_bst = num_bst;
            this.max = max;
            this.min = min;
            this.isbst = isbst;
        }
    }
      
    public static info NumberOfBST(Node node){
        if(node == null) return new info(0, Integer.MIN_VALUE,Integer.MAX_VALUE, true);
        if (node.left == null && node.right == null) return new info(1, node.data,node.data, true);
        
        info L = NumberOfBST(node.left);
        info R = NumberOfBST(node.right);
        
        // info bst = new info();
        int min = Math.min(node.data, (Math.min(L.min, R.min)));
        int max = Math.max(node.data, (Math.max(L.max, R.max)));
        boolean isbst = false;
        int num_bst = L.num_bst + R.num_bst;
        if (L.isbst && R.isbst && node.data > L.max && node.data < R.min){
            isbst = true;
            num_bst = 1 + L.num_bst + R.num_bst;
        }
        return new info(num_bst , max , min , isbst);
    }
}
