import java.util.Collections;
import java.util.PriorityQueue;

public class day44 {
    public static int kthSmallest(int[] arr, int l, int r, int k) { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i <= r; i++){
            if(pq.size() < k){
                pq.add(arr[i]);
            }
            else if(pq.peek() > arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    } 
}
