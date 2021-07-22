public class day19 {
    static int[] SortBinaryArray(int arr[], int n) { 
	    int i = 0, j = 0;
	    
	    while(i < n){
	        if(arr[i] == 1){
	            i++;
	        }
	        else{
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            
	            j++;
	            i++;
	        }
	    }
	    
	    return arr;
	} 

    ArrayList<Integer> inOrder(Node root){
        Stack<TreePair> st = new Stack<>();
        st.push(new TreePair(root , 0));
        ArrayList<Integer> res = new ArrayList<>();
        
        while(st.size() > 0){
            TreePair top = st.peek();
            if(top.state == 0){
                top.state++;
                if(top.root.left != null) st.push(new TreePair(top.root.left , 0));
            }
            else if(top.state == 1){
                res.add(top.root.data);
                top.state++;
                if(top.root.right != null) st.push(new TreePair(top.root.right , 0));
            }
            else{
                st.pop();
            }
        }
        return res;
    }
    
    class TreePair{
        Node root;
        int state;
        TreePair(Node root, int state){
            this.root = root;
            this.state = state;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(head.val);
        ListNode node = res;
        ListNode prev = head.next;
        while(prev != null){
            if(prev.val == node.val){
                prev = prev.next;
            }
            else{
                ListNode temp = new ListNode(prev.val);
                node.next = temp;
                node = node.next;
            }
        }
        return res;
    }
}
