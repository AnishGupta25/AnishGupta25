import java.util.*;
public class day83 {
    int maxLen(int arr[], int n){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0; 
        int max_len = 0;
        
        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            if(arr[i] == 0 && max_len == 0) max_len = 1;
            
            if(sum == 0) max_len = i + 1;
            
            Integer prev_idx = hm.get(sum);
            
            if(prev_idx != null) max_len = Math.max(max_len , i - prev_idx);
            else hm.put(sum , i);
        }
        return max_len;
    }

    public void deleteNode(ListNode node) {
        if(node.next.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
        else if(node.next.next == null){
            node.val = node.next.val;
            node.next = null;
        }
    }
}
