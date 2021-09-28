import java.util.*;
public class day86 {
    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        
        int i = 0, j = 0 ,k = nums.length-1;
        
        while(i <= k){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            }
            else{
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
            }
        }
    }

    public Stack<Integer> sort(Stack<Integer> s){
	    if(!s.isEmpty()){
	        sortst(s);
	    }
	    return s;
	}
	
	public void sortst(Stack<Integer> st){
	    if(!st.isEmpty()){
	        int temp = st.pop();
	        sortst(st);
	        InsertSort(st , temp);
	    }
	}
	public void InsertSort(Stack<Integer> st , int elm){
	    if(st.isEmpty() || st.peek() < elm){
	        st.push(elm);
	        return;
	    }
	    
	    int temp = st.pop();
	    InsertSort(st , elm);
	    st.push(temp);
	}

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = Mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        return Merge(sortList(head) , sortList(nhead));
    }
    
    public ListNode Merge(ListNode l1 , ListNode l2){
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            }
            else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l1 != null) res.next = l1;
        if(l2 != null) res.next = l2;
        return dummy.next;
    }
    
    public ListNode Mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
