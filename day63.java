import java.util.*;
public class day63 {
    static int findLongestConseqSubseq(int arr[], int N){
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 0; i < N; i++){
	        set.add(arr[i]);
	    }
	    int count = 0;
	    
	    for(int i = 0; i < N; i++){
	        if(!set.contains(arr[i] - 1)){
	            int temp = arr[i];
	            while(set.contains(temp)){
	                temp++;
	            }
	            if(count < temp - arr[i]){
	                count = temp - arr[i];
	            }
	        }
	    }
	    return count;
	}

	public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : hand){
            pq.add(i);
        }
        
        while(!pq.isEmpty()){
            int head = pq.poll();
            
            for(int i = 1; i < groupSize; i++){
                if(!pq.remove(head+i)) return false;
            }
        }
        return true;
    }
}
