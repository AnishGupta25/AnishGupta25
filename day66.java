public class day66 {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }

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
}
