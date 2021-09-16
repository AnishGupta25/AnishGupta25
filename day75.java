import java.util.*;
public class day75 {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0, x = 0;
        for(int i = 0; i < k; i++){
            int val1 = j < arr1.length ? arr1[j] : Integer.MAX_VALUE;
            int val2 = x < arr2.length ? arr2[x] : Integer.MAX_VALUE;
            if(val1 <= val2){
                pq.add(val1);
                j++;
            } 
            else{
                pq.add(val2);
                x++;
            } 
        }
        return new Long(pq.poll());
    }
}
