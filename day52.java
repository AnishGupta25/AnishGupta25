import java.util.ArrayList;
import java.util.Stack;
public class day52 {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        
        while(l <= r){
            if(((l*l) + (r*r)) < c) l++;
            else if(((l*l) + (r*r)) > c) r--;
            else return true;
        }
        return false;
    }

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            while(!st.isEmpty() && list.get(st.peek()) < list.get(i)){
                arr[st.pop()] = list.get(i);
            }
            st.push(i);
        }
        return arr;
    }
}
