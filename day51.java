import java.util.HashSet;
import java.util.ArrayList;
public class day51 {

    class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public static boolean detectLoop(Node head){
        if(head == null) return false;
        
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) return true;
        }
        return false;
    }

    public static void removeLoop(Node head){
        if(head == null) return;
        
        Node fast = head;
        Node slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow){
                break;
            }
        }
        
        if (slow == fast){
            fast = head;
            if (slow != fast){
                while(slow.next != fast.next){
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = null;
            }
            else {
                while(slow.next != fast){
                    slow = slow.next;
                }
                slow.next = null;
            }
        }
        
    }

    public ArrayList<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])) set.add(nums[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }

    public ArrayList<Integer> findDisappearedNumbers2(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] arr = new int[nums.length +1];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
        }
        for(int i = 1; i <= nums.length; i++){
            if(arr[i] < 1) ans.add(i);
        }
        return ans;
    }

    public int getMaximumGenerated(int n) {
        if(n == 0 || n == 1) return n;
        
        int[] nums = new int[n+1];
        
        nums[0]=0;
        nums[1]=1;
        int max = Integer.MIN_VALUE;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0) nums[i] = nums[i / 2];
            else nums[i] = nums[i / 2] + nums[(i / 2) + 1];
            
            max = Math.max(max , nums[i]);
        }
        return max;
    }
}
