import java.util.*;
public class nov21 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            
            Integer count = map.get(ch);
            
            if(count == null) return false;
            else if(count > 1) map.put(ch , map.getOrDefault(ch , 0) - 1);
            else if(count == 1) map.remove(ch);
        }
        return true;
    }

    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(nums[0] != nums[i + 1]) return nums[0];
            }
            else if(i == nums.length - 1){
                if(nums[i] != nums[i - 1]) return nums[i];
            }
            else if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
        }
        return 0;
    }

    public boolean isValid(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        
        for(int i = 1; i < n; i++){
            char ch = chars[i];
            
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                st.push(ch);
            }
            
            else{
                if(st.size() == 0) return false;
                char pre = st.peek();
                if(pre == '(' && chars[i] == ')') st.pop();
                else if(pre == '[' && chars[i] == ']') st.pop();
                else if(pre == '{' && chars[i] == '}') st.pop();
                
                else return false;
            }
        }
        
        if(st.size() > 0) return false;
        return true;
    }

    class ListNode{
        ListNode next;
        int val;
        ListNode(ListNode next , int val){
            this.next = next;
            this.val = val;
        }
        ListNode(int val){
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                r.next = l1;
                l1 = l1.next;
                r = r.next;
            }
            else if(l2.val < l1.val){
                r.next = l2;
                l2 = l2.next;
                r = r.next;
            }
        }
        if(l1 != null) r.next = l1;
        if(l2 != null) r.next = l2;
        
        return res.next;
    }
}
