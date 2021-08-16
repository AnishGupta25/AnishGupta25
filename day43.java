import java.util.ArrayList;
import java.util.HashMap;

public class day43 {
    Node reverseList(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        
        while(cur != null){
            Node fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        return prev;
    }

    public Node pairwiseSwap(Node head){
        if(head == null || head.next == null) return head;
        
        Node slow = head;
        Node fast = head.next;
        head = fast;
        while(true){
            Node fwd = fast.next;
            fast.next = slow;
            if(fwd == null || fwd.next == null){
                slow.next = fwd;
                break;
            }
            slow.next = fwd.next;
            slow = fwd;
            fast = slow.next;
        }
        return head;
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])) return true;
            else hm.put(nums[i] , 1);
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                int idx = hm.get(nums[i]);
                if(Math.abs(i - idx) <= k) return true;
            }
            hm.put(nums[i] , i);
        }
        return false;
    }

    public ArrayList<Integer> majorityElement(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i],0)+1);
        }
        for(int key : hm.keySet()){
            if(hm.get(key) > nums.length / 3) res.add(key);
        }
        return res;
    }

    public int countPrimes(int n) {
        if(n <= 2) return 0;
        
        boolean[] primes = new boolean[n];
        int count = 1;
        for(int i = 3; i < n; i+=2){
            if(!primes[i]){
                count++;
                for(int j = 1; j*i < n; j++){
                    primes[j*i] = true;
                }
            }
        }
        return count;
    }
}
