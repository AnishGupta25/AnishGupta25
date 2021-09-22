public class day80 {
    static int repeatedStringMatch(String A, String B) { 
	    int ans = 1;
	    String str = A;
	    while(str.length() < B.length()){
	        str += A;
	        ans++;
	    }
	    if(isSubstring(str , B)) return ans;
	    if(isSubstring(str+A , B)) return ans+1;
	    
	    return -1;
	} 
	
	static boolean isSubstring(String str , String B){
	    int n = str.length() , m = B.length();
	    
	    for(int i = 0; i <= n - m; i++){
	        int j;
	        for(j = 0; j < m; j++){
	            if(str.charAt(i+j) != B.charAt(j)) break;
	        }
	        if(j == m) return true;
	    }
	    return false;
	}

	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

	public static ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;
        
        while(temp.next != null){
            int val = temp.val;
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            } 
        }
        return head;
    }

	public static boolean isCyclePresentInLL(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

	public static ListNode CycleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

	public static int size(ListNode head){
        ListNode temp = head;
        int ans = 0;
        while(temp != null){
            ans++;
            temp = temp.next;
        }
        return ans;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int size1 = size(headA);
        int size2 = size(headB);
        
        if(size1 > size2){
            while(size1 != size2){
                headA = headA.next;
                size1--;
            }
        }
        if(size1 < size2){
            while(size2 != size1){
                headB = headB.next;
                size2--;
            }
        }
        
        while(headA != null && headB != null){
            if(headA == headB)return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

	public static ListNode IntersectionNodeInTwoLL2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        while(temp1 != temp2){
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }

    public class TreeNode{
        int val;
        TreeNode left , right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int lht = height(root.left);
        int rht = height(root.right);
        
        if(Math.abs(lht - rht) > 1) return false;
        
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left) , height(root.right)) + 1;
    }
}
