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
}
