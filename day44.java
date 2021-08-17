import java.util.Collections;
import java.util.HashMap;
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

    public static int doUnion(int a[], int n, int b[], int m) {
        HashMap<Integer , Integer> elem = new HashMap<>();
        
        for(int i : a){
            elem.put(i , elem.getOrDefault(i,0)+1);
        }
        for(int i : b){
            elem.put(i , elem.getOrDefault(i,0)+1);
        }
        
        return elem.size();
    }
}
